@TRN-1216
Feature:Filter Menu

	#{color:#00875a}*User Story :* {color}
	#
	#As a store manager and sales manager, I should be able to add an event
	#
	# 
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	#
	#{color:#de350b}*1*- "Manage Filter" button should be hidden by default.{color}
	#{color:#172b4d}*2*- When a user clicks on the filter icon, the "Manage Filter" button should be visible{color}
	#{color:#172b4d}*3*- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.{color}
	#{color:#172b4d}*4*- User can apply filters by typing the filter name, from the 'Manage Filters' menu.{color}
	#{color:#172b4d}*5*- User can apply multiple filters at the same time{color}
	#{color:#172b4d}*6*- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module{color}
  @TRN-1210 @smoke
  Scenario Outline: 1.Manage filters should be hidden
    Given the "<userType>" is on the Vehicles page
    Then Manage filters should be hidden
    Examples:
      | userType     |
      | driver       |
#      | salesmanager |
#      | storemanager |

	#{color:#172b4d}*User Story :* {color}
	#
	# As a store manager and sales manager, I should be able to add an event
	#
	#{color:#172b4d} {color}
	#
	#{color:#172b4d}*_Acceptance Criteria:_*{color}
	#
	# *1*- "Manage Filter" button should be hidden by default.
	# {color:#de350b}*2*- When a user clicks on the filter icon, the "Manage Filter" button should be visible{color}
	# *3*- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
	# *4*- User can apply filters by typing the filter name, from the 'Manage Filters' menu.
	# *5*- User can apply multiple filters at the same time
	# *6*- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module
  @TRN-1211
  Scenario Outline: 2.Manage filter options should be displayed after clicking
    Given the "<userType>" is on the Vehicles page
    When the user click the filter button
    Then Manage filter options should be displayed after clicking
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

	#{color:#172b4d}*User Story :* {color}
	#
	#As a store manager and sales manager, I should be able to add an event
	#
	#{color:#172b4d} {color}
	#
	#{color:#172b4d}*_Acceptance Criteria:_*{color}
	#
	# *1*- "Manage Filter" button should be hidden by default.
	# {color:#172b4d} *2*- When a user clicks on the filter icon, the "Manage Filter" button should be visible{color}
	# *3*- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
	# {color:#de350b}*4*- User can apply filters by typing the filter name, from the 'Manage Filters' menu.{color}
	# {color:#172b4d} *5*- User can apply multiple filters at the same time{color}
	# {color:#172b4d} *6*- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module{color}
  @TRN-1212
  Scenario Outline: 4.User can apply filters by typing the filter name, from the 'Manage Filters' menu.
    Given the "<userType>" is on the Vehicles page
    And the user click the filter button
    And the user click on manage filter button
    Then User can apply filtering for each of the "<dataColumns>"  on the page

    Examples:
      | userType      | dataColumns         |
      | driver        | Driver              |
      | driver        | Tags                |


	#{color:#172b4d}*User Story :* {color}
	#
	#As a store manager and sales manager, I should be able to add an event
	#
	#{color:#172b4d} {color}
	#
	#{color:#172b4d}*_Acceptance Criteria:_*{color}
	#
	#{color:#172b4d}*1*- "Manage Filter" button should be hidden by default.{color}
	# {color:#172b4d} *2*- When a user clicks on the filter icon, the "Manage Filter" button should be visible{color}
	# *3*- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
	# {color:#172b4d} *4*- User can apply filters by typing the filter name, from the 'Manage Filters' menu.{color}
	# {color:#de350b}*5*- User can apply multiple filters at the same time{color}
	# *6*- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module
  @TRN-1213
  Scenario Outline: 5.User can apply multiple filters at the same time
    Given the "<userType>" is on the Vehicles page
    And the user click the filter button
    And the user click on manage filter button
    And select all boxes
    Then all check boxes are selected
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |


	#{color:#172b4d}*User Story :* {color}
	#
	# As a store manager and sales manager, I should be able to add an event
	#
	#{color:#172b4d} {color}
	#
	# *_Acceptance Criteria:_*
	#
	# *1*- "Manage Filter" button should be hidden by default.
	# *2*- When a user clicks on the filter icon, the "Manage Filter" button should be visible
	# *3*- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
	# {color:#172b4d} *4*- User can apply filters by typing the filter name, from the 'Manage Filters' menu.{color}
	# *5*- User can apply multiple filters at the same time
	# {color:#de350b}*6*- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module{color}
  @TRN-1214
  Scenario Outline: 6.User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module
    Given the "<userType>" is on the Vehicles page
    And the user click the filter button
    And the user click on manage filter button
    And select all boxes
    When the user click on reset button
    Then User can  remove all filterings by using the reset button
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

	#{color:#172b4d}*User Story :* {color}
	#
	#As a store manager and sales manager, I should be able to add an event
	#
	#{color:#172b4d} {color}
	#
	#{color:#172b4d}*_Acceptance Criteria:_*{color}
	#
	#{color:#172b4d}*1*- "Manage Filter" button should be hidden by default.{color}
	# {color:#172b4d} *2*- When a user clicks on the filter icon, the "Manage Filter" button should be visible{color}
	# {color:#de350b}{color:#172b4d} *3*- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.{color}{color}
	# {color:#172b4d} *4*- User can apply filters by typing the filter name, from the 'Manage Filters' menu.{color}
	# *5*- User can apply multiple filters at the same time
	# {color:#172b4d} *6*- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module{color}
  @TRN-1215
  Scenario Outline: 3.User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
    Given the "<userType>" is on the Vehicles page
    And the user click the filter button
    And the user click on manage filter button
    And select some boxes
    Then some check boxes are selected
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |