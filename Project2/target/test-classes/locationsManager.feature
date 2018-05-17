Feature: modify locations page as an admin

Background:
#When logged in as an admin
When the locatiton page is selected


@LocationsAdminScenario
Scenario: login as a VP and navigate to the locations page. Add a locations form that page
When add location button pressed
Then check if pop up opened
Given location name, city, and state
When save button clicked
Then check if the location was added

@LocationsAdminScenario
Scenario: once a location is added then try to add a building to the location
When newly added location is selected press the add building button
Then see if the new building pop up appears
Given a building name
Then see if the building was added


@LocationsAdminScenario
Scenario: try to add a room to a location
When newly added location is selected press the add room button
#Given a room name
#Then check if the room was added


#@LocationsAdminScenario
#Scenario: after adding a new building try adding specific rooms to that building
#When newly added building is selected
#Then see if room pop up appears
#Given a room name
#Then see if the room was added
#
#@LocationsAdminScenario
#Scenario: try to add a building to a room
#When newly added room is selected press the add location button
#Then see if the pop up window appears
#
#@LocationsAdminScenario
#Scenario: Modify location, building and room
#When newly added room is selected, edit button pressed
#Then see if room pop up window appears
#Given a new room number, save is pressed
#Then see if the room was modified
#When newly added building is selected, edit button pressed
#Then see if the building pop up opens
#When building info is given, save is pressed
#Then check if the building was modified
#When the newly added location is selected, edit button is pressed
#Then see if building pop up opens
#Given new location information
#When the save button is pressed
#Then is the location modified
#
#@LocationsAdminScenario
#Scenario: Delete selected
#When newly modified room is selected, inactivate selected button pressed
#Then see if the room was deleted
#When newly modified buidling is selected, inactivate button pressed
#Then see if building was deleted
#When newly modified location is selected, inactivate selected button pressed
#Then see if location was deleted

