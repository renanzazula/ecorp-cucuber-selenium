package eCorp.pages.mfa;

import eCorp.pages.login.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mfa extends Login {

    private @FindBy(xpath = "//div[@id='OTP']") WebElement otp;
    private @FindBy(xpath = "//input[@id='mobileOtpSmsPrelogin']") WebElement mobileOtpSmsPreLogin;

    public Mfa clickAtOptionOtp(){
        waitAndClickElement(otp);
        return new Mfa();
    }

    public Mfa addOtp(String otp) {
        sendKeysToWebElement(mobileOtpSmsPreLogin, otp);
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
