Feature: User should be able to login using correct credentials

@login

Scenario: Positive login scenario
Given user is on the login page
When user enters username "salesmanager103"
And user enters password "UserUser123"
Then user clicks to login button
