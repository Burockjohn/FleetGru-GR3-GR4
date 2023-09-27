package com.test.step_definitions;

import com.test.pages.EditPage;
import com.test.pages.LoginPage;
import com.test.pages.VehiclesPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class EditVehicle_StepDefinitions {

    EditPage editPage = new EditPage();
    LoginPage loginPage = new LoginPage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();


    @When("User logs in as {string}")
    public void user_logs_in_as(String userType) {

        switch (userType) {
            case "sales manager":
                loginPage.username.sendKeys(ConfigurationReader.getProperty("salesManager.username"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("user.password"));
                break;
            case " store manager":
                loginPage.username.sendKeys(ConfigurationReader.getProperty("storeManager.username"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("user.password"));
                break;
            case "driver":
                loginPage.username.sendKeys(ConfigurationReader.getProperty("driver.username"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("user.password"));
                break;
            default:
                System.err.println("Invalid user type");

        }
        loginPage.loginBtn.click();
    }

    @When("User navigates to Dashboard Fleet-Vehicle page")
    public void user_navigates_to_dashboard_fleet_vehicle_page() {
        editPage.waitUntilLoaderScreenDisappear();
        actions.moveToElement(editPage.fleetOpt).perform();
        editPage.vehiclesOpt.click();

    }

    @When("User clicks on a row in the table")
    public void user_clicks_on_a_row_in_the_table() {
        //BrowserUtils.sleep(5);
        editPage.waitUntilLoaderScreenDisappear();
        actions.moveToElement(vehiclesPage.firstRow).click().perform();

    }

    @When("User click on Edit button located in the upper right corner of the page")
    public void user_click_on_edit_button_located_in_the_upper_right_corner_of_the_page() {
        BrowserUtils.waitForClickablility(editPage.editButton, 10);
        editPage.editButton.click();
    }

    @Then("User navigates to the Edit page")
    public void user_navigates_to_the_edit_page() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("update"));
    }

    @When("User clicks the editing button under 3dot sign at the end of the row")
    public void user_clicks_the_editing_button_under_3dot_sign_at_the_end_of_the_row() {
        editPage.waitUntilLoaderScreenDisappear();
//        actions.scrollByAmount(1000,0).perform();
        BrowserUtils.sleep(2);
        actions.moveToElement(vehiclesPage.firstDropdown).perform();
        vehiclesPage.edit3dot.click();
    }

}
