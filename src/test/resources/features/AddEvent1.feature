@TRN-1141
Feature:As a store manager and sales manager, I should be able to add an event

  @AC1
  Scenario Outline: User can access the  the "General Information" page
  (by clicking on any vehicle/row under Fleet-Vehicle module)
    Given the "<userType>" is on the Vehicles page
    When the user should be able to click any vehicle
    And the user should be able to launch on "General Information" page
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @AC2.1
  Scenario Outline: Sales Manager and Store manager can click "Add Event" button
    Given the "<userType>" is on the Vehicles page
    When the user should be able to click any vehicle
    Then the user should be able to click on "Add Event" button
    Examples:
      | userType     |
     # | driver       |
      | salesmanager |
      | storemanager |

  @AC2.2
  Scenario Outline: but Driver can NOT see "Add Event" button
    Given the "<userType>" is on the Vehicles page
    When the user should be able to click any vehicle
    Then the Driver should NOT see "Add Event" button
    Examples:
      | userType |
      | driver   |
     # | salesmanager |
      #| storemanager |


  @AC3
  Scenario Outline: After clicking on "Add event" button, "Add Event" page should pop up.
    Given the "<userType>" is on the Vehicles page
    When the user should be able to click any vehicle
    Then the user should be able to click on "Add Event" button
    And the "Add Event" pop up should be open
    Examples:
      | userType     |
     # | driver       |
      | salesmanager |
      | storemanager |

  @AC4
  Scenario Outline: User Should see Title, Owner, Organizer display name, Organizer email, Start Date, End Date as a compulsory field
    Given the "<userType>" is on the Vehicles page
    When the user should be able to click any vehicle
    Then the user should be able to click on "Add Event" button
    Then User Should see Title, Owner, Organizer display name, Organizer email, Start Date, End Date as a compulsory field
    Examples:
      | userType     |
      | salesmanager |
      | storemanager |

  @AC5
  Scenario Outline: If any compulsory field is not filled, "This value should not be blank." message
  should be displayed after clicking on save button.(All filled except Title)
    Given the "<userType>" is on the Vehicles page
    And the user should be able to click any vehicle
    And the user should be able to click on "Add Event" button
    And the user should fill the "<titleInputBox>" ,"<organizerDisplayNameInputBox>" ,"<organizerEmailInputBox>"  as follow
    Then the user should be able to see -This value should not be blank.- message under compulsory field that is not filled.
#user filled all the fields and clicked save button at step 4 that i did not write at scenario.

    Examples:
      | userType     | titleInputBox | organizerDisplayNameInputBox | organizerEmailInputBox |
      | salesmanager |               | nasa                         | nasa@gmail.com         |
      | salesmanager | appointment   |                              | nasa1@gmail.com        |
      | salesmanager | appointment   | nasa1                        |                        |
      | salesmanager |               |                              |                        |
      | storemanager |               | nasa2                        | nasa@gmail.com         |
      | storemanager | appointment   |                              | nasa1@gmail.com        |
      | storemanager | appointment   | nasa3                        |                        |
      | storemanager |               |                              |                        |





