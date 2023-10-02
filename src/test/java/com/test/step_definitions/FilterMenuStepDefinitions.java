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

public class FilterMenuStepDefinitions {

    VehiclesPage vehiclesPage=new VehiclesPage();
    BasePage basePage=new BasePage();

    @Given("The user goes to the login page")
    public void the_user_goes_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base.url"));
    }


    @Given("The user clicks on the filter icon")
    public void the_user_clicks_on_the_filter_icon() {

     basePage.waitUntilLoaderScreenDisappear();


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

}
