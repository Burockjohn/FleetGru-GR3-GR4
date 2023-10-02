Feature: Filter feature

  As a user, I should be able to use filter options



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


  @yunus
  Scenario Outline: Applay filter by clicking on the filter name
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