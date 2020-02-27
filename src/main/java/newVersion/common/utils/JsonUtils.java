package newVersion.common.utils;

import com.crealogix.common.core.Loggable;
import net.javacrumbs.jsonunit.JsonAssert;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.stream.Collectors;

import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;

/**
 * Utility class used to work with JSON objects.
 * <p>This class is <code>static</code> and should always be used like that.
 * <p>This class offers the following <code>static</code> methods:
 * <ul>
 * <li>{@link #assertJsonAreEquals(String, String)}</li>
 * <li>{@link #removeJsonField(String, String)}</li>
 * <li>{@link #editJsonField(String, String, String)}</li>
 * </ul>
 */
public final class JsonUtils extends Loggable {

    private JsonUtils() {
    }

    public static void assertJsonAreEquals(String actual, String expected) {
        try {
            JsonAssert.assertJsonEquals(expected, actual,
                    JsonAssert
                            .withMatcher("isValidDate", new ValidDateMatcher())
                            .when(TREATING_NULL_AS_ABSENT)
                            .withTolerance(0)
            );
        } catch (AssertionError error) {
            // Inline both Json's in order to make it easy to compare them.
            String inlinedActual = JsonUtils.inlineJson(actual);
            String inlinedExpected = JsonUtils.inlineJson(expected);
            log.error("Json comparison failed.\nActual:\n\t" + inlinedActual + "\nExpected:\n\t" + inlinedExpected + "\n");

            // Re-throw error to make the test fail
            throw error;
        }
    }

    /**
     * Utility method used to remove an element from a JSON file.
     * <p>Implements the <b>Remove</b> operation as specified in <a href="https://tools.ietf.org/html/rfc6902#section-4.2">RFC 6902</a>
     * @param originalJson the JSON file from where the field will be removed
     * @param fieldPath    the path to the field we want to remove
     * @return the JSON file without the field
     */
    public static String removeJsonField(String originalJson, String fieldPath) {
        JsonReader jsonReader = Json.createReader(new StringReader(originalJson));
        JsonObject json = jsonReader.readObject();
        jsonReader.close();

        JsonArray patchOps = Json.createArrayBuilder().add(Json.createObjectBuilder()
                .add("op", "remove")
                .add("path", fieldPath)
        ).build();

        return Json.createPatch(patchOps).apply(json).toString();
    }

    /**
     * <p>Utility method used to edit an element from a JSON file.<p>
     * Implements the <b>Add</b> operation as specified in <a href="https://tools.ietf.org/html/rfc6902#section-4.1">RFC 6902</a>
     *
     * @param originalJson the JSON file from where the field will be edited
     * @param fieldPath    the path to the field we want to edit
     * @param newValue     the new value we want for the field
     * @return the JSON file with the field updated
     */
    public static String editJsonField(String originalJson, String fieldPath, String newValue) {
        JsonReader jsonReader = Json.createReader(new StringReader(originalJson));
        JsonObject json = jsonReader.readObject();
        jsonReader.close();

        JsonArray patchOps = Json.createArrayBuilder().add(Json.createObjectBuilder()
                .add("op", "add")
                .add("path", fieldPath)
                .add("value", newValue)
        ).build();

        return Json.createPatch(patchOps).apply(json).toString();
    }

    private static String inlineJson(String json) {
        String nullSafeJson = json != null ? json : "{}";
        return Arrays.stream(nullSafeJson.split("\n"))
                .map(line -> line.replace("\r", ""))
                .map(line -> line.replace("\": ", "\":"))
                .map(String::trim)
                .collect(Collectors.joining(""));
    }

}
