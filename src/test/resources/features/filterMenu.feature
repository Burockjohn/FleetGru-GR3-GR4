@FLT-2599
Feature: Filter feature

  As a store manager and sales manager, I should be able to use filter options



  Acceptance Criteria:
  1- When a user clicks on the filter icon, the "Manage Filter" button should be visible
  2- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
  3- User can apply filters by typing the filter name, from the 'Manage Filters' menu.
  4- User can apply multiple filters at the same time
  5- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module

  Background: User logins as a user
    Given The user goes to the login page


@FLT-2594
  Scenario Outline:"Manage Filter" button should be visible after the filter icon is clicked

    And User logs in as "<userType>"
    When The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on the filter icon
    Then manage filter link should be visible
    Examples:
      | userType      |
      | store manager |
      | sales manager |


  @FLT-2595
  Scenario Outline: Apply filter by clicking on the filter name
    And User logs in as "<userType>"
    When The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on the filter icon
    And The user clicks on the manage filters link
    And The user clicks on the filter name "<filterName>"
    Then The filter "<filterName>" should be listed in chosen filters area

    Examples:
      | userType      | filterName    |
      | store manager | License Plate |
      | sales manager | License Plate |
      | store manager | Tags          |
      | sales manager | Tags          |
      | store manager | Driver        |
      | sales manager | Driver        |



  @FLT-2596
  Scenario Outline: Apply filters by typing the filter name rom the "Manage Filters" menu
    And User logs in as "<userType>"
    When The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on the filter icon
    And The user clicks on the manage filters link
    And The user enters "<filterName>" into filter input box
    Then The filter "<filterName>" should be shown in the dropdown
    Examples:
      | userType      | filterName    |
      | store manager | License Plate |
      | sales manager | License Plate |
      | store manager | Tags          |
      | sales manager | Tags          |
      | store manager | Driver        |
      | sales manager | Driver        |


@FLT-2597
  Scenario Outline: Apply multiple filters at the same time
    And User logs in as "<userType>"
    When The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on the filter icon
    And The user clicks on the manage filters link
    And The user enters multiple filters into filter input box
      | Tags      |
      | Driver    |
      | Fuel Type |
    Then The filters blow should be listed in chosen filters area
      | Tags      |
      | Driver    |
      | Fuel Type |
    Examples:
      | userType      |
      | store manager |
      | sales manager |



@FLT-2598
  Scenario Outline: Remove all filters by clicking on the reset icon
    And User logs in as "<userType>"
    When The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on the filter icon
    And The user clicks on the manage filters link
    And The user enters multiple filters into filter input box
      | Tags      |
      | Driver    |
      | Fuel Type |
    Then The filters blow should be listed in chosen filters area
      | Tags      |
      | Driver    |
      | Fuel Type |
    When The user clicks on the reset icon
    Then Filter functionality should be reset
    Examples:
      | userType      |
      | store manager |
      | sales manager |

