package com.test.step_definitions;

import com.test.pages.BasePage;
import com.test.pages.VehiclesPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterMenuStepDefinitions {

    VehiclesPage vehiclesPage=new VehiclesPage();


    @Given("The user goes to the login page")
    public void the_user_goes_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base.url"));
    }


    @Given("The user clicks on the filter icon")
    public void the_user_clicks_on_the_filter_icon() {

     vehiclesPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitFor(1);
        vehiclesPage.filterIcon.click();

    }
    @Then("manage filter link should be visible")
    public void manage_filter_link_should_be_visible() {
        Assert.assertTrue(vehiclesPage.linkManageFilter.isDisplayed());
    }


    @When("The user clicks on the manage filters link")
    public void the_user_clicks_on_the_manage_filters_link() {

       vehiclesPage.linkManageFilter.click();

    }


    @When("The user clicks on the filter name {string}")
    public void the_user_clicks_on_the_filter_name(String string) {

        for (WebElement eachFilter : vehiclesPage.filterNames) {

            if(eachFilter.getText().contains(string)) {
                eachFilter.click();
                return;
            }

        }
    }
    @Then("The filter {string} should be listed in chosen filters area")
    public void the_filter_should_be_listed_in_chosen_filters_area(String string) {

        boolean chosen=false;
        for (WebElement eachChosen : vehiclesPage.chosenFilters) {

            if(eachChosen.getText().contains(string)) chosen=true;
        }

        Assert.assertTrue(chosen);
    }




    @When("The user enters {string} into filter input box")
    public void the_user_enters_into_filter_input_box(String string) {
         vehiclesPage.inputSearchForFiltering.sendKeys(string);
    }
    @Then("The filter {string} should be shown in the dropdown")
    public void the_filter_should_be_shown_in_the_dropdown(String string) {
        BrowserUtils.waitFor(1);
       Assert.assertTrue( vehiclesPage.filterName.getText().contains(string));


    }






    @When("The user enters multiple filters into filter input box")
    public void the_user_enters_multiple_filters_into_filter_input_box(List<String> filters) {
        for (String eachFilter : filters) {
            vehiclesPage.inputSearchForFiltering.clear();
            vehiclesPage.inputSearchForFiltering.sendKeys(eachFilter);
            BrowserUtils.waitFor(1);
            vehiclesPage.filterName.click();
            BrowserUtils.waitFor(1);


        }
    }
    @Then("The filters blow should be listed in chosen filters area")
    public void the_filters_blow_should_be_listed_in_chosen_filters_area(List<String> filters) {


        for (WebElement eachChosenFilter : vehiclesPage.chosenFilters) {

            String eachElement=eachChosenFilter.getText().split(":")[0];
            Assert.assertTrue(filters.contains(eachElement.trim()));
        }
    }







    @When("The user clicks on the reset icon")
    public void the_user_clicks_on_the_reset_icon() {
        vehiclesPage.resetIcon.click();
        BrowserUtils.waitFor(1);
    }
    @Then("Filter functionality should be reset")
    public void filter_functionality_should_be_reset() {
        Assert.assertEquals(0, vehiclesPage.chosenFilters.size());
    }




}
