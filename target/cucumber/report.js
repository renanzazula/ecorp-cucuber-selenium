$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/login/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login at NCB Mobile or NCB Desktop",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User navigates to standard website \"\u003curl\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "User  clicks on button headerLanguage",
  "keyword": "And "
});
formatter.step({
  "name": "User enters a valid company \"\u003ccompany\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User enters a valid user  \"\u003cuser\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User enters a valid password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on button",
  "keyword": "When "
});
formatter.step({
  "name": "User should be taken to the dashboard \u003clistOfMenusAtDashBoard\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "url",
        "company",
        "user",
        "password",
        "listOfMenusAtDashBoard"
      ]
    },
    {
      "cells": [
        "http://dev.innofis.local:8100/#/login/login-login",
        "abahusain",
        "transferUser",
        "abcd1234",
        "listOfMenusAtDashBoard"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login at NCB Mobile or NCB Desktop",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to standard website \"http://dev.innofis.local:8100/#/login/login-login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.user_navigates_to_standard_website(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User  clicks on button headerLanguage",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.userClicksOnButtonHeaderLanguage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters a valid company \"abahusain\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_enters_a_valid_company(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters a valid user  \"transferUser\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_enters_a_valid_user(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters a valid password \"abcd1234\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_enters_a_valid_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.user_clicks_on_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be taken to the dashboard listOfMenusAtDashBoard",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_should_be_taken_to_the_dashboard_listOfMenusAtDashBoard()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});