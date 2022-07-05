Feature: User Registration Feature

	Scenario: Register a New User
		Given a user is on the home page
		When a non-user clicks on the Register page
		When a non-user inputs a valid username
		When a non-user inputs a valid password
		When a non-user inputs a valid email
		And clicks on the register button
		Then users should be on Login page


