package eCorp.steps;

import eCorp.factory.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

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
            // Fix this to add images to report
            // scenario.embed(extractBytes("img.png"), "image/png");
//            if (driver != null) {
//                driver.manage().deleteAllCookies();
//                driver.quit();
//                driver = null;
//            }
        } catch (Exception e) {
            // Fix this to add images to report
            System.out.println(e );
        }
    }
    
    public byte[] extractBytes (String imageName) throws IOException {
        return Files.readAllBytes(new File(imageName).toPath());
    }
}
