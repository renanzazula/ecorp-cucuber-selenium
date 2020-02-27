package newVersion.common.glue;

import com.crealogix.common.core.BaseE2ETest;
import com.crealogix.common.utils.JsonUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * This class contains all the steps to edit the current test state.
 * <p>See the readme.md file to get more information about the steps.
 */
public class TestStateGlue extends BaseE2ETest {

    @Value("${com.crealogix.e2eTest.bearerToken.noscope}")
    private String noScopeBearerToken;

    /** See the readme.md file to get more information about this step. */
    @Given("that all file paths will be relative to {string}")
    public void thatAllFilePathsWillBeRelativeTo(String basePath) {
        fileBasePath = basePath;
    }

    /** See the readme.md file to get more information about this step. */
    @Given("that all URL's will be relative to {string}")
    public void thatAllURLSWillBeRelativeTo(String basePath) {
        urlBasePath = basePath;
    }

    /** See the readme.md file to get more information about this step. */
    @Given("that we use the no scopes bearer token")
    public void thatUseNoScopesBearerToken() {
        bearerToken = noScopeBearerToken;
    }

    /** See the readme.md file to get more information about this step. */
    @Given("that we use {string} as the body")
    public void thatWeUseAsTheBody(String pathToFile) throws Exception {
        editableBody = readFile(pathToFile);
    }

    /** See the readme.md file to get more information about this step. */
    @When("we set the value of the body property {string} to {string}")
    public void weSetTheValueOfTheBodyPropertyTo(String propertyPath, String value) {
        String safePropertyPath = "/" + propertyPath.replace(".", "/");

        if ("null".equals(value)){
            editableBody = JsonUtils.removeJsonField(editableBody, safePropertyPath);
        } else if (value.matches("\\d* characters")) {
            Integer numOfChars = Integer.parseInt(value.split(" ")[0]);
            String newValue = StringUtils.rightPad("", numOfChars, "1234567890");
            editableBody = JsonUtils.editJsonField(editableBody, safePropertyPath, newValue);
        }else {
            editableBody = JsonUtils.editJsonField(editableBody, safePropertyPath, value);
        }
    }
}
