Feature: As a 'Sales Manager' and 'Store Manager', I should be able to delete a car


  #TC-1
 Scenario Outline: As a "<userType>" all can see the  delete button by hovering over the three dots at the end of each row
   Given the "<userType>" is on the Vehicles page
   When the user hover on the three dots at the end each row
   Then the user can see the delete button
   Examples:
     | userType     |
     | driver       |
     | salesmanager |
     | storemanager |


 #TC-2:
  Scenario Outline: "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
   Given the "<userType>" is on the Vehicles page
   When the user hover on the three dots at the end each row
   And the user click on the delete button
   Then the Delete Confirmation should be display
   Examples:
    | userType     |
    | driver       |
    | salesmanager |
    | storemanager |

  #TC-3:
  @wip
  Scenario: the user as a driver doesn't have permission to delete a car
    Given the "driver" is on the Vehicles page
    When the user hover on the three dots at the end each row
    And the user click on the delete button
    And the user click on the Yes, Delete button from pop up Delete Confirmation
    Then for user the message "You do not have permission to perform this action." should be displayed

    #TC-4:
  Scenario Outline: the user as a "<userType>" should able to delete a car
    Given the "<userType>" is on the Vehicles page
    When the user hover on the three dots at the end each row
    And the user click on the delete button
    And the user click on the Yes, Delete button from pop up Delete Confirmation
    Then for user the message "Item deleted" should be displayed
    Examples:
      | userType     |
      | salesmanager |
      | storemanager |

    #TC-5:
  Scenario Outline: the user as a "<userType>" should able to delete a car from General Information page
    Given the "<userType>" is on the Vehicles page
    And the user click on any random row in vehicle page
    When the user click on the delete button in General Information page
    Then for user the message "Car deleted" should be displayed
    Examples:
      | userType     |
      | salesmanager |
      | storemanager |

    #TC-6:



