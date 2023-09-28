package com.test.step_definitions;

import com.test.pages.CreateVehiclePage;
import com.test.pages.EditPage;
import com.test.pages.LoginPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertFalse;

public class CreateVehicleStepDef {

    LoginPage loginPage = new LoginPage();
    CreateVehiclePage vehiclePage = new CreateVehiclePage();

    EditPage editPage = new EditPage();

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
        editPage.waitUntilLoaderScreenDisappear();


        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();



    }

    @Then("The driver can not see Create Car button")
    public void the_driver_can_not_see_create_car_button() {
        editPage.waitUntilLoaderScreenDisappear();
        try {
            vehiclePage.createCarBtn.isDisplayed();
            assertFalse("Create Car button should not be displayed", true);
        } catch (NoSuchElementException e) {

        }
    }


    @When("The user log in with {string} and {string}")
    public void theUserLogInWithAnd(String username, String password) {


        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.signInBtn.click();
    }

    @And("The user hover over Fleet menu then clicks Vehicles page")
    public void theUserHoverOverFleetMenuThenClicksVehiclesPage() {
        editPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.hover(vehiclePage.fleetOpt);
        vehiclePage.vehiclesOpt.click();

    }

    @Then("The user should see the Create Car button")
    public void theUserShouldSeeTheCreateCarButton() {
        editPage.waitUntilLoaderScreenDisappear();


        Assert.assertTrue(vehiclePage.createCarBtn.isDisplayed());
    }

    @And("The user clicks Create Car button")
    public void theUserClicksCreateCarButton() {
        editPage.waitUntilLoaderScreenDisappear();

        vehiclePage.createCarBtn.click();
    }

    @Then("The user land on the {string} page")
    public void theUserLandOnThePage(String title) {
        editPage.waitUntilLoaderScreenDisappear();

        String actualTitle = vehiclePage.createCarTitle.getText();

        Assert.assertEquals(title,actualTitle);
    }

    @Then("The user should fill out the create car form in accordance with the rules.")
    public void theUserShouldFillOutTheCreateCarFormInAccordanceWithTheRules() {
        editPage.waitUntilLoaderScreenDisappear();

        //Lisence Plate
        editPage.licensePlate.sendKeys("06GDJ56");



        //Tags section
        for (WebElement tags : editPage.tags) {

            if(!tags.isSelected()){

                tags.click();
            }
        }

        //Driver
        String driver = "Çağla İslamoğlu";
        editPage.driver.sendKeys(driver);



        //Location
        String location = "Ankara";
        if (!driver.matches("\\d+")){
            editPage.location.sendKeys(location);
        }

        //Chassis Number
        editPage.chassisNumber.sendKeys("22452EZ");

        //Model Year
        String modelYear = "2020";
        if(modelYear.matches("\\d+")){
            editPage.modelYear.sendKeys(modelYear);
        }

        //Last Odometer
        String lastOdometer = "20000";
        if(modelYear.matches("\\d+")){
            editPage.modelYear.sendKeys(lastOdometer);
        }

        //Immatriculation Date
        editPage.immatriculationDate.click();

        Select monthDropdown = new Select(vehiclePage.selectMonth);
        Select yearDropdown = new Select(vehiclePage.selectYear);

        monthDropdown.selectByIndex(5);
        yearDropdown.selectByValue("2020");
        vehiclePage.selectDay.click();









    }
}



