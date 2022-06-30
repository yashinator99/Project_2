Feature: Status of the feature 
   In order to use my application, want to be able to Login
Background: 
Given a user is on the library page 

    Scenario: Checking the status of the book 
	Given user on the Library Page
 	    When User see their own library (book list)
      	And User wants to update the status of the book
      	And delete the book 
     	Then Logout our own Library Page
