package eCorp.steps.login;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eCorp.factory.DriverFactory;

public class LoginSteps extends DriverFactory {

    @Given("User navigates to standard website {string}")
    public void user_navigates_to_standard_website(String url) {
        login.getLoginPage(url);
    }

    @And("User  clicks on button headerLanguage")
    public void userClicksOnButtonHeaderLanguage() {
      //   login.clickAtButton_headerLanguage();
    }
    
    @And("User enters a valid company {string}")
    public void user_enters_a_valid_company(String corporateId) {
        login.setTextField_corporateId(corporateId);
    }

    @And("User enters a valid user  {string}")
    public void user_enters_a_valid_user(String username) {
      login.setTextField_username(username);
    }

    @And("User enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        login.setTextField_password(password);
    }

    @When("User clicks on button")
    public void user_clicks_on_button() {
      login.clickAtButton();
    }

    @Then("User should be taken to the dashboard listOfMenusAtDashBoard")
    public void user_should_be_taken_to_the_dashboard_listOfMenusAtDashBoard() {
       login.clickAtButton();
    }

    //    @Given("User navigates to standard website {string}")
//    public void user_navigates_to_standard_website(String url) {
//        login.getLoginPage(url);
//    }
//
//    @And("User enters a valid nome {string}")
//    public void userEntersAValidNome(String nome) {
//        login.setCorporateId(nome);
//    }
//
//    @And("User enters a valid descricao {string}")
//    public void user_enters_a_valid_descricao(String descricao) {
//        login.setDescricao(descricao);
//    }
//
//    @When("User clicks on button")
//    public void userClicksOnButton() {
//        login.clickAtButton();
//    }
//
//    @Then("User should be taken to the list page with successful {string}")
//    public void user_should_be_taken_to_the_list_page_with_successful_on(String message) {
//        Assert.fail("error");
//        Assert.assertEquals(message.toLowerCase().replaceAll("//s", ""), login
//                .getMessageSuccess().toLowerCase().replaceAll("//s", ""));
//    }

}
