@wip
Feature:
#*User Story :* 
	#
	#As a user, I should be able to see all vehicle information in a table under Fleet-Vehicle page
	#
	# 
	#
	#Acceptance Criteria:
	#
	#1- All user types can see all vehicle information under 'Fleet-Vehicles' module
	#2- User can see the total page number
	#
	#3- User can go to next page clicking ">" button and can go to previous page clicking "<" button
	#4- User can see total recordings of vehicles
	#
	#5- User can download table data in XLS or CSV format from "Export Grid" (a confirmation message is enough to validate)
  Scenario Outline:
    Given the "<userType>" is on the Vehicles page
    When the user should see all vehicles information under module
    Then the user should see the total page number
    #And the user should go to next page after clicking the next button
    #And the user should go to previous page after clicking the previous button
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |
