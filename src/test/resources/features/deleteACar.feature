@TRN-1161
Feature: 

	#*User Story :* 
	#
	#As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1*-*All users can see the delete button by hovering over the three dots at the end of each row*
	#
	#*2*- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
	#
	#*3*-"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.
	#
	#*4*- 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.
	#
	#*5*- When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.
	#
	#*6*-When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
	@TRN-1155
	Scenario Outline: Verify that all user can see delete button by hovering on three dots
		Given the "<userType>" is on the Vehicles page
		When the user hover on the three dots at the end each row
		Then the user can see the delete button
		Examples:
		     | userType     |
		     | driver       |
		     | salesmanager |
		     | storemanager |	

	#*User Story :* 
	#
	#As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1*-All users can see the delete button by hovering over the three dots at the end of each row
	#
	#*2*- *"Delete Confirmation" pop up should be displayed when the user clicks on the delete button*
	#
	#*3*-"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.
	#
	#*4*- 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.
	#
	#*5*- When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.
	#
	#*6*-When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
	@TRN-1156
	Scenario Outline: Verify that after clicking on delete button Delete Confirmation pop up should be displayed
		Given the "<userType>" is on the Vehicles page
		When the user hover on the three dots at the end each row
		And the user click on the delete button
		Then the Delete Confirmation should be display
		Examples:
		    | userType     |
		    | driver       |
		    | salesmanager |
		    | storemanager |

	#*User Story :* 
	#
	#As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1*-All users can see the delete button by hovering over the three dots at the end of each row
	#
	#*2*- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
	#
	#*3*-*"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.*
	#
	#*4*- 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.
	#
	#*5*- When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.
	#
	#*6*-When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
	@TRN-1157
	Scenario: Verify that the user as a driver should not able to delete a car
		Given the "driver" is on the Vehicles page
		When the user hover on the three dots at the end each row
		And the user click on the delete button
		And the user click on the Yes, Delete button from pop up Delete Confirmation
		Then for user the message "You do not have permission to perform this action." should be displayed	

	#*User Story :* 
	#
	#As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1*-All users can see the delete button by hovering over the three dots at the end of each row
	#
	#*2*- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
	#
	#*3*-"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.
	#
	#*4*- *'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.*
	#
	#*5*- When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.
	#
	#*6*-When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
	@TRN-1158
	Scenario Outline: Verify that the user as Sales Manager & Store Manager should able to delete a car
		Given the "<userType>" is on the Vehicles page
		When the user hover on the three dots at the end each row
		And the user click on the delete button
		And the user click on the Yes, Delete button from pop up Delete Confirmation
		Then for user the message "Item deleted" should be displayed
		   Examples:
		      | userType     |
		      | salesmanager |
		      | storemanager |	

	#*User Story :* 
	#
	#As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1*-All users can see the delete button by hovering over the three dots at the end of each row
	#
	#*2*- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
	#
	#*3*-"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.
	#
	#*4*- 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.
	#
	#*5*- *When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.*
	#
	#*6*-When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
	@TRN-1159
	Scenario Outline: Verify that the user as Sales Manager & Store Manager should able to delete a car from General Information page
		Given the "<userType>" is on the Vehicles page
		And the user click on any random row in vehicle page
		When the user click on the delete button in General Information page
		And the user click on the Yes, Delete button from pop up Delete Confirmation
		Then for user the message "Car deleted" should be displayed
		    Examples:
		      | userType     |
		      | salesmanager |
		      | storemanager |	

	#*User Story :* 
	#
	#As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1*-All users can see the delete button by hovering over the three dots at the end of each row
	#
	#*2*- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
	#
	#*3*-"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.
	#
	#*4*- 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.
	#
	#*5*- When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.
	#
	#*6*-*When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.*
	@TRN-1160
	Scenario Outline: Verify that the deleted car is removed from vehicle page
		Given the "<userType>" is on the Vehicles page
		When the user delete a car from vehicle page
		Then the deleted car should be removed from vehicle page
		
		    Examples:
		      | userType     |
		      | salesmanager |
		      | storemanager |