package eCorp.runners.mobile.transfer.ncb;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/feature/transfer/ncb" },
        glue = "eCorp/steps/mobile/transfer/ncb",
        monochrome = false,
        tags = {},
        strict = true,
        plugin = { "pretty", 
                   "html:target/cucumber", 
                   "json:target/cucumber.json",
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
        })
public class NCBTransferRunner extends AbstractTestNGCucumberTests {

}
