Feature: Vehicle Table Arrangements

  User Story:
  As a user, I should be able to arrange vehicle table data under Fleet-Vehicle page

  Background:
    Given The user on the login page

  Scenario: Verify that the user can arrange rows/vehicle numbers on 'View Per Page' dropdown under Fleet-Vehicles module
    When The user opens Fleet Vehicles module
    And The user selects the following vehicle numbers in View Per Page dropdown
      | 10  |
      | 25  |
      | 50  |
      | 100 |
    Then The number of the listed cars should match with the selected number in dropdown

  Scenario: Verify that he value of View Per Page should be 25 by default
    When The user opens Fleet Vehicles module
    Then The number in dropdown should be 25 by default

  Scenario: Verify that the user can select rows/vehicle numbers in dropdown
    When The user opens Fleet Vehicles module
    And The user selects the following vehicle numbers in View Per Page dropdown
      | 10  |
      | 25  |
      | 50  |
      | 100 |

  Scenario: Verify that the user can sort a column in ascending or descending order by clicking the column name
    When The user opens Fleet Vehicles module
    And The user clicks on the Model Year column name
    Then The Model Year column is sorted in ascending order
    When The user clicks on the Model Year column name
    Then The Model Year column is sorted in descending order

  Scenario: Verify that the user can remove all sorting and filtering on the page by using the reset button
    When The user opens Fleet Vehicles module
    And The values in Model Year column gets stored in a List
    And The user clicks the Driver column name
    Then The user dosn't display "Jerry Lindgren 3" as the first driver
    Then The user clicks the reset button
    And The user displays "Jerry Lindgren 3" as the first driver




