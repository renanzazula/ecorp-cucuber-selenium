package newVersion.common.core;

import com.crealogix.common.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class BaseE2ETest extends Loggable {

    private static final Map<String, Runnable> rollBackConfigurations = new HashMap<>();
    public static ResponseEntity<String> latestResponse = null;
    protected static String fileBasePath = "";
    protected static String urlBasePath = "";
    protected static String bearerToken = "";
    protected static String editableBody = "";
    private static String defaultBearerToken = "";

    public static void addRollBackStep(String operation, Runnable rollback) {
        rollBackConfigurations.put(operation, rollback);
    }

    @Value("${com.crealogix.e2eTest.bearerToken.basic}")
    public void setDefaultBearerToken(String defaultBearerToken) {
        BaseE2ETest.defaultBearerToken = defaultBearerToken;
        if ("".equals(bearerToken))
            bearerToken = defaultBearerToken;
    }

    protected String readFile(String path) throws Exception {
        String name = fileBasePath + path;
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(name);
        if (resourceAsStream == null)
            throw new FileNotFoundException("Could not find the file " + name + " in the class path.");

        return IOUtils.toString(resourceAsStream, Charset.forName("UTF-8"));
    }

    protected void compareJson(String actual, String expected) {
        JsonUtils.assertJsonAreEquals(actual, expected);
    }

    // Needs to be NON-static in order to ensure that "setDefaultBearerToken" is called after "@Value" has initialized the code.
    // If a better solution is found, this method can, and should be, static.
    public void resetState() {
        latestResponse = null;
        fileBasePath = "";
        urlBasePath = "";
        editableBody = "";
        bearerToken = defaultBearerToken;

        for (Map.Entry<String, Runnable> rollbackStep : rollBackConfigurations.entrySet()) {
            try {
                rollbackStep.getValue().run();
            } catch (Throwable e) {
                log.error("Rollback of configurations "+rollbackStep.getKey()+" failed. Next tests will probably report a strange result: STOP execution.", e);
                System.exit(-2);
            }
        }
        rollBackConfigurations.clear();
    }
}
