Feature: Non-user search Feature
    As a non-user, I can search for book detail based on search criteria

Background:
    Given a non-user is on the home page
    
    Scenario: A non-user searches for a book using the title criteria
    	When a non-user enters a book title
  	    And clicks on the submit button
   	    Then the non-user can see the book details
     





   




