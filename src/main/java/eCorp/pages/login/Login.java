package eCorp.pages.login;

import eCorp.pages.BasePage;
import eCorp.pages.mfa.Mfa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    private @FindBy(xpath = "//input[@id='corporateId']") WebElement textField_corporateId;
    private @FindBy(xpath = "//input[@id='username']") WebElement textField_username;
    private @FindBy(xpath = "//input[@id='password']") WebElement textField_password;
    
    private @FindBy(xpath = "//button[@id='loginButton']") WebElement button_loginButton;
    private @FindBy(xpath = "//button[@id='headerLanguage']") WebElement button_headerLanguage;

    public Login() {
        super();
    }

    public Login getLoginPage(String url) {
        driver.get(url);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // remove from here later
            e.printStackTrace();
        }

        return new Login();
    }

    public Login clickAtButton_headerLanguage() {
        waitAndClickElement(button_headerLanguage);
        return new Login();
    }

    public Login setTextField_corporateId(String corporateId) {
        sendKeysToWebElement(textField_corporateId, corporateId);
        return new Login();
    }

    public Login setTextField_username(String username) {
        sendKeysToWebElement(textField_username, username);
        return new Login();
    }

    public Login setTextField_password(String password) {
        sendKeysToWebElement(textField_password, password);
        return new Login();
    }
    
    public Login clickAtButtonNext() {
        waitAndClickElement(button_loginButton);
        return new Login();
    }

}
