@login
Feature: Users should be able to login

  Scenario: The userType on the Fleet - Vehicle page
    Given the "driver" is on the Vehicles page



  Scenario: Login as a "<usertype>"
    Given the user is on the login page
    Then the user should be login as a "salesmanager"



