Feature: Navigate to module

  Background:
    Given the user is on the login page


  Scenario: Navigate to "tab" and "module"
    Given the user should be login as a "salesmanager"
    Then the user navigates to "Fleet" "Vehicles"