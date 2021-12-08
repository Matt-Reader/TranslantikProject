@adil
Feature: Driver filter

  Background:
    Given the "storemanager" is on the Vehicles page
    And the user navigates to "Fleet" "Vehicles"

  @TRN-1228
  Scenario: User can select "Driver" filter under 'Fleet-Vehicles' module
    And the user click on the filter button
    And the user click on manage filter button
    Then Manage filter options should be displayed after clicking
    When the user click on Driver filter option
    Then the user should be able to see driver filter tab
  @TRN-1229
  Scenario: Driver filter should provide the methods shown as below
    And the user click on the filter button
    And the user click on manage filter button
    Then Manage filter options should be displayed after clicking
    When the user click on Driver filter option
    Then the user should be able to see driver filter tab
    When the user click on Driver filter tab
    And the user click on filter choice
    Then the user should be able to see the options below
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |

  @TRN-1230
  Scenario Outline: the filter should work as expected
    And the user click on the filter button
    And the user click on manage filter button
    Then Manage filter options should be displayed after clicking
    When the user click on Driver filter option
    Then the user should be able to see driver filter tab
    When the user click on Driver filter tab
    And the user click on filter choice
    Then the user should be able to see the options below
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |
    When the user select "<filter>"
    And enter the "<keyword>"
    And click the update button
    Then the result should be "<expected>" the "<keyword>"
    Examples:
      | filter           | keyword | expected    |
      | Contains         | Vodila  | contains    |
      | Does Not Contain | Vodila  | notContains |
      | Is Equal To      | Vodila  | equals      |
      | Starts With      | Vodila  | startsWith  |
      | Ends With        | Vodila  | endsWith    |

  @TRN-1231
  Scenario Outline: the filter should not accept special characters
    And the user click on the filter button
    And the user click on manage filter button
    Then Manage filter options should be displayed after clicking
    When the user click on Driver filter option
    Then the user should be able to see driver filter tab
    When the user click on Driver filter tab
    And the user click on filter choice
    Then the user should be able to see the options below
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |
    When the user select "<filter>"
    And enter the "<keyword>"
    And click the update button
    Then the result should be "<expected>" the "<keyword>"
    Examples:
      | filter           | keyword | expected    |
      | Contains         | &       | notContains |
      | Does Not Contain | &       | notContains |
      | Starts With      | &       | notContains |
      | Ends With        | &       | notContains |
      | Is Equal To      | & aaa & | notContains |