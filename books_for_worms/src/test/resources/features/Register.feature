Feature: User Registration Feature 
  	In order to use my application, want to be able to register

Background: 
	Given a non-user is on the home page 
	    And non-user follows the register 
 	    Scenario: Create a New User 
		When a user enters a valid username “johndoe”
		When a user enters a valid password “pass1234”
		When a user enters a valid email “johndeo@gmail.com”
		And clicks on the register button
        Then users can see the successful registration message
