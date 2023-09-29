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

    #AC3- After clicking on "Add event" button, "Add Event" page should pop up.
  Scenario:  Store/Sales Managers should see "Add Event" page after clicking "Add event" button
    When The "Store Manager" log in with username and password
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks the the vehicle in the first row
    And The user clicks on Add event button
    Then The user should see Add Event page

      #AC4- Compulsory fields are shown as below:
      #  -> Title
      #  -> Owner
      #  -> Organizer display name
      #  -> Organizer email
      #  -> Start Date
      #  -> End Date
  Scenario: Store/Sales Managers should see Compulsory fields as shown up
    When The "Store Manager" log in with username and password
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks the the vehicle in the first row
    And The user clicks on Add event button
    Then The user should see all the required fields

    #AC5- If any compulsory field is not filled, the "This value should not be blank."
          # message should be displayed after clicking on the save button.

  Scenario Outline: User should get the "This value should not be blank." message if title left blank.
    When The "Store Manager" log in with username and password
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks the the vehicle in the first row
    And The user clicks on Add event button
    And The user enters required information except "<empty field>"
    Then The user should get the message

    Examples:
      | empty field        |
      | Title              |
      | Owner Display Name |
      | Owner Email        |


