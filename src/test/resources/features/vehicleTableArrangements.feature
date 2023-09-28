@task
Feature: Vehicle Table Arrangements

  User Story:
  As a user, I should be able to arrange vehicle table data under Fleet-Vehicle page

  Background:
    Given The user on the login page

  Scenario: Verify that the user can arrange rows/vehicle numbers on 'View Per Page' dropdown under Fleet-Vehicles module
    When The user opens Fleet Vehicles module
    Then The car record should match with the selected number below in View Per Page dropdown

  Scenario: Verify that he value of View Per Page should be 25 by default
    When The user opens Fleet Vehicles module
    Then The number in dropdown should be 25 by default

  Scenario: Verify that the user can select rows/vehicle numbers in dropdown
    When The user opens Fleet Vehicles module
    Then View Per Page includes the following vehicle numbers and each of them is selectable
      | 10  |
      | 25  |
      | 50  |
      | 100 |

  Scenario: Verify that the user can sort a column in ascending and descending order by clicking the column name
    When The user opens Fleet Vehicles module
    And The user clicks on the Model Year column name
    Then The Model Year column is sorted in ascending order
    When The user clicks on the Model Year column name
    Then The Model Year column is sorted in descending order

  Scenario: Verify that the user can remove all sorting on the page by using the reset button
    When The user opens Fleet Vehicles module
    And The values in Model Year column gets stored before sorting
    And The user clicks on the Model Year column name
    Then The order gets compared before and after sorting
    When The user clicks the reset button
    Then The user verifies all sorting is removed

  Scenario: Verify that the user can remove all filtering on the page by using the reset button
    When The user opens Fleet Vehicles module
    And The values in Model Year column gets stored before filtering
    And The user clicks on the Filters button and selects the Model Year checkbox under the Manage filters
    And The user clicks on the Model Year:All dropdown, selects Is Equal To option, enters 1980 and clicks Update button
    Then All values in the Model Year column equals to 1980 after filtering
    When The user clicks the reset button
    Then The user verifies all filtering is removed




