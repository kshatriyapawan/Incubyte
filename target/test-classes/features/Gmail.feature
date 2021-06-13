
@tag
Feature: Yahoo login and sending mail feature
  Sending an email from Yahoo mail Login	

  Scenario: Login as an authentic user and land on mailbox page
    Given navigate to Gmail page
		And user logged in using username and password
		And gmail mailbox page should be displayed		
    And User clicks on compose email
    When Compose an email and send it
    Then check more outcomes

