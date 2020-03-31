Feature: SelfTransfer


  Scenario Outline: Make Self Transfer
    Given User navigates to standard website "<url>"
    And User  clicks on button headerLanguage
    And User enters a valid company "<company>"
    And User enters a valid user "<user>"
    And User enters a valid password "<password>"
    When User clicks on button next
    Then User should be taken to the Mfa
    And User click at SMS, Otp option
    And User enters a valid otp "<otp>"
    Then User should be taken to the dashboard
    And User clicks on menu transfer at dashboard
    Then  User should be taken to the transfer page transfers home
    And User clicks on menu self transfer
    And User click at selector AccountFrom
    Then User should be taken to the Account from selector
    And User selected account from "<AccountFromNumber>"
    Then  User should be taken to the transfer page with account to selected
    And User click at selector Account To
    Then User should be taken to the Account To selector
    And User selected account to "<AccountToNumber>"
    Then  User should be taken to the transfer page
    And User add amount "<amountInput>"
    And User add instructions "<instructionsInput>"
    And Click at proceed button
    Then  User should be taken to the transfer confirm page
    And User add otp "<otp>"
    Then  User should be taken to the transfer result page
    And User click at button finish
    Then  User should be taken to the transfer home page
    Examples:
    | url                                               | company   | user         | password |  AccountFromNumber | AccountToNumber | amountInput | instructionsInput | otp  |
    | http://dev.innofis.local:8101/#/login/login-login | abahusain | transferUser  | abcd1234 |  05100000124510    | 05100000249905  | 50          | instructions ccc  | 1234 |
