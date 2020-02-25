package eCorp.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import eCorp.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MasterHooks extends DriverFactory {

    @Before
    public void setup() {
        driver = getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()){
               scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            }
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            // Fix this to add images to report
            System.out.println(e);
        }
    }

    public byte[] extractBytes(String imageName) throws IOException {
        return Files.readAllBytes(new File(imageName).toPath());
    }
}
