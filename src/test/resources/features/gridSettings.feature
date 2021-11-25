
Feature:  Arranging vehicle table columns via "grid settings" functionality

  Background: User login
   Given the user is on the loginpage

Scenario: "Grid Settings" should be visible when the user clicks on the gear icon
  Given the user logged in as "<userType>"
  When the user navigates to "Fleet-Vehicles" page
  And the user clicks on the gear icon
  Then the user see the "Grid Settings"




#1-"Grid Settings" should be visible when the user clicks on the gear icon
#2-Column names in grid settings should be shown as below:
#-Id
#-License Plate
#-Tags
#-Driver
#-Location
#-Chassis Number
#-Model Year
#-Last Odometer
#-Immatriculation Date
#-First Contract Date
#-Catalog Value (VAT Incl.)
#-Seats Number
#-Doors Number
#-Color
#-Transmission
#-Fuel Type
#-CO2 Emissions
#-Horsepower
#-Horsepower Taxation
#-Power (KW)
#3-User can find any column name by typing on the "Quick Search" input box
#4-User can select the columns to be displayed by clicking the column name
#5-User can arrange the order of the columns (by dragging and dropping)
#6- User can see all corresponding changes under the 'Fleet-Vehicles' page