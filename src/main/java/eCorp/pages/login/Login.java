package eCorp.pages.login;

import eCorp.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    private @FindBy(xpath = "//input[@id='corporateId']") WebElement textField_corporateId;
    private @FindBy(xpath = "//input[@id='username']") WebElement textField_username;
    private @FindBy(xpath = "//input[@id='password']") WebElement textField_password;
    //private @FindBy(xpath = "//button[@id='loadMethodsAndValidatePassword']") WebElement button_loginButton;
     private @FindBy(xpath = "//button[@id='loginButton']") WebElement button_loginButton;
    private @FindBy(xpath = "//button[@id='headerLanguage']") WebElement button_headerLanguage;
    
    // Examples
    // private @FindBy(xpath = "//*[@ng-reflect-name='descricao']") WebElement textArea_Descricao;
    // private @FindBy(xpath = "//*[@class='btn btn-secondary']") WebElement button_Cadastrar;
    // private @FindBy(xpath = "//*[@ng-reflect-ng-class='[object Object]']") WebElement messsage_Sucesso;

    public Login() {
        super();
    }

    public Login getLoginPage(String url) {
        driver.get(url);
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
    
    public Login clickAtButton() {
        waitAndClickElement(button_loginButton);
        return new Login();
    }

}
