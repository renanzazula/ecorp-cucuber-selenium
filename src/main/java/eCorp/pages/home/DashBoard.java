package eCorp.pages.home;

import eCorp.pages.login.Login;
import eCorp.pages.mfa.Mfa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends Mfa {
    
    private @FindBy(xpath = "//button[@id='accountsHomeLauncher']") WebElement accountsHome;
    private @FindBy(xpath = "//button[@id='transfersHeadHomeLauncher']") WebElement transfersHeadHome;
    private @FindBy(xpath = "//button[@id='sadadHomeLauncher']") WebElement sadadHome;
    private @FindBy(xpath = "//button[@id='directDebitsHomeLauncher']") WebElement directDebitsHome;
    private @FindBy(xpath = "//button[@id='investmentsHomeLauncher']") WebElement investmentsHome;
    private @FindBy(xpath = "//button[@id='dividendsHomeLauncher']") WebElement dividendsHome;
    private @FindBy(xpath = "//button[@id='aramcoHomeLauncher']") WebElement aramcoHome;
    private @FindBy(xpath = "//button[@id='eTradeHomeLauncher']") WebElement eTradeHome;
    private @FindBy(xpath = "//button[@id='posHomeLauncher']") WebElement posHome;
    private @FindBy(xpath = "//button[@id='cashConcentrationHomeLauncher']") WebElement cashConcentrationHome;
    private @FindBy(xpath = "//button[@id='merchantPortalHomeLauncher']") WebElement merchantPortalHome;
    private @FindBy(xpath = "//button[@id='omnibusHomeLauncher']") WebElement omnibusHome;
    private @FindBy(xpath = "//button[@id='settingsHubHomeLauncher']") WebElement settingsHubHome;

//    public Login getAccountHomePage(String url) {
//        driver.get(url);
//        return new Login();
//    }

    public void getAccountsHome() {
     
    }

    public void getTransfersHeadHome() {
        waitAndClickElement(transfersHeadHome);
    }

    public void getSadadHome() {
     
    }

    public void getDirectDebitsHome() {
        
    }

    public void getInvestmentsHome() {
        
    }

    public void getDividendsHome() {
        
    }

    public void getAramcoHome() {
        
    }

    public void geteTradeHome() {
        
    }

    public void getPosHome() {
        
    }

    public void getCashConcentrationHome() {
        
    }

    public void getMerchantPortalHome() {
        
    }

    public void getOmnibusHome() {
        
    }

    public void getSettingsHubHome() {
        
    }
}
