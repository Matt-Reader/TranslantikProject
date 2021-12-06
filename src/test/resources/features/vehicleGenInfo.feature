Feature: As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)

  # Verify that Truck Driver can Succesfully Login

  # 1- User can see the "General Information" page by clicking on any vehicle (row), under the 'Fleet-Vehicle' module
  # 2- User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under the 'Fleet-Vehicle' module
  # 3- Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
  # 4- Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
  # 5- Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same

  #AC1

  Scenario Outline: Verify that all user can see the "General Information" page by clicking on any vehicle (row), under the 'Fleet-Vehicle' module
    Given the "<userType>" is on the Vehicles page
    When the user click any vehicle (row) under the Fleet-Vehicle module
    Then the user can see the "General Information" page
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  #AC2

  Scenario Outline: Verify that all user can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under the 'Fleet-Vehicle' module
    Given the "<userType>" is on the Vehicles page
    When the user click any vehicle (row) under the Fleet-Vehicle module
    Then the user can see the "General Information" page
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  #AC3

  Scenario Outline: Verify Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
    Given the "<userType>" is on the Vehicles page
    When the user should land on General Information page
    Then verify the user should see Edit, Delete and Add Event buttons on the General Information page
    Examples:
      | userType     |
      | salesmanager |
      | storemanager |

    #AC4

  Scenario: Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
    Given the "driver" is on the Vehicles page
    When the user should land on General Information page
    Then the driver shouldn't see Add Event, Edit and Delete buttons

      #AC5

  Scenario Outline: Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same
    Given the "<userType>" is on the Vehicles page
    When the user should land on General Information page
    Then the user information must be same on the  General Information  and Fleet-Vehicle page