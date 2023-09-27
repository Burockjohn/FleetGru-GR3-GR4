Feature: As a user, I should be able to see the detailed information of a specific vehicle
  User Story :

  As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)



  Acceptance Criteria:

  1- User can see the "General Information" page by clicking on any vehicle (row), under 'Fleet-Vehicle' module
  2- User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module
  3- "Sales manager" and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
  4- Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
  5- Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same

  Background:
    Given The user on the login page
    Scenario: General Information Page displayed
    When  User can see the "General Information" page by clicking on any vehicle under 'Fleet-Vehicle' module
    And User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module
    And "Sales manager" and "store manager" should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
    And "Driver" shouldn't see "Add Event", "Edit" and "Delete" buttons
    Then Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same