Feature: Login

  Scenario Outline: Login at NCB Mobile or NCB Desktop
    Given User navigates to standard website "<url>"
    And User  clicks on button headerLanguage
    And User enters a valid company "<company>"
    And User enters a valid user "<user>"
    And User enters a valid password "<password>"
    When User clicks on button Next
    Then User should be taken to the Mfa
    And User click at SMS, Otp Option 
    And User enters a valid otp "<otp>"
    Then User should be taken to the dashboard
    Examples:
      | url                                               | company   | user            | password | otp  |
      | http://dev.innofis.local:8101/#/login/login-login | abahusain | rzazulaapproval | abcd1234 | 1234 |
