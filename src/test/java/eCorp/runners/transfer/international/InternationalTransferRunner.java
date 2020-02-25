package eCorp.runners.transfer.international;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/feature/transfer/international" },
        glue = "eCorp/steps/transfer/international",
        monochrome = false,
        tags = {},
        strict = true,
        plugin = { "pretty", 
                   "html:target/cucumber", 
                   "json:target/cucumber.json",
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
        })
public class InternationalTransferRunner extends AbstractTestNGCucumberTests {

}
