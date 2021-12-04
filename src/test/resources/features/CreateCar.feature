@wip
Feature: Create Car

  Background:

    Given the "storemanager" is on the Vehicles page
    And the user navigates to "Fleet" "Vehicles"

  Scenario: Create car as a Store Manager

    Then the user clicks on Create Car button
    And the user enters new Car information
    Then the user clicks on save changes button









