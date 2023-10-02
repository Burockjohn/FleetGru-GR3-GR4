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
import org.openqa.selenium.By;
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
        editPage.chassisNumber.sendKeys("22452");

        //Model Year
        String modelYear = "2020";
        if(modelYear.matches("\\d+")){
            editPage.modelYear.sendKeys(modelYear);
        }

        //Last Odometer
        String lastOdometer = "2000";
        if(lastOdometer.matches("\\d+")){
            editPage.lastOdometer.sendKeys(lastOdometer);
        }

        //Immatriculation Date
        editPage.immatriculationDate.click();

        Select monthDropdown = new Select(vehiclePage.selectMonth);
        Select yearDropdown = new Select(vehiclePage.selectYear);

        monthDropdown.selectByIndex(5);
        yearDropdown.selectByValue("2020");
        vehiclePage.selectDay.click();

        //First Contract Date
        editPage.firstContractDate.click();

        monthDropdown.selectByIndex(5);
        yearDropdown.selectByValue("2019");
        vehiclePage.selectDay.click();

        //Catalog value
        String catalogValue = "1258";
        if(catalogValue.matches("\\d+")) {
            editPage.catalogValue.sendKeys(catalogValue);
        }

        //Seats Number
        String seatsNumber = "5";
        if(seatsNumber.matches("\\d+")){
            editPage.seatsNumber.sendKeys(seatsNumber);
        }

        //Doors Number
        String doorNumber = "5";
        if(doorNumber.matches("\\d+")){
            editPage.doorsNumber.sendKeys(doorNumber);
        }

        //Color
        editPage.color.sendKeys("Black");

        //Transmission
        if (Driver.getDriver().findElement(By.xpath("(//span[@class='select2-chosen'])[1]")).getText().equals("Choose a value...")) {
            Select select = new Select(editPage.trnType);
            String transmissionType = "Automatic";
            select.selectByVisibleText(transmissionType);
        }

        //Fuel Type
        if (Driver.getDriver().findElement(By.xpath("(//span[@class='select2-chosen'])[2]")).getText().equals("Choose a value...")) {
            Select select = new Select(editPage.fuelType);
            String fuelType = "Hybrid";
            select.selectByVisibleText(fuelType);
        }

        //CO2 Emission
        String co2Emission = "1";
        if(co2Emission.matches("\\d+")){
            editPage.co2Emissions.sendKeys(co2Emission);
        }

        //Horsepower
        String horsePower = "200";
        if(horsePower.matches("\\d+")){
            editPage.horsePower.sendKeys(horsePower);
        }

        //Horsepower Taxation
        String horsePowerTax = "1";
        if(horsePowerTax.matches("\\d+")){
            editPage.horsePowerTaxation.sendKeys(horsePowerTax);
        }

        //Power(kw)
        String power = "64";
        if(power.matches("\\d+")){
            editPage.powerKW.sendKeys(power);
        }

        //Logo
        String logoLocation = "C:\\Users\\User\\Desktop\\logo.png";
        editPage.logo.sendKeys(logoLocation);


    }

    @And("User should see {string} message after saving data")
    public void userShouldSeeMessageAfterSavingData(String expectedMessage) {

        editPage.waitUntilLoaderScreenDisappear();
        String actualMessage = editPage.message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("The user enters invalid data in the create car form")
    public void theUserEntersInvalidDataInTheCreateCarForm() {
        editPage.waitUntilLoaderScreenDisappear();

        editPage.licensePlate.sendKeys("*");

        editPage.driver.sendKeys(" 8");

        editPage.location.sendKeys("32");

        editPage.chassisNumber.sendKeys("BC");

        editPage.modelYear.sendKeys("XX");

        editPage.seatsNumber.sendKeys("1453");

        editPage.doorsNumber.sendKeys("666");

        editPage.color.sendKeys("75");

    }

    @And("The user can not save this form after invalid entry")
    public void theUserCanNotSaveThisFormAfterInvalidEntry() {
        editPage.waitUntilLoaderScreenDisappear();


        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        boolean b5 = false;
        boolean b6 = false;
        boolean b7 = false;
        boolean b8 = false;

        for (char each : editPage.licensePlate.getAttribute("value").toCharArray()) {
            if (Character.isLetterOrDigit(each)) {
                b1 = true;
            } else {
                b1 = false;
                break;
            }
        }

        for (char each : editPage.driver.getAttribute("value").toCharArray()) {
            if (Character.isLetter(each)) {
                b2 = true;
            } else {
                b2 = false;
                break;
            }
        }

        for (char each : editPage.location.getAttribute("value").toCharArray()) {
            if (Character.isLetter(each)) {
                b3 = true;
            } else {
                b3 = false;
                break;
            }
        }

        for (char each : editPage.chassisNumber.getAttribute("value").toCharArray()) {
            if (Character.isLetter(each)) {
                b4 = true;
                break;
            }
        }

        for (char each : editPage.modelYear.getAttribute("value").toCharArray()) {
            if (Character.isDigit(each)) {
                b5 = true;
            } else {
                b5 = false;
                break;
            }
        }

        b6 = Integer.parseInt(editPage.seatsNumber.getAttribute("value")) <= 10;
        b7 = Integer.parseInt(editPage.doorsNumber.getAttribute("value")) <= 10;

        for (char each : editPage.color.getAttribute("value").toCharArray()) {
            if (Character.isLetter(each)) {
                b8 = true;
            } else {
                b8 = false;
                break;
            }
        }

        editPage.saveAndCloseBtn.click();
        BrowserUtils.sleep(1);

        Assert.assertFalse("The user can not see save massage",editPage.message.isDisplayed());


    }
}



