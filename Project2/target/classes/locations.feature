Feature: View Revature locations, buildings, and rooms


@TryAllEntries
Scenario: Select an entry that has a location, buliding and room

When locations button pressed
Then check the url
Given a location
	And with a building 
	And room
When the location is clicked
Then does a building dropdown window open
When the building is clicked
Then does a room dropdown window open
When logout button clicked
Then check if the login screen is loaded
	And close the test