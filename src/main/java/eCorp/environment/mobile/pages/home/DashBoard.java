package eCorp.environment.mobile.pages.home;

import eCorp.environment.mobile.pages.mfa.Mfa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends Mfa {

    private @FindBy(xpath = "//div[@id='transfersHome']") WebElement transfersHome;
    private @FindBy(xpath = "//button[@id='accountsHomeLauncher']") WebElement accountsHome;
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

    public DashBoard clickAtButtonOptionAccountsHome() {
        waitAndClickElement(accountsHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionTransfersHome() {
         waitAndClickElement(transfersHome);
         return new DashBoard();
    }

    public DashBoard clickAtButtonOptionSadadHome() {
        waitAndClickElement(sadadHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionDirectDebitsHome() {
        waitAndClickElement(directDebitsHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionInvestmentsHome() {
        waitAndClickElement(investmentsHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionDividendsHome() {
        waitAndClickElement(dividendsHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionAramcoHome() {
        waitAndClickElement(aramcoHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionETradeHome() {
        waitAndClickElement(eTradeHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionPosHome() {
        waitAndClickElement(posHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionCashConcentrationHome() {
        waitAndClickElement(cashConcentrationHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionMerchantPortalHome() {
        waitAndClickElement(merchantPortalHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionOmnibusHome() {
        waitAndClickElement(omnibusHome);
        return new DashBoard();
    }

    public DashBoard clickAtButtonOptionSettingsHubHome() {
        waitAndClickElement(settingsHubHome);
        return new DashBoard();
    }

}
