package eCorp.environment.mobile.pages.login;

import eCorp.environment.mobile.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    private @FindBy(xpath = "//input[@id='corporateId']") WebElement corporateId;
    private @FindBy(xpath = "//input[@id='username']") WebElement username;
    private @FindBy(xpath = "//input[@id='password']") WebElement password;
    private @FindBy(xpath = "//button[@id='loginButton']") WebElement loginButton;
    private @FindBy(xpath = "//button[@id='headerLanguage']") WebElement headerLanguage;
    
    public Login() {
        super();
    }

    public Login getLoginPage(String url) {
        driver.get(url);
        return new Login();
    }

    public Login clickAtButton_headerLanguage() {
        // waitAndClickElement(headerLanguage);
        return new Login();
    }

    public Login setCorporateId(String corporateId) {
        sendKeysToWebElement(this.corporateId, corporateId);
        return new Login();
    }

    public Login setUsername(String username) {
        sendKeysToWebElement(this.username, username);
        return new Login();
    }

    public Login setPassword(String password) {
        sendKeysToWebElement(this.password, password);
        return new Login();
    }
    
    public Login clickAtButtonNext() {
        waitAndClickElement(loginButton);
        return new Login();
    }

}
