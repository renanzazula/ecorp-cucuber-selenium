package eCorp.pages.mfa;

import eCorp.pages.login.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mfa extends Login {

    private @FindBy(xpath = "//div[@id='OTP']") WebElement button_Otp;
    private @FindBy(xpath = "//input[@id='mobileOtpSmsPrelogin']") WebElement textField_mobileOtpSmsPreLogin;
        
    public Mfa clickAtButtonOption_Otp(){
        // waitAndClickElement(button_Otp);
        return new Mfa();
    }

    public Mfa setTextField_mobileOtpSmsPreLogin(String otp) {
        sendKeysToWebElement(textField_mobileOtpSmsPreLogin, otp);
        return new Mfa();
    }
    
    public class SoftToken {
        // TODO:
    }

    public class HardToken {
        // TODO:

    }

}
