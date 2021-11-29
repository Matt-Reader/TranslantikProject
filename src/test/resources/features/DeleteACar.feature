Feature: As a 'Sales Manager' and 'Store Manager', I should be able to delete a car


  #TC-1
  @wip
 Scenario Outline: As a "<userType>" all can see the  delete button by hovering over the three dots at the end of each row
   Given the "<userType>" is on the Vehicles page
   When the user hover on the three dots at the end each row
   Then the user can see the delete button
   Examples:
   |userType|
   |driver|
##   |salesmanager|
#   |storemanager|


 #TC-2:
  Scenario Outline: "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
   Given the "<userType>" is on the Vehicles page
   When the user hover on the three dots at the end each row
   And the user click on the delete button
   Then the Delete Confirmation should be display
   Examples:
    |userType|
    |driver|
##   |salesmanager|
#   |storemanager|
