package com.test.step_definitions;

import com.test.pages.DriverFilterPages;
import com.test.utilities.BrowserUtils;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class DriverFilter_StepDefinition {

    DriverFilterPages driverFilterPages = new DriverFilterPages();
    Actions actions = new Actions(Driver.getDriver());


    @When("User should hover over the Fleet tab on the top left and select the Vehicle option.")
    public void userShouldHoverOverTheFleetTabOnTheTopLeftAndSelectTheVehicleOption() {
        BrowserUtils.sleep(3);
        actions.moveToElement(driverFilterPages.fleetButton).perform();
        BrowserUtils.sleep(3);
        driverFilterPages.vehicleButton.click();
    }

    @When("User should click on the filters button on the top right.")
    public void user_should_click_on_the_filters_button_on_the_top_right() {
        driverFilterPages.filtersButton.click();
    }

    @When("User should click on the Manage Filters tab in the upper left.")
    public void user_should_click_on_the_manage_filters_tab_in_the_upper_left() {
        driverFilterPages.manageFiltersButton.click();
    }

    @When("User should select Driver from the Manage Filter section.")
    public void user_should_select_driver_from_the_manage_filter_section() {
        driverFilterPages.driverButton.click();
    }

    @When("User should click on the Driver All section next to the Manage Filter section in the upper left.")
    public void user_should_click_on_the_driver_all_section_next_to_the_manage_filter_section_in_the_upper_left() {
        driverFilterPages.driverAllButton.click();
    }


    @When("The user should select the Contains tab.")
    public void theUserShouldSelectTheContainsTab() {
        driverFilterPages.selectButton.click();
        driverFilterPages.contains.click();
    }


    @And("The user must enter the data {string} they want to find and click on the update button click.")
    public void theUserMustEnterTheDataTheyWantToFindAndClickOnTheUpdateButtonClick(String data) {
        driverFilterPages.inputText.sendKeys(data);
        driverFilterPages.updateButton.click();
    }


    @Then("The user can verify that the requested data {string} is contained.")
    public void theUserCanVerifyThatTheRequestedDataIsContained(String data) {
        for (int i = 1; i < driverFilterPages.verificationText.size() + 1; i++) {

            Assert.assertEquals(driverFilterPages.verificationText.get(i), data);
        }
    }

    @When("The user should select the Does Not Contain tab.")
    public void theUserShouldSelectTheDoesNotContainTab() {

        driverFilterPages.selectButton.click();
        driverFilterPages.doesNotContain.click();
    }

    @Then("The user can verify that the requested data {string} is not contained.")
    public void theUserCanVerifyThatTheRequestedDataIsNotContained(String data) {
        for (int i = 1; i < driverFilterPages.verificationText.size() + 1; i++) {

            Assert.assertNotEquals(driverFilterPages.verificationText.get(i), data);
        }
    }

    @When("The user should select the Starts-with tab.")
    public void theUserShouldSelectTheStartsWithTab() {
        driverFilterPages.selectButton.click();
        driverFilterPages.startWith.click();
    }

    @Then("The user can verify that the requested data {string} is Starts-with.")
    public void theUserCanVerifyThatTheRequestedDataIsStartsWith(String data) {

        for (int i = 1; i < driverFilterPages.verificationText.size() + 1; i++) {

            Assert.assertTrue(data.startsWith(driverFilterPages.verificationText.get(i) + ""));
        }
    }

    @When("The user should select the Ends With tab.")
    public void theUserShouldSelectTheEndsWithTab() {

        driverFilterPages.selectButton.click();
        driverFilterPages.endWith.click();
    }


    @Then("The user can verify that the requested data {string} is Ends With.")
    public void theUserCanVerifyThatTheRequestedDataIsEndsWith(String data) {

        for (int i = 1; i < driverFilterPages.verificationText.size() + 1; i++) {

            Assert.assertTrue(data.endsWith(driverFilterPages.verificationText.get(i) + ""));
        }
    }

    @When("The user should select the Is Equal to tab.")
    public void theUserShouldSelectTheIsEqualToTab() {

        driverFilterPages.selectButton.click();
        driverFilterPages.isToEqual.click();
    }


    @Then("The user can verify that the requested data {string} is Equal to.")
    public void theUserCanVerifyThatTheRequestedDataIsEqualTo(String data) {
        for (int i = 1; i < driverFilterPages.verificationText.size() + 1; i++) {

            Assert.assertEquals(driverFilterPages.verificationText.get(i), data);
        }
    }


    @When("Driver filter should provide the methods shown as below all member")
    public void driverFilterShouldProvideTheMethodsShownAsBelowAllMember() {
        driverFilterPages.selectButton.click();

        Assert.assertEquals(driverFilterPages.contains.getText(), "Contains");
        Assert.assertEquals(driverFilterPages.doesNotContain.getText(), "Does Not Contain");
        Assert.assertEquals(driverFilterPages.isToEqual.getText(), "Is Equal To");
        Assert.assertEquals(driverFilterPages.startWith.getText(), "Starts With");
        Assert.assertEquals(driverFilterPages.endWith.getText(), "Ends With");
        Assert.assertEquals(driverFilterPages.isAnyOf.getText(), "Is Any Of");
        Assert.assertEquals(driverFilterPages.isNotAnyOf.getText(), "Is Not Any Of");
        Assert.assertEquals(driverFilterPages.isEmpty.getText(), "Is Empty");
        Assert.assertEquals(driverFilterPages.isNotEmpty.getText(), "Is Not Empty");

    }

    @Then("The user can verify that the requested data {string} non-alphabetical characters verification.")
    public void theUserCanVerifyThatTheRequestedDataNonAlphabeticalCharactersVerification(String data) {
        BrowserUtils.sleep(3);
        System.out.println("driverFilterPages.verificationMessage.getText() = " + driverFilterPages.verificationMessage.getText());
        Assert.assertNotEquals(driverFilterPages.verificationMessage.getText(),"No entities were found to match your search. Try modifying your search criteria...");
    }

    @Then("The user can verify that the requested data {string} not include non-alphabetical characters verification.")
    public void theUserCanVerifyThatTheRequestedDataNotIncludeNonAlphabeticalCharactersVerification(String data) {

        Assert.assertEquals(driverFilterPages.verificationMessage.getText(),"Invalid value");
    }
}

