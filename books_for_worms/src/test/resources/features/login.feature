<<<<<<< HEAD
Feature: User Login Feature 
    use my application, want to be able to Login
Background: 
    Given a user is on the home page 
    And user follows the Login
    Scenario: Verification of Login Function
	    Given user on the Login Page
 	    When a user enters "username" with "test1" 
	    When a user enters "password" with "test11234"  
	    And user clicks the "log in" button
	    Then the user should see the home page
=======
Feature: User Login Feature use my application, want to be able to Login

Background:
    Scenario: Verification of Login Function (Successful Login)
	    Given I am on the Login Page
 	    When I input a valid username
        When I input a valid password
        When I click on the login button
	    Then I should see the homepage


>>>>>>> 7107c408144349067b5cf343804adc2132dac85c
