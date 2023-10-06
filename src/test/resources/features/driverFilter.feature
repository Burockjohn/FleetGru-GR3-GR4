Feature: As a user, I should be able to use the "Driver" filter under the Fleet-Vehicles page

  User Story :

  As a user, I should be able to use the "Driver" filter under the Fleet-Vehicles page



  Acceptance Criteria:

  1- User can select "Driver" filter under 'Fleet-Vehicles' module

  2- "Driver" filter should provide the methods shown as below:
  -> Contains
  -> Does Not Contain
  -> Is Equal To
  -> Starts With
  -> Ends With
  -> Is Any Of
  -> Is Not Any Of
  -> Is Empty
  -> Is Not Empty

  3- When user selects "Contains" method with a keyword, the results should contain the specified keyword

  4- When user selects "Does Not Contain" method with a keyword, the results should not contain the specified keyword

  5- When user selects "Starts-with" method with a keyword, the results should start with the specified keyword

  6- When user selects "Ends With" method with a keyword, the results should end with the specified keyword

  7- When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly

  8- Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters


  Background:
    Given user is on the login page
    When user enters username "user1"
    And user enters password "UserUser123"
    Then user clicks to login button
    When User should hover over the Fleet tab on the top left and select the Vehicle option.
    When User should click on the filters button on the top right.
    And User should click on the Manage Filters tab in the upper left.
    And User should select Driver from the Manage Filter section.
    And User should click on the Driver All section next to the Manage Filter section in the upper left.


    Scenario: "Driver" filter should provide the methods shown as below
    -> Contains
    -> Does Not Contain
    -> Is Equal To
    -> Starts With
    -> Ends With
    -> Is Any Of
    -> Is Not Any Of
    -> Is Empty
    -> Is Not Empty

      When Driver filter should provide the methods shown as below all member


  Scenario: User selects "Contains" method with a keyword, the results should contain the specified keyword

    When The user should select the Contains tab.
    And The user must enter the data "a" they want to find and click on the update button click.
    Then The user can verify that the requested data "a" is contained.

  Scenario: When user selects "Does Not Contain" method with a keyword, the results should not contain the specified keyword

    When The user should select the Does Not Contain tab.
    And The user must enter the data "a" they want to find and click on the update button click.
    Then The user can verify that the requested data "a" is not contained.

  Scenario: When user selects "Starts-with" method with a keyword, the results should start with the specified keyword

    When The user should select the Starts-with tab.
    And The user must enter the data "a" they want to find and click on the update button click.
    Then The user can verify that the requested data "a" is Starts-with.

  Scenario: When user selects "Ends With" method with a keyword, the results should end with the specified keyword

    When The user should select the Ends With tab.
    And The user must enter the data "a" they want to find and click on the update button click.
    Then The user can verify that the requested data "a" is Ends With.

  Scenario: When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly

    When The user should select the Is Equal to tab.
    And The user must enter the data "Evan O'Connell" they want to find and click on the update button click.
    Then The user can verify that the requested data "Evan O'Connell" is Equal to.


    Scenario: Methods  "Contains" shouldn't accept non-alphabetical characters

      When The user should select the Contains tab.
      And The user must enter the data "**&*" they want to find and click on the update button click.
      Then The user can verify that the requested data "**&*" non-alphabetical characters verification.

  Scenario: Methods  "Starts With" shouldn't accept non-alphabetical characters

    When The user should select the Starts-with tab.
    And The user must enter the data "**&*" they want to find and click on the update button click.
    Then The user can verify that the requested data "**&*" non-alphabetical characters verification.

  Scenario: Methods  "Ends With" shouldn't accept non-alphabetical characters

    When The user should select the Ends With tab.
    And The user must enter the data "**&*" they want to find and click on the update button click.
    Then The user can verify that the requested data "**&*" non-alphabetical characters verification.

  Scenario: Methods  "Is Equal to" shouldn't accept non-alphabetical characters

    When The user should select the Is Equal to tab.
    And The user must enter the data "**&*" they want to find and click on the update button click.
    Then The user can verify that the requested data "**&*" non-alphabetical characters verification.

  Scenario: Methods  "Does Not Contain" shouldn't accept non-alphabetical characters

    When The user should select the Does Not Contain tab.
    And The user must enter the data "**&*" they want to find and click on the update button click.
    Then The user can verify that the requested data "**&*" not include non-alphabetical characters verification.