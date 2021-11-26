Feature:  Arranging vehicle table columns via "grid settings" functionality
#AC1
  Scenario Outline: "Grid Settings" should be visible when the user clicks on the gear icon
    Given the user logged in as "<userType>"
    When the user navigates to Fleet, Vehicles
    And the user clicks on the gear icon
    Then the user see the "Grid Settings"
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |
#AC2
  Scenario Outline: Column names in grid settings should be shown as below
    Given the user logged in as "<userType>"
    When the user navigates to Fleet, Vehicles
    And the user clicks on the gear icon
    Then the user see the grid settings as expected
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |
#AC3
  Scenario Outline: User can find any column name by typing on the "Quick Search" input box
    Given the user logged in as "<userType>"
    When the user navigates to Fleet, Vehicles
    And the user clicks on the gear icon
    Then the user checked all the traits one by one
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |
#AC4
  Scenario Outline: User can select the columns to be displayed by clicking the column name
    Given the user logged in as "<userType>"
    When the user navigates to Fleet, Vehicles
    And the user clicks on the gear icon
    And the user unclicked some of the menu icons
    Then the user select 1 column randomly and the column should appear on the All Cars page screen
    Examples:
      | userType |
      | driver       |
      | salesmanager |
      | storemanager |
#AC5
  @wip
  Scenario Outline: User can arrange the order of the columns (by dragging and dropping)
    Given the user logged in as "<userType>"
    When the user navigates to Fleet, Vehicles
    And the user clicks on the gear icon
    Examples:
      | userType |
      | driver       |
      | salesmanager |
      | storemanager |
#AC6
  Scenario Outline: User can see all corresponding changes under the 'Fleet-Vehicles' page
    Given the user logged in as "<userType>"
    When the user navigates to Fleet, Vehicles
    And the user clicks on the gear icon
    Examples:
      | userType |
      | driver       |
      | salesmanager |
      | storemanager |
