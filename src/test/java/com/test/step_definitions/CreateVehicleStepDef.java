package com.test.step_definitions;

import com.test.pages.CreateVehiclePage;
import com.test.pages.LoginPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertFalse;

public class CreateVehicleStepDef {

    LoginPage loginPage = new LoginPage();
    CreateVehiclePage vehiclePage = new CreateVehiclePage();

    @Given("The user on the login page")
    public void theUserOnTheLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("base.url"));
    }

    @When("The driver log in with username and password")
    public void theDriverLogInWithUsernameAndPassword() {

        loginPage.userName.sendKeys(ConfigurationReader.getProperty("driver.username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("driver.password"));
        loginPage.signInBtn.click();
    }

    @And("The driver hover over Fleet menu then clicks Vehicles page")
    public void the_driver_hover_over_fleet_menu_then_clicks_vehicles_page() {

        BrowserUtils.sleep(3);
        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();
        BrowserUtils.sleep(3);


    }

    @Then("The driver can not see Create Car button")
    public void the_driver_can_not_see_create_car_button() {
        try {
            vehiclePage.createCarBtn.isDisplayed();
            assertFalse("Create Car button should not be displayed", true);
        } catch (NoSuchElementException e) {

        }
    }


    @When("The user log in with {string} and {string}")
    public void theUserLogInWithAnd(String username, String password) {

        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginBtn.click();
    }

    @And("The user hover over Fleet menu then clicks Vehicles page")
    public void theUserHoverOverFleetMenuThenClicksVehiclesPage() {

        BrowserUtils.sleep(3);
        BrowserUtils.hover(vehiclePage.fleetOpt2);
        vehiclePage.vehiclesOpt.click();
        BrowserUtils.sleep(3);
    }

    @Then("The user should see the Create Car button")
    public void theUserShouldSeeTheCreateCarButton() {

        Assert.assertTrue(vehiclePage.createCarBtn.isDisplayed());
    }
}



