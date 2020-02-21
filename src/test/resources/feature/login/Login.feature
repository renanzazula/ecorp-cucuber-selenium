Feature: Login

  Scenario Outline: Login at NCB Mobile or NCB Desktop
    Given User navigates to standard website "<url>"
    And User  clicks on button headerLanguage
    And User enters a valid company "<company>"
    And User enters a valid user  "<user>"
    And User enters a valid password "<password>"
    When User clicks on button
    Then User should be taken to the dashboard <listOfMenusAtDashBoard>
    Examples:
      | url                                               | company   | user         | password | listOfMenusAtDashBoard |
      | http://dev.innofis.local:8100/#/login/login-login | abahusain | transferUser | abcd1234 | listOfMenusAtDashBoard |
