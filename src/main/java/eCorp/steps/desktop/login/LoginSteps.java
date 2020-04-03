package eCorp.steps.desktop.login;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eCorp.factory.desktop.DriverFactoryImplements;

public class LoginSteps extends DriverFactoryImplements {

    @Given("User navigates to standard website {string}")
    public void user_navigates_to_standard_website(String url) {
        login.getLoginPage(url);
    }

    @And("User  clicks on button headerLanguage")
    public void user_clicks_on_button_headerLanguage() {
        login.clickAtButton_headerLanguage();
    }

    @And("User enters a valid company {string}")
    public void user_enters_a_valid_company(String corporateId) {
        login.setCorporateId(corporateId);
    }

    @And("User enters a valid user {string}")
    public void user_enters_a_valid_user(String user) {
        login.setUsername(user);
    }

    @And("User enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        login.setPassword(password);
    }

    @When("User clicks on button next")
    public void user_clicks_on_button_next() {
        login.clickAtButtonNext();
    }

    @Then("User should be taken to the Mfa")
    public void user_should_be_taken_to_the_Mfa() {
        // TODO: find good way to do this... 
        // Just Check type of MFA
        waitFewSeconds(20);
    }

    @And("User click at SMS, Otp option")
    public void user_click_at_SMS_Otp_option() {
        mfa.clickAtOptionOtp();
    }

    @And("User enters a valid otp {string}")
    public void user_enters_a_valid_otp(String otpValue) {
       
        mfa.addOtp(otpValue);
    }

    @Then("User should be taken to the home page")
    public void user_should_be_taken_to_the_home_page() {
        // TODO: find good way to do this...
        // Assert element at dashboard
    }

    @When("User clicks on button Next")
    public void userClicksOnButtonNext() {
        login.clickAtButtonNext();
    }

    @And("User click at SMS, Otp Option")
    public void userClickAtSMSOtpOption() {
        //mfa.clickAtOptionOtp();
    }
}
