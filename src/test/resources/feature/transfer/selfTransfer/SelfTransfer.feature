Feature: SelfTransfer

  Scenario Outline: Make Self Transfer
    Given User navigates to ncb "<url>"
    And User  clicks on button headerLanguage
    And User enters a valid company "<company>"
    And User enters a valid user "<user>"
    And User enters a valid password "<password>"
    When User clicks on button
    Then User should be taken to the dashboard <listOfMenusAtDashBoard>
    And User clicks on menu transfer at dashboard
    Then  User should be taken to the transfer menu sub page
    And User clicks on menu transfer at dashboard
    Then  User should be taken to the transfer page transfersHome
    And User clicks on menu Self transfer
    And User click at selector AccountFrom
    Then User should be taken to the Account from selector
    And User Selected "<AccountFromNumber>"
    Then  User should be taken to the transfer page with account to selected available to selected
    And User click at selector Account To
    Then User should be taken to the Account To selector
    And User Selected "<AccountToNumber>"
    Then  User should be taken to the transfer page
    And User add amount "<amountInput>"
    And User add instructions "<instructionsInput>"
    And Click at Proceed Button
    Then  User should be taken to the transfer confirm page
    And User add "<OTP>"
    Then  User should be taken to the transfer result page
    And User click at button Finish
    Then  User should be taken to the transfer home page
    Examples:
    | url                                               | company   | user         | password | listOfMenusAtDashBoard | AccountFromNumber | AccountToNumber | amountInput | instructionsInput | OTP  |
    | http://dev.innofis.local:8100/#/login/login-login | abahusain | transferUser | abcd1234 | listOfMenusAtDashBoard | 05100000124510    | 05100000249905  | 50          | instructions      | 1234 |
