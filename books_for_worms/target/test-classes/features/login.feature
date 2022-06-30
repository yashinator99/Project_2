Feature: User Login Feature 
    use my application, want to be able to Login
Background: 
    Given a user is on the home page 
    And user follows the Login
    Scenario: Verification of Login Function (Successful Login)
	    Given user on the Login Page
 	    When a user enters "username" with "johndeo" 
	    When a user enters "password" with "pass1234"  
	    And user clicks the "log in" button
	    Then the user should see the home page
