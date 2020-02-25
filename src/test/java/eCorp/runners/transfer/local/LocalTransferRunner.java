package eCorp.runners.transfer.local;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/feature/transfer/local" },
        glue = "eCorp/steps/transfer/local",
        monochrome = false,
        tags = {},
        strict = true,
        plugin = { "pretty", 
                   "html:target/cucumber", 
                   "json:target/cucumber.json",
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
        })
public class LocalTransferRunner extends AbstractTestNGCucumberTests {

}
