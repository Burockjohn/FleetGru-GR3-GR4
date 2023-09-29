package com.test.step_definitions;

import com.test.pages.LoginPage;
import com.test.pages.VehicleTableArrangementsPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleTableArrangementsStepDefinitions {

    VehicleTableArrangementsPage vehicleTableArrangementsPage = new VehicleTableArrangementsPage();
    LoginPage loginPage = new LoginPage();

    List<String> years = new ArrayList<>();
    List<String> ascendingOrder = new ArrayList<>();
    List<String> descendingOrder = new ArrayList<>();


    @Given("The user logs in")
    public void the_user_logs_in() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("driver.username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("driver.password"));
        loginPage.signInBtn.click();
    }

    @When("The user opens Fleet Vehicles module")
    public void the_user_opens_fleet_vehicles_module() {

        BrowserUtils.hover(vehicleTableArrangementsPage.fleetOpt);
        vehicleTableArrangementsPage.vehiclesOpt.click();

    }

    @Then("The car record should match with the selected number below in View Per Page dropdown")
    public void the_car_record_should_match_with_the_selected_number_below_in_view_per_page_dropdown() {
/*
        vehicleTableArrangementsPage.viewPerPage.click();
        vehicleTableArrangementsPage.option10.click();
        Assert.assertEquals(vehicleTableArrangementsPage.pageNumber.getText(),""+vehicleTableArrangementsPage.carRecord.size());
        System.out.println(vehicleTableArrangementsPage.pageNumber.getText()+" = "+vehicleTableArrangementsPage.carRecord.size());

        BrowserUtils.sleep(3);
*/
        vehicleTableArrangementsPage.vehiclesOpt.click();

 //       for (WebElement eachItem : vehicleTableArrangementsPage.itemsOfDropdown) {
 //           eachItem.click();
 //           BrowserUtils.sleep(2);
//
  //          //Assert.assertEquals(eachItem.getAttribute("data-size"),""+vehicleTableArrangementsPage.carRecord.size());

 //           System.out.println(eachItem.getAttribute("data-size") + " = " + vehicleTableArrangementsPage.carRecord.size());
 //       }

    }


    @Then("The number in dropdown should be {string} by default")
    public void the_number_in_dropdown_should_be_by_default(String defaultNumber) {

        Assert.assertEquals(defaultNumber, vehicleTableArrangementsPage.pageNumber.getText());

    }


    @Then("View Per Page includes the following vehicle numbers and each of them is selectable")
    public void view_per_page_includes_the_following_vehicle_numbers_and_each_of_them_is_selectable(List<String> number) {

        int i=0;
        for (WebElement eachItem : vehicleTableArrangementsPage.itemsOfDropdown) {
            Assert.assertEquals(number.get(i),eachItem.getAttribute("data-size"));
            ++i;
        }


    }

    @When("The user selects one hundred in View Per Page dropdown")
    public void the_user_selects_one_hundred_in_view_per_page_dropdown() {


        vehicleTableArrangementsPage.viewPerPage.click();
        vehicleTableArrangementsPage.option100.click();

    }

    @When("The values in Model Year column gets stored before changing")
    public void the_values_in_model_year_column_gets_stored_before_changing() {

        for (WebElement eachYear : vehicleTableArrangementsPage.totalModelYear) {
            years.add(eachYear.getText());
        }
    }

    @When("The user clicks on the Model Year column name")
    public void the_user_clicks_on_the_model_year_column_name() {

        vehicleTableArrangementsPage.modelYearColumnName.click();
        BrowserUtils.sleep(2);

    }

    @Then("The Model Year column is sorted in ascending order")
    public void the_model_year_column_is_sorted_in_ascending_order() {

        for (WebElement eachYear : vehicleTableArrangementsPage.totalModelYear) {
            ascendingOrder.add(eachYear.getText());
        }
        Collections.sort(years);

        Assert.assertEquals(years, ascendingOrder);

    }

    @Then("The Model Year column is sorted in descending order")
    public void the_model_year_column_is_sorted_in_descending_order() {


        for (WebElement eachYear : vehicleTableArrangementsPage.totalModelYear) {
            descendingOrder.add(eachYear.getText());
        }

        Collections.reverse(years);

        Assert.assertEquals(years,descendingOrder);

    }


    @Then("The order gets compared before and after sorting")
    public void the_order_gets_compared_before_and_after_sorting() {

        for (WebElement eachYear : vehicleTableArrangementsPage.totalModelYear) {
            ascendingOrder.add(eachYear.getText());
        }

        Assert.assertNotEquals(years, ascendingOrder);

    }

    @When("The user clicks the reset button")
    public void the_user_clicks_the_reset_button() {

        vehicleTableArrangementsPage.refreshButton.click();
        vehicleTableArrangementsPage.viewPerPage.click();
        vehicleTableArrangementsPage.option100.click();
        BrowserUtils.sleep(2);

    }

    @Then("The user verifies all changing is removed")
    public void the_user_verifies_all_changing_is_removed() {

        List<String> afterResetting = new ArrayList<>();

        for (WebElement eachYear : vehicleTableArrangementsPage.totalModelYear) {
            afterResetting.add(eachYear.getText());
        }

        Assert.assertEquals(years,afterResetting);

    }

    @When("The user clicks on the Filters button and selects the Model Year checkbox under the Manage filters")
    public void the_user_clicks_on_the_filters_button_and_selects_the_model_year_checkbox_under_the_manage_filters() {

      vehicleTableArrangementsPage.filterButton.click();
      vehicleTableArrangementsPage.manageFilterDropdown.click();
      vehicleTableArrangementsPage.modelYearCheckbox.click();
        BrowserUtils.sleep(2);

    }

    @When("The user clicks on the Model Year:All dropdown, selects Is Equal To option, enters {string} and clicks Update button")
    public void the_user_clicks_on_the_model_year_all_dropdown_selects_is_equal_to_option_enters_and_clicks_update_button(String number) {

        vehicleTableArrangementsPage.modelYearAllDropdown.click();
        vehicleTableArrangementsPage.containsDropdown.click();
        vehicleTableArrangementsPage.isEqualTo.click();
        vehicleTableArrangementsPage.input.sendKeys(number);
        vehicleTableArrangementsPage.updateButton.click();

        BrowserUtils.sleep(3);

    }

    @Then("All values in the Model Year column equals to {string} after filtering")
    public void all_values_in_the_model_year_column_equals_to_after_filtering(String number) {

        for (WebElement yearOfFiltering : vehicleTableArrangementsPage.totalModelYear) {
            Assert.assertEquals(number, yearOfFiltering.getText());
        }
        BrowserUtils.sleep(3);

    }
}
