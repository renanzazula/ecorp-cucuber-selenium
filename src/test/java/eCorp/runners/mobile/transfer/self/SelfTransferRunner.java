package eCorp.runners.mobile.transfer.self;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/feature/transfer/selfTransfer" },
        glue = "eCorp/steps/mobile/transfer/self",
        monochrome = false,
        tags = {},
        strict = true,
        plugin = { "pretty", 
                   "html:target/cucumber", 
                   "json:target/cucumber.json",
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
        })
public class SelfTransferRunner extends AbstractTestNGCucumberTests {

}
