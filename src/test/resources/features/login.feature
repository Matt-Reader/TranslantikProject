@login
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  Scenario: Login as a "<usertype>"
    Then the user should be login as a "salesmanager"


