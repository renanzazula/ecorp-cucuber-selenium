package newVersion.common.glue;

import com.crealogix.common.core.BaseE2ETest;
import cucumber.api.java.en.Then;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class contains all the HTTP response validation related steps.
 * <p>See the readme.md file to get more information about the steps.
 */
public class ResponseValidationGlue extends BaseE2ETest {

    /** See the readme.md file to get more information about this step. */
    @Then("the status code of the response is {int}")
    public void theStatusCodeOfTheResponseIs(Integer expectedStatusCode) {
        assertThat(latestResponse.getStatusCode().value(), is(expectedStatusCode));
    }

    /** See the readme.md file to get more information about this step. */
    @Then("the body of the response is")
    // TODO: Delete this step and use "theBodyOfTheResponseIsAsIn" instead
    public void theBodyOfTheResponseIs(String expectedBody) {
        compareJson(latestResponse.getBody(), expectedBody);
    }

    /** See the readme.md file to get more information about this step. */
    @Then("the body of the response is as in {string}")
    public void theBodyOfTheResponseIsAsIn(String pathToFile) throws Exception {
        String expectedBody = readFile(pathToFile);
        compareJson(latestResponse.getBody(), expectedBody);
    }

}
