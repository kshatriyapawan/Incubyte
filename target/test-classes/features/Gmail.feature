#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Gmail login and sending mail feature
  Sending an email from Gmail Login

  Scenario: Login as an authentic user and create a mail
    Given User logged on to Gmail home page
    When User navigates to Login Page and User enetrs credentials
    And User lands on Mailbox page
    Then Compose an email and send it
    And check more outcomes

