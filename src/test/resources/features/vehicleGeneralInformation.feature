Feature:As a user, I should be able to see the detailed information of a specific vehicle
  (General Information Page)
  User Story :

  As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)



  Acceptance Criteria:

  1- User can see the "General Information" page by clicking on any vehicle (row), under 'Fleet-Vehicle' module
  2- User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module
  3- Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
  4- Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
  5- Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same

  Background:

    Given the user is on the login page



  Scenario: User should see Vehicle ınformation page
    When User can see the "General Information"  page by clicking on any vehicle (row), under Fleet-Vehicle module
    And User can see the "General Information" page clicking on the Eye (View) icon at the end of each row, under Fleet-Vehicle module


  Scenario: Sales manager uses  uses edit delete add button
    When Sales manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page

  Scenario: store manager uses edit delete add button
    And store manager should see " Edit", " Delete" and " Add Event" buttons on the "General Information" page
  @wip
  Scenario:  Driver can not see  edit delete add button
    And Driver shouldn't see "Edit", "Delete" and "Add Event" buttons

  Scenario: same information
    When Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same
