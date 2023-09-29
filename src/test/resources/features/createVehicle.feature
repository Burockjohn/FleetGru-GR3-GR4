@FLT-2500
Feature: Fleetgru app Create Vehicle

  User Story
  As a user, I should be able to create a vehicle

  Acceptance Criteria
  1. "Create Car" button shouldn't be displayed for the driver
  2. "Create Car" button should be displayed for Store /Sales Manager on the "All Cars" page
  3. Authorised user should land in the "Create Car" page after clicking on the "Create Car button"
  4. Form data structure should be as below:
  – License Plate: Alpha-numerical
  – Tags: Multiple Selection of below data

  Junior
  Senior
  Employee Car
  Purchased
  Compact
  Sedan
  Convertible
  Driver: Alphabetical
  Location: Alphabetical
  Chassis Number: Alphanumerical
  Model Year: Numerical
  Last Odometer: Numerical
  Immatriculation Date : Date(MM dd, yyyy)
  First Contract Date: Date (MM dd, yyyy)
  Catalog Value (VAT incl.) ($) : Numerical
  Seat Number: Numerical
  Doors Number: Numerical
  Colour: Alphabetical
  Transmission: Multiple Selection of
  Automatic
  Manual
  Fuel Type: Multiple Selection of
  Gasoline
  Diesel
  Electric
  Hybrid
  CO2 Emissions: Numeric
  Horsepower: Numeric
  Horsepower Taxation: Numeric
  Power (KW) : Numeric
  Logo: JPEG, PNG, if no file uploaded
  5. There should be 3 different saving options:

  Save: if selected, remains the same page and keeps the form data
  Save and New: if selected, remains on the same page and clean the form data
  Save and Close: if selected, navigates to the "General Information" page
  (validate buttons by using valid data)
  6. "Entity Saved" message should be displayed after successful saving

  Background:
    Given The user on the login page

  @FLT-2519
  Scenario: The driver can not see Create Car button
    When The driver log in with username and password
    And The driver hover over Fleet menu then clicks Vehicles page
    Then The driver can not see Create Car button

  @FLT-2521
  Scenario Outline: Sales manager and store manager can see "Create Car" button
    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    Then The user should see the Create Car button
    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |

  @FLT-2522
  Scenario Outline: Authorised user should land in the "Create Car" page
    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks Create Car button
    Then The user land on the "Create Car" page
    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |


  Scenario Outline: Create Vehicle Form data structure
    When The user log in with "<username>" and "<password>"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks Create Car button
    Then The user should fill out the create car form in accordance with the rules.
    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |

  Scenario: User should be filled out with the invalid data-Negative scenario
    When User logs in as "sales manager"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks Create Car button
    And User  fills out the form with the invalid data
    Then User should not save after invalid entry

  Scenario: Verifying there should be 3 different saving options
    When User logs in as "sales manager"
    And The user hover over Fleet menu then clicks Vehicles page
    And The user clicks Create Car button
    And The user should fill out the create car form in accordance with the rules.
    Then User should remain on the same page if ''Save'' is selected
    And User should remain on the same page but the data should be removed if ''Save and New'' is selected
    And User should be navigated to the General Information page if ''Save and Close'' is selected
    And User should see "Entity saved" message after saving data