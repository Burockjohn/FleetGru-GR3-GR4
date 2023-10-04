Feature:Fleetgru application-logout function

  User Story :

  As a user, I should be able to log out

  Acceptance Criteria:

  1- The user can log out by using the log out button inside profile info and the User should land on the "Login" page after logging out.

  2- The user can not go to the home page again by clicking the step back button after successfully logging out.

  3- The user must be logged out if the user closes the open tab (all tabs if there are multiple open tabs)

  4- The user must be logged out if the user is away from the keyboard for 3 minutes (AFK)
  (if the user does not do any  mouse or keyboard action for 3 minutes)

  Background:

    Given user is on the login page
    When user enters username "salesmanager103"
    And user enters password "UserUser123"
    Then user clicks to login button

  @wip
  Scenario: Successful logout
    When User click on the profile info button
    And User click on the Logout button
    And user should see the Login page title

  Scenario:Prevent going back to hone page after logout
    When User click on the profile info button
    And User click on the Logout button
    And user should see the Login page title
    And user clicks the step back button
    Then user can not access to the main page

  """Scenario:Logout when closing the tab
    When user open vehicles page under fleet module
    And user open contacts page under customers module
    And user open calendar events page under activities module
    And user open jobs page under system module
    And user open a new tab in the same session and close rest of all pages related to Xfleet
    And user goes to the login page again
    Then user can not access to the main page

  Scenario:Logout after being inactive for 3 minutes
    When user waits for more than  180 seconds
    Then user should land on the login page
    """

