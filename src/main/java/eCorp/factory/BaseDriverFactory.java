package eCorp.factory;

import org.openqa.selenium.WebDriver;

public abstract class BaseDriverFactory {

    protected static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    protected static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    protected static final String CHROME = "chrome";
    protected static final String FIREFOX = "firefox";
    protected static WebDriver driver;
    
    public abstract WebDriver getDriver();
    
    public void waitFewSeconds(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
