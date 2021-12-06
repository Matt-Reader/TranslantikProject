@TRN-1209
Feature:User should be able to use Location Filter

	Background:
		#@TRN-1202
		Given the "driver" is on the Vehicles page
		When the user clicks on the Manage Filter button
		And the user clicks on the Location select button
		

	@TRN-1200
	Scenario: User can select "Location" filter under 'Fleet-Vehicles' module
		Then the user should see the Location select button	

	@TRN-1201
	Scenario: "Location" filter should provide the methods shown as below:
		When the user clicks on the Contains button under the Location options
		Then the user should see the methods as below
		|Contains|
		|Does Not Contain|
		|Is Equal To|
		|Starts With|
		|Ends With|
		|Is Any Of|
		|Is Not Any Of|
		|Is Empty|
		|Is Not Empty|	

	@TRN-1203
	Scenario: When the user selects the "Contains" method with a keyword, the results should contain the specified keyword
		When the user clicks on the Contains method
		And the user enters a specific keyword as "west"
		Then the results should contains the given keyword as "west"

	@TRN-1204
	Scenario: When the user selects the "Does Not Contain" method with a keyword, the results should not contain the specified keyword
		When the user clicks on the Does Not Contains method
		And the user enters a specific keyword as "west"
		Then the results should not contains the given keyword as "west"

	@TRN-1205
	Scenario: When user selects the "Starts-with" method with a keyword, the results should start with the specified keyword
		When the user clicks on the Starts With method
		And the user enters a specific keyword as "we"
		Then the results should start with the given keyword as "we"

	@TRN-1206
	Scenario: When user selects the "Ends With" method with a keyword, the results should end with the specified keyword
		When the user clicks on the Ends With method
		And the user enters a specific keyword as "town"
		Then the results should end with the given keyword as "town"

	@TRN-1207
	Scenario: When user selects the "Is Equal to" method with a keyword, the results should match the specified keyword exactly
		When the user clicks on the Is Equal To method
		And the user enters a specific keyword as "charlieport"
		Then the results should exactly match with the given keyword as "charlieport"

	@TRN-1208
	Scenario Outline: Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters
		When the user clicks on "<methods>"
		And the user enters a specific keyword as "?=)("
		Then the "<methods>" should not accept the given keyword
		Examples: 
		|methods|
		|Contains|
		|Does Not Contain|
		|Starts With|
		|Ends With|
		|Is Equal To|