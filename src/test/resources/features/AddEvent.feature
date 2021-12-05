@kdr
Feature:As a store manager and sales manager, I should be able to add an event

  Background:
    Given the "salesmanager" is on the Vehicles page

  @TRN-1176
  Scenario: User can access the "Add Event" page from the "General Information" page
  (by clicking on any vehicle/row under Fleet-Vehicle module)
    When the user should be able to click any vehicle
    Then the user should be able to launch on "General Information" page
    And the user should be able to see "Add Event" button


  @TRN-1177
  Scenario: After clicking on "Add event" button, "Add Event" page should pop up.
    When the user should be able to click any vehicle
    Then the user should be able to click on "Add Event" button
    And the "Add Event" pop up should be open

  @TRN-1178
  Scenario: User can mark the event with any colour
    Given the user should be able to click any vehicle
    Given the user should be able to click on "Add Event" button
    Given the user can select any color

  @TRN-1179
  Scenario: User can mark it as an "All-day event"
    Given the user should be able to click any vehicle
    Given the user should be able to click on "Add Event" button
    And the user should be able to click "All-day event"

  @TRN-1180
  Scenario: User can repeat the action by specifying occurrence periods and ending time:
  a)Repeat options should include the options below (repeats dropdown menu):
    Given the user should be able to click any vehicle
    Given the user should be able to click on "Add Event" button
    When the user should be able to click "Repeat" checkbox
    And the user should be able to see "Daily" "Weekly" "Monthly" "Yearly"

  @TRN-1181
  Scenario: b)Ending options should be as below and clickable
    Given the user should be able to click any vehicle
    Given the user should be able to click on "Add Event" button
    When the user should be able to click "Repeat" checkbox
    And the user should be able to click "End" radio button
    Then the user should be able to see "Never" "After" "By"

  @TRN-1182
  Scenario: All Users can see all events in the General information page
    Given the user should be able to click any vehicle
    And the user can see all events on the General information page