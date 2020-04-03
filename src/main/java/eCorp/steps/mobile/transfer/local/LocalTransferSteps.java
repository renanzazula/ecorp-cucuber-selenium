package eCorp.steps.mobile.transfer.local;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eCorp.factory.mobile.DriverFactoryImplements;

public class LocalTransferSteps extends DriverFactoryImplements {

    @Before
    public void setup() {
        driver = getDriver();
    }
    
    // remove from here 
    @After
    public void tearDown(Scenario scenario) {
        try {
            // Fix this to add images to report
            // scenario.embed(extractBytes("img.png"), "image/png");
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            // Fix this to add images to report
            System.out.println(e );
        }
    }
    
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
    }

    @And("User click at SMS, Otp option")
    public void user_click_at_SMS_Otp_option() {
        mfa.clickAtOptionOtp();
    }

    @And("User enters a valid otp {string}")
    public void user_enters_a_valid_otp(String otpValue) {
        mfa.addOtp(otpValue);
    }

    @Then("User should be taken to the dashboard")
    public void user_should_be_taken_to_the_dashboard() {
        // TODO: find good way to do this...
        // Assert element at dashboard 
    }
    
    @And("User clicks on menu transfer at dashboard")
    public void user_clicks_on_menu_transfer_at_dashboard() {
        dashBoard.clickAtButtonOptionTransfersHome();
    }

    @Then("User should be taken to the transfer menu sub page")
    public void user_should_be_taken_to_the_transfer_menu_sub_page() {
        //todo: assert elements at page      
    }

    @Then("User should be taken to the transfer page transfers home")
    public void user_should_be_taken_to_the_transfer_page_transfers_home() {
        //todo: assert elements at page
    }

    @And("User clicks on menu self transfer")
    public void user_clicks_on_menu_Self_transfer() {
        transferHome.clickAtOptionTransfersSelf();
    }

    @And("User click at selector AccountFrom")
    public void user_click_at_selector_AccountFrom() {
        System.out.println("user_click_at_selector_AccountFrom");
    }

    @Then("User should be taken to the Account from selector")
    public void user_should_be_taken_to_the_Account_from_selector() {
        // TODO: Assert
        System.out.println("user_should_be_taken_to_the_Account_from_selector");
    }

    @And("User selected account from {string}")
    public void user_selected_account_from(String string) {
        System.out.println("user_selected_account_from");
    }

    @Then("User should be taken to the transfer page with account to selected")
    public void user_should_be_taken_to_the_transfer_page_with_account_to_selected() {
        // TOdo: Assert
        System.out.println("user_should_be_taken_to_the_transfer_page_with_account_to_selected");
    }

    @And("User click at selector account To")
    public void user_click_at_selector_account_To() {
        System.out.println("user_click_at_selector_account_To");
    }

    @Then("User should be taken to the account To selector")
    public void user_should_be_taken_to_the_account_to_selector() {
        System.out.println("user_should_be_taken_to_the_account_to_selector");
    }

    @And("User selected account to {string}")
    public void user_selected_account_to(String string) {
        System.out.println("user_selected_account_to");
    }

    @Then("User should be taken to the transfer page")
    public void user_should_be_taken_to_the_transfer_page() {
        System.out.println("user_should_be_taken_to_the_transfer_page");
    }

    @Then("User add amount {string}")
    public void user_add_amount(String string) {
        System.out.println("user_add_amount");
    }

    @Then("User add instructions {string}")
    public void user_add_instructions(String string) {
        System.out.println("user_add_instructions");
    }

    @Then("Click at Proceed Button")
    public void click_at_Proceed_Button() {
        System.out.println("click_at_Proceed_Button");
    }

    @Then("User should be taken to the transfer confirm page")
    public void user_should_be_taken_to_the_transfer_confirm_page() {
        // toodo asser 
        System.out.println("user_should_be_taken_to_the_transfer_confirm_page");
    }

    @Then("User add otp {string}")
    public void user_add_otp(String string) {
        System.out.println("user_add_otp");
        // otp.setTextField_mobileOtpSmsPreLogin(string);
    }

    @Then("User should be taken to the transfer result page")
    public void user_should_be_taken_to_the_transfer_result_page() {
        System.out.println("user_should_be_taken_to_the_transfer_result_page");
        // todo assser 
    }

    @And("User click at button Finish")
    public void user_click_at_button_finish() {
        System.out.println("user_click_at_button_finish");
    }

    @Then("User should be taken to the transfer home page")
    public void user_should_be_taken_to_the_transfer_home_page() {
        System.out.println("user_should_be_taken_to_the_transfer_home_page");
    }

    @And("User click at selector Account To")
    public void userClickAtSelectorAccountTo() {
        System.out.println("User click at selector Account To");
    }

    @Then("User should be taken to the Account To selector")
    public void userShouldBeTakenToTheAccountToSelector() {
        System.out.println("User should be taken to the Account To selector");
    }

    @And("Click at proceed button")
    public void clickAtProceedButton() {
        System.out.println("Click at proceed button");
    }

    @And("User click at button finish")
    public void userClickAtButtonFinish() {
        System.out.println("User click at button finish");
    }
    
}
