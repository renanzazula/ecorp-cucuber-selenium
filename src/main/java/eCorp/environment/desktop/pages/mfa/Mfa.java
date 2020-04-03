package eCorp.environment.desktop.pages.mfa;

import eCorp.environment.desktop.pages.login.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mfa extends Login {

    private @FindBy(xpath = "//label[contains(text(),'SMS')]") WebElement otp;
    private @FindBy(xpath = "//input[@id='valueOtp']") WebElement valueOtp;

    public Mfa clickAtOptionOtp(){
        // waitAndClickElement(otp); // fixme: to selected when we have more than one option
        return new Mfa();
    }

    public Mfa addOtp(String otp) {
        waitFewSeconds(10000);
        sendKeysToWebElement(this.valueOtp, otp);
        return new Mfa();
    }

    public Mfa addSoftToken(String softToken) {
        sendKeysToWebElement(null, softToken); //fixme:
        return new Mfa();
    }

    public Mfa addHardToken(String hardToken) {
        sendKeysToWebElement(null, hardToken); //fixme:
        return new Mfa();
    }

}
