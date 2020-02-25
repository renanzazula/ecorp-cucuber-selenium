package eCorp.pages.home;

import eCorp.pages.mfa.Mfa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends Mfa {

    private @FindBy(xpath = "//div[@id='transfersHome']") WebElement transfersHeadHome;
//    private @FindBy(xpath = "//button[@id='accountsHomeLauncher']") WebElement accountsHome;
//    private @FindBy(xpath = "//button[@id='sadadHomeLauncher']") WebElement sadadHome;
//    private @FindBy(xpath = "//button[@id='directDebitsHomeLauncher']") WebElement directDebitsHome;
//    private @FindBy(xpath = "//button[@id='investmentsHomeLauncher']") WebElement investmentsHome;
//    private @FindBy(xpath = "//button[@id='dividendsHomeLauncher']") WebElement dividendsHome;
//    private @FindBy(xpath = "//button[@id='aramcoHomeLauncher']") WebElement aramcoHome;
//    private @FindBy(xpath = "//button[@id='eTradeHomeLauncher']") WebElement eTradeHome;
//    private @FindBy(xpath = "//button[@id='posHomeLauncher']") WebElement posHome;
//    private @FindBy(xpath = "//button[@id='cashConcentrationHomeLauncher']") WebElement cashConcentrationHome;
//    private @FindBy(xpath = "//button[@id='merchantPortalHomeLauncher']") WebElement merchantPortalHome;
//    private @FindBy(xpath = "//button[@id='omnibusHomeLauncher']") WebElement omnibusHome;
//    private @FindBy(xpath = "//button[@id='settingsHubHomeLauncher']") WebElement settingsHubHome;
    
    public void clickAtButtonOptionAccountsHome() {
     
    }

    public DashBoard clickAtButtonOptionTransfersHeadHome() {
         waitAndClickElement(transfersHeadHome);
         return new DashBoard();
    }

    public void clickAtButtonOptionSadadHome() {
     
    }

    public void clickAtButtonOptionDirectDebitsHome() {
        
    }

    public void clickAtButtonOptionInvestmentsHome() {
        
    }

    public void clickAtButtonOptionDividendsHome() {
        
    }

    public void clickAtButtonOptionAramcoHome() {
        
    }

    public void clickAtButtonOptioneTradeHome() {
        
    }

    public void clickAtButtonOptionPosHome() {
        
    }

    public void clickAtButtonOptionCashConcentrationHome() {
        
    }

    public void clickAtButtonOptionMerchantPortalHome() {
        
    }

    public void clickAtButtonOptionOmnibusHome() {
        
    }

    public void clickAtButtonOptionSettingsHubHome() {
        
    }
}
