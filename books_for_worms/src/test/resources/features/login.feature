Feature: User Login Feature use my application, want to be able to Login

Background:
    Scenario: Verification of Login Function (Successful Login)
	    Given I am on the Login Page
 	    When I input a valid username
        When I input a valid password
        When I click on the login button
	    Then I should see the homepage


