@login
Feature: Users should be able to login

  #this scenario is the pre-condition used for all Test cases related to Vehicles page
  Scenario: The userType is on the Fleet - Vehicle page
    Given the "driver" is on the Vehicles page

  @TRN-1218
  Scenario Outline:All users ("<userType>") can log in with valid credentials
    Given the user logged in as "<userType>"
    Then the subtitle contains "<subtitle>"
    Examples:
      | userType     | subtitle        |
      | driver       | Quick Launchpad |
      | storemanager | Dashboard       |
      | salesmanager | Dashboard       |


  @TRN-1219
  Scenario: The system shouldn't allow users to login to application without providing valid credentials
    Given the user logged in as "driver"
    When the subtitle contains "Quick Launchpad"
    And the user get current url
    Then the user logs out
    Then the user paste url into address bar and presses enter
    Then  the user sees "Login" title

  @TRN-1220
  Scenario Outline: All users "<userType>" can see their own usernames in profile menu, after successful login
    Given the user logged in as "<userType>"
    When the subtitle contains "<subtitle>"
    Then the user see own username in profile menu
    Examples:
      | userType     | subtitle        |
      | driver       | Quick Launchpad |
      | storemanager | Dashboard       |
      | salesmanager | Dashboard       |

  @TRN-1221
  Scenario: "Invalid username or password." error message should be displayed for invalid credentials
    Given the user tries to login with invalid credentials
    Then  the user sees error massage on the login page

  @TRN-1222 @smoke
  Scenario: User should see the password in bullet signs by default
    Given the user on the login page
    Then the user sees password as default bullet in password box

  @TRN-1223
  Scenario:  User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    Given the user on the login page
    When the user click "Forgot your password?" link
    Then the user land on "Forgot Password" page

  @TRN-1224
  Scenario: User can see "Remember me on this computer" link on the login page and it should be clickable
    Given the user on the login page
    When the user sees "Remember me on this computer" link
    Then the user clickable "Remember me on this computer" link

  @TRN-1225
  Scenario: Verify that user can use "Enter" key from their keyboard on the login page
    Given the user on the login page
    When the user enters the username in the username box and click on enter on the keyboard
    Then the user enters the password in the password box and click on enter on the keyboard
    Then the user sees "Dashboard" title







