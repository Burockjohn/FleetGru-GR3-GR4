@FLT-2592
Feature: As a 'Sales Manager' and 'Store Manager', I should be able to delete a car

  User Story :

  As a 'Sales Manager' and 'Store Manager', I should be able to delete a car


  Acceptance Criteria:

  1-All users can see the delete button by hovering over the three dots at the end of each row

  2- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button

  3-"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.

  4- 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.

  5- When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.

  6-When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.

  Background:
    Given The user on the login page

  @FLT-2581
  Scenario Outline: As a 'Sales Manager' and 'Store Manager', I should be able to delete a car

    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user hover over the the three dots at the end of each row
    Then The user should see the Delete button

    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |


  @FLT-2582
  Scenario Outline: Delete Confirmation" pop up should be displayed when the user clicks on the delete button

    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user hover over the the three dots at the end of each row
    Then The user should see the Delete button
    When The user clicks on the delete button
    Then The user should see "Delete Confirmation"


    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |


  @FLT-2583
  Scenario:"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete"

    When User logs in as "driver"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user hover over the the three dots at the end of each row
    When The user clicks on the delete button
    And The user accepts confirmation
    Then The user should see "You do not have permission to perform this action." message


  @FLT-2584
  Scenario Outline: 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.

    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user hover over the the three dots at the end of each row
    Then The user should see the Delete button
    When The user clicks on the delete button
    Then The user should see "Delete Confirmation"
    When The user accepts confirmation
    Then The user should see "Item deleted" flash message


    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |

  @FLT-2590
  Scenario Outline:When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.

    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on any car
    And The user clicks on the delete button on the page
    Then The user should see "Delete Confirmation"
    When The user accepts confirmation
    Then The user should see "Car deleted" flash message


    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |


  @FLT-2591
  Scenario Outline:  When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.

    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on any car
    And The user clicks on the delete button on the page
    Then The user should see "Delete Confirmation"
    When The user accepts confirmation
    Then The user should see "Car deleted" flash message
    And The user should see that the car is missing


    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |