package newVersion.common.hooks;

import com.crealogix.common.core.BaseE2ETest;
import com.crealogix.common.core.Loggable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.http.ResponseEntity;

public class LoggingHooks extends Loggable {

	@Before(order = 1)
	public void logBeforeScenario(Scenario scenario) {
		log.info(String.format(
				"Entering scenario %s",
				scenario.getId()
		));
	}

	@After(order = 1)
	public void logAfterScenario(Scenario scenario) {
		if (!scenario.isFailed()) {
			log.info(String.format(
					"Exiting scenario %s with status %s",
					scenario.getId(),
					scenario.getStatus()
			));
		} else {
			ResponseEntity<String> latestResponse = BaseE2ETest.latestResponse;
			if (latestResponse != null) {
				log.error(String.format(
						"Failed: Exiting %s\nResponse status:%d\nResponse body:\n%s\n-----------\n",
						scenario.getId(),
						latestResponse.getStatusCodeValue(),
						latestResponse.getBody()
				));
			} else {
				log.error(String.format(
						"Failed: Exiting %s\n-----------\n",
						scenario.getId()
				));
			}
		}
	}

}
