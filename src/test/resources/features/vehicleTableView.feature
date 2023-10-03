#@FLT-2490
Feature: Fleetgru application - Vehicle Table View Function

  User Story :

  As a user, I should be able to see all vehicle information in a table under Fleet-Vehicle page



  Acceptance Criteria:

  1- All user types can see all vehicle information under 'Fleet-Vehicles' module
  2- User can see the total page number
  3- User can go to next page clicking ">" button and can go to previous page clicking "<" button
  4- User can see total recordings of vehicles
  5- User can download table data in XLS or CSV format from "Export Grid" (a confirmation message is enough to validate)

  Background:
    Given The user on the login page
#@FLT-2550
  Scenario Outline: 1- All user types can see all vehicle information under 'Fleet-Vehicles' module
    When User logs in as each "<role>"
    And The user hover over Fleet menu then clicks Vehicles page
    Then User should see all vehicle information
    Examples:
      | role     |
      | store manager  |
      | driver |
      | sales manager |
#@FLT-2551 DONE
  Scenario Outline: 2- User can see the total page number
    When User logs in as each "<role>"
    And The user hover over Fleet menu then clicks Vehicles page
    Then User should see total page number
    Examples:
      | role     |
      | driver       |
      | store manager |
      | sales manager |
  #@FLT-2552
  Scenario Outline: 3- User can go to next page clicking ">" button and can go to previous page clicking "<" button
    When User logs in as each "<role>"
    And The user hover over Fleet menu then clicks Vehicles page
    And User clicks "<button>" for next previous page
    Then User can see next page
    Examples:
      | role     |
      | driver       |
    Examples:
      | button     |
      | next       |
      | previous   |
  #@FLT-2553
    Scenario Outline: 4- User can see total recordings of vehicles
      When User logs in as each "<role>"
      And The user hover over Fleet menu then clicks Vehicles page
      Then User should see total recordings of vehicles
      Examples:
        | role     |
        | driver       |
        | storemanager |
        | salesmanager |
#@FLT-2554
      Scenario Outline:  5- User can download table data in XLS or CSV format from "Export Grid" (a confirmation message is enough to validate)
        When User logs in as each "<role>"
        And The user hover over Fleet menu then clicks Vehicles page
        And User clicks "<download_btn>" from export grid
        Then User should download table data
        Examples:
          | role     |
          | driver       |
          | storemanager |
          | salesmanager |
        Examples:
          | download_btn |
          | csv          |
          | xlsx         |





