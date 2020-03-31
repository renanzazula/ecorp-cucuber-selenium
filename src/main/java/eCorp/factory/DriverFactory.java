package eCorp.factory;

import eCorp.constant.ConstantsPropertiesFile;
import eCorp.environment.mobile.pages.account.AccountPage;
import eCorp.environment.mobile.pages.account.AccountSelector;
import eCorp.environment.mobile.pages.home.DashBoard;
import eCorp.environment.mobile.pages.login.Login;
import eCorp.environment.mobile.pages.mfa.Mfa;
import eCorp.environment.mobile.pages.transfer.TransferHome;
import eCorp.environment.mobile.pages.transfer.self.SelfTransfer;
import eCorp.utils.ReadConfigFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";


    public static WebDriver driver;

    public static Login login;
    public static Mfa mfa;
    public static DashBoard dashBoard;
    public static TransferHome transferHome;
    public static SelfTransfer selfTransfer;
    public static AccountPage accountPage;
    public static AccountSelector accountSelector;

    public WebDriver getDriver() {

        try {
            // Read Config
            ReadConfigFile file = new ReadConfigFile();
            String browserName = file.getBrowser();

            if(file.getOS().contains("windows")){
                System.setProperty(WEBDRIVER_GECKO_DRIVER, "src/main/resources/other/geckodriver.exe");
            } else{
                System.setProperty(WEBDRIVER_GECKO_DRIVER, "/usr/bin/geckodriver");
            }

            switch (browserName) {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    break;
                case CHROME:
                    System.setProperty(WEBDRIVER_CHROME_DRIVER, ConstantsPropertiesFile.CHROME_DRIVER_DIRECTORY);
                    // CHROME OPTIONS
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unable to load browser: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                login = PageFactory.initElements(driver, Login.class);
                mfa = PageFactory.initElements(driver, Mfa.class);
                dashBoard = PageFactory.initElements(driver, DashBoard.class);
                transferHome = PageFactory.initElements(driver, TransferHome.class);
                selfTransfer = PageFactory.initElements(driver, SelfTransfer.class);
                accountPage = PageFactory.initElements(driver, AccountPage.class);
                accountSelector = PageFactory.initElements(driver, AccountSelector.class);
            }
        }
        return driver;
    }
}
