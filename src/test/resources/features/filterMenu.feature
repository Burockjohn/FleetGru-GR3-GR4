@filterFunctionality
Feature: Filter feature

  As a store manager and sales manager, I should be able to use filter options



  Acceptance Criteria:
  1- When a user clicks on the filter icon, the "Manage Filter" button should be visible
  2- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
  3- User can apply filters by typing the filter name, from the 'Manage Filters' menu.
  4- User can apply multiple filters at the same time
  5- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module


  Scenario Outline:"Manage Filter" button should be visible after the filter icon is clicked

    Given The user goes to the login page
    And User logs in as "<userType>"
    When The user hover over Fleet menu then clicks Vehicles page
    And The user clicks on the filter icon
    Then manage filter link should be visible
    Examples:
      | userType      |
      | store manager |
      | sales manager |


  Scenario Outline: Apply filter by clicking on the filter name
    Given The user goes to the login page
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


  Scenario Outline: Apply filters by typing the filter name rom the "Manage Filters" menu
    Given The user goes to the login page
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



  Scenario Outline: Apply multiple filters at the same time
    Given The user goes to the login page
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




  Scenario Outline: Remove all filters by clicking on the reset icon
    Given The user goes to the login page
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

