@FLT-2549
Feature: Vehicle Table Arrangements

  User Story:
  As a user, I should be able to arrange vehicle table data under Fleet-Vehicle page

  Background:
    Given The user on the login page
    And The user logs in
    And The user opens Fleet Vehicles module

  @FLT-2543
  Scenario: Verify that the user can arrange rows/vehicle numbers on 'View Per Page' dropdown under Fleet-Vehicles module
    Then The car record should match with the selected number below in View Per Page dropdown

  @FLT-2544
  Scenario: Verify that he value of View Per Page should be 25 by default
    Then The number in dropdown should be "25" by default

  @FLT-2545
  Scenario: Verify that the user can select rows/vehicle numbers in dropdown
    Then View Per Page includes the following vehicle numbers and each of them is selectable
      | 10  |
      | 25  |
      | 50  |
      | 100 |

  @FLT-2546
  Scenario: Verify that the user can sort a column in ascending and descending order by clicking the column name
    When The user selects one hundred in View Per Page dropdown
    And The values in Model Year column gets stored before changing
    And The user clicks on the Model Year column name
    Then The Model Year column is sorted in ascending order
    When The user clicks on the Model Year column name
    Then The Model Year column is sorted in descending order

  @FLT-2547
  Scenario: Verify that the user can remove all sorting on the page by using the reset button
    When The user selects one hundred in View Per Page dropdown
    And The values in Model Year column gets stored before changing
    And The user clicks on the Model Year column name
    Then The order gets compared before and after sorting
    When The user clicks the reset button
    Then The user verifies all changing is removed

  @FLT-2548
  Scenario: Verify that the user can remove all filtering on the page by using the reset button
    When The user selects one hundred in View Per Page dropdown
    And The values in Model Year column gets stored before changing
    And The user clicks on the Filters button and selects the Model Year checkbox under the Manage filters
    And The user clicks on the Model Year:All dropdown, selects Is Equal To option, enters "1980" and clicks Update button
    Then All values in the Model Year column equals to "1980" after filtering
    When The user clicks the reset button
    Then The user verifies all changing is removed




