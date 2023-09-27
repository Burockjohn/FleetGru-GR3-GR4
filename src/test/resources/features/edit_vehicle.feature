Feature: Fleetgru application - vehicle edition function

  User Story
  As a user, I should be able to edit a vehicle

  Acceptance Criteria
  1. User should navigate to the editing page.
  1.1. By clicking the Edit button in the General Information Page (shouldn't be displayed for the driver)
  1.2. By clicking the editing button under ''...'' at the end of each row

  2. "Edit" button shouldn't be displayed for the driver. If the driver tries to edit using ...,"You do not have permission to perform this action." message should be displayed.

  3. Page subtitle should be consist of the license plate and driver name.

  4. Form should be filled out with the corresponding data.

  5. Form data structure should be as below:
      – License Plate: Alpha-numerical            false (special)
      – Tags: Multiple Selection of below data

          Junior
          Senior
          Employee Car
          Purchased
          Compact
          Sedan
          Convertible

      Driver: Alphabetical                        false (number)
      Location: Alphabetical                      false (number)
      Chassis Number: Alphanumerical              false (no letter)
      Model Year: Numerical                       false (alphabetical)
      Last Odometer: Numerical                    true
      Immatriculation Date : Date(MM dd, yyyy)    true
      First Contract Date: Date (MM dd, yyyy)     true
      Catalog Value (VAT incl.) ($) : Numerical   true
      Seat Number: Numerical                      false (+- limitless)
      Doors Number: Numerical                     false (+- limitless)
      Colour: Alphabetical                        false (number)
      Transmission: Multiple Selection of

          Automatic
          Manual

      Fuel Type: Multiple Selection of

          Gasoline
          Diesel
          Electric
          Hybrid

      CO2 Emissions: Numeric                      true
      Horsepower: Numeric                         true
      Horsepower Taxation: Numeric                true
      Power (KW) : Numeric                        true
      Logo: JPEG, PNG, if no file uploaded

  6. There should be 3 different saving options:

  Save: if selected, remains the same page and keeps the form data
  Save and New: if selected, remains on the same page and clean the form data
  Save and Close: if selected, navigates to the "General Information" page (validate buttons by using valid data)

  7. "Entity Saved" message should be displayed after successful saving.

  Background:
    Given The user on the login page


  Scenario: 1.1 - Navigating to the editing page by clicking a row (except for driver)
    When User logs in as "sales manager"
    And User navigates to Dashboard Fleet-Vehicle page
    And  User clicks on a row in the table
    And User click on Edit button located in the upper right corner of the page
    Then User navigates to the Edit page


  Scenario: 1.2 - Navigating to the editing page by clicking edit button (except for driver)
    When User logs in as "sales manager"
    And User navigates to Dashboard Fleet-Vehicle page
    And User clicks the editing button under 3dot sign at the end of the row
    Then User navigates to the Edit page


  Scenario: 2 - Verifying that driver should not see edit button so that he can not edit
    When User logs in as "driver"
    And User navigates to QuickLaunchpad Fleet-Vehicle page
    And User clicks the editing button under 3dot sign at the end of the row
    Then User sees "You do not have permission to perform this action." message


  Scenario: 3 - Verifying edit page consists of the license plate and driver name
    When User logs in as "sales manager"
    And User navigates to Dashboard Fleet-Vehicle page
    And User clicks the editing button under 3dot sign at the end of the row
    Then User sees the subtitle as license plate and driver name

  @wip
  Scenario: 4/7 - edit form should be filled out with the valid data
    When User logs in as "sales manager"
    And User navigates to Dashboard Fleet-Vehicle page
    And User clicks the editing button under 3dot sign at the end of the row
    And User fills out the form with the valid data
    Then User should see the "Entity Saved" message after saving data


  Scenario: 5 - edit form should be filled out with the invalid data
    When User logs in as "sales manager"
    And User navigates to Dashboard Fleet-Vehicle page
    And User clicks the editing button under 3dot sign at the end of the row
    And User  fills out the form with the invalid data
    Then User should not save after invalid entry


  Scenario: 6 - Verifying there should be 3 different saving options
    When User logs in as "sales manager"
    And User navigates to Dashboard Fleet-Vehicle page
    And User clicks the editing button under 3dot sign at the end of the row
    And User fills out the form with the valid data
    Then User should remain on the same page if ''Save'' is selected
    And User should remain on the same page but the data should be removed if ''Save and New'' is selected
    And User should be navigated to the General Information page if ''Save and Close'' is selected


  Scenario: 7 - Verifying "Entity Saved" message should be displayed
    When User logs in as "sales manager"
    And User navigates to Dashboard Fleet-Vehicle page
    And User clicks the editing button under 3dot sign at the end of the row
    And User fills out the form with the valid data
    Then User should see the "Entity Saved" message after saving data



