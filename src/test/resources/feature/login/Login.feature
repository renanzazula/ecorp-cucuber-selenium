Feature: Login

  Scenario Outline: Login at NCB Desktop
    Given User navigates to standard website "<url>"
    And User  clicks on button headerLanguage
    And User enters a valid company "<company>"
    And User enters a valid user "<user>"
    And User enters a valid password "<password>"
    When User clicks on button Next
    Then User should be taken to the Mfa
    And User click at SMS, Otp Option 
    And User enters a valid otp "<otp>"
    Then User should be taken to the home page 
    Examples:
      | url                                               | company   | user        | password | otp  |
      | http://localhost:8082/eCorp/home                  | abahusain | rzazulainit | 1234abcd | 1234 |
