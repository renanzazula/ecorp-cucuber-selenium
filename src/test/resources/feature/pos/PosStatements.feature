Feature: PosStatements
  
  Background: Access to Pos Statement page
    Given User navigates to menu Pos and click
    And User click at submenu Statements and Claims
    And User click at submenu Pos Statement
    Then User should be taken to the Pos Statements page
    
  Scenario: User selected One account information
    Given User Selected account number 
  
  Scenario: User selected and filter to Search Criteria
  Scenario: User validated if result from table is corrected  
