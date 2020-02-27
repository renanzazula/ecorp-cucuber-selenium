package newVersion.common.glue;

import com.crealogix.common.core.BaseE2ETest;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * This class contains all the REST operations related steps.
 * <p>See the readme.md file to get more information about the steps.
 */
public class RESTOperationsGlue extends BaseE2ETest {

    private static final String SERVER_URL = "http://localhost:";
    @LocalServerPort
    private int port;
    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private TestRestTemplate restTemplate;

    private static void setLatestResponse(ResponseEntity<String> latestResponse) {
        BaseE2ETest.latestResponse = latestResponse;
    }

    @PostConstruct
    public void init() {
        // https://stackoverflow.com/questions/16748969/java-net-httpretryexception-cannot-retry-due-to-server-authentication-in-strea
        // https://github.com/spring-projects/spring-framework/issues/14004
        
        restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        restTemplate.getRestTemplate().setErrorHandler(new DefaultResponseErrorHandler() {
            public boolean hasError(ClientHttpResponse response) throws IOException {
                HttpStatus statusCode = response.getStatusCode();
                return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
            }
        });
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do a GET call to {string}")
    public void weDoAGETCallTo(String path) {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(false);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do an authorized GET call to {string}")
    public void weDoAnAuthorizedGETCallTo(String path) {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(true);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do a POST call to {string} with the body as in {string}")
    public void weDoAPOSTCallToWithTheBodyAsIn(String path, String pathToFile) throws Exception {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(false);

        String body = readFile(pathToFile);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do an authorized POST call to {string} with the body as in {string}")
    public void weDoAnAuthorizedPOSTCallToWithTheBodyAsIn(String path, String pathToFile) throws Exception {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(true);

        String body = readFile(pathToFile);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do an authorized POST call to {string} with that body")
    public void weDoAnAuthorizedPOSTCallToWithThatBody(String path) {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(true);

        setLatestResponse(restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(editableBody, headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do a PUT call to {string} with the body as in {string}")
    public void weDoAPUTCallToWithTheBodyAsIn(String path, String pathToFile) throws Exception {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(false);

        String body = readFile(pathToFile);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(body, headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do an authorized PUT call to {string} with the body as in {string}")
    public void weDoAnAuthorizedPUTCallToWithTheBodyAsIn(String path, String pathToFile) throws Exception {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(true);

        String body = readFile(pathToFile);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(body, headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do an authorized PUT call to {string} with that body")
    public void weDoAnAuthorizedPUTCallToWithThatBody(String path) {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(true);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(editableBody, headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do a DELETE call to {string}")
    public void weDoADeleteCallTo(String path) {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(false);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headers), String.class));
    }

    /** See the readme.md file to get more information about this step. */
    @When("we do an authorized DELETE call to {string}")
    public void weDoAnAuthorizedDELETECallTo(String path) {
        String url = getUrlFor(path);
        HttpHeaders headers = getHttpHeaders(true);
        setLatestResponse(restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headers), String.class));
    }

    private HttpHeaders getHttpHeaders(boolean addAuthorisation) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "en");
        headers.add("Content-Type", "application/json");

        if (addAuthorisation)
            headers.add("Authorization", "bearer " + bearerToken);

        return headers;
    }

    private String getUrlFor(String path){
        return SERVER_URL + port + urlBasePath + path;
    }
}
