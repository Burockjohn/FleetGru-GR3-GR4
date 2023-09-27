Feature: As a store manager and sales manager, I should be able to add an event

  User Story :
  As a store manager and sales manager, I should be able to add an event

  Acceptance Criteria:

  1- User can access the "Add Event" page from the "General Information" page (by clicking on any vehicle/row under Fleet-Vehicle module)
  2- Sales Manager and Store manager can click "Add Event" button, but Driver can NOT see "Add Event" button
  3- After clicking on "Add event" button, "Add Event" page should pop up.
  4- Compulsory fields are shown as below:
  -> Title
  -> Owner
  -> Organizer display name
  -> Organizer email
  -> Start Date
  -> End Date
  5- If any compulsory field is not filled, the "This value should not be blank." message should be displayed after clicking on the save button.

  Background:
    Given The user on the login page

    #AC1- User can access the "Add Event" page from the "General Information" page (by clicking on
    #     any vehicle/row under Fleet-Vehicle module)
  Scenario: Store/Sales Managers should access the "Add Event" page from the "General Information" page
    When The "Store Manager" log in with username and password
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks the the vehicle in the first row
    Then The user see the Add Event button on the right upper corner