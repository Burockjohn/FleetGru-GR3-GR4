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

  Scenario Outline: 1- All user types can see all vehicle information under 'Fleet-Vehicles' module
    When User logs in as "<userType>"
    And User navigates to Dashboard Fleet-Vehicle page
    Then User should see all vehicle information
    Examples:
      | userType     |
      | driver       |
      | storemanager |
      | salesmanager |

  Scenario Outline: 2- User can see the total page number
    When User logs in as "<userType>"
    And User navigates to Dashboard Fleet-Vehicle page
    Then User should see total page number
    Examples:
      | userType     |
      | driver       |
      | storemanager |
      | salesmanager |

  Scenario Outline: 3- User can go to next page clicking ">" button and can go to previous page clicking "<" button
    When User logs in as "<userType>"
    And User navigates to Dashboard Fleet-Vehicle page
    And User clicks "<button>" for next-previous page
    Then User can see next page
    Examples:
      | userType     |
      | driver       |
      | storemanager |
      | salesmanager |
    Examples:
      | button     |
      | driver       |
      | storemanager |

    Scenario Outline: 4- User can see total recordings of vehicles
      When User logs in as "<userType>"
      And User navigates to Dashboard Fleet-Vehicle page
      Then User should see total recordings of vehicles
      Examples:
        | userType     |
        | driver       |
        | storemanager |
        | salesmanager |

      Scenario Outline:  5- User can download table data in XLS or CSV format from "Export Grid" (a confirmation message is enough to validate)
        When User logs in as "<userType>"
        And User navigates to Dashboard Fleet-Vehicle page
        And User clicks "<download_btn>" from export grid
        Then User should download table data
        Examples:
          | userType     |
          | driver       |
          | storemanager |
          | salesmanager |
        Examples:
          | download_btn |
          | csv          |
          | xlsx         |





