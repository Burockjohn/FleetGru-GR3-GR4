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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
                loginPage.userName.sendKeys(ConfigurationReader.getProperty("SalesManager.UserName"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("SalesManager.Password"));
                break;
            case " store manager":
                loginPage.userName.sendKeys(ConfigurationReader.getProperty("StoreManager.UserName"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("StoreManager.Password"));
                break;
            case "driver":
                loginPage.userName.sendKeys(ConfigurationReader.getProperty("driver.username"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("driver.password"));
                break;
            default:
                System.err.println("Invalid user type");

        }
        loginPage.signInBtn.click();
    }

    @When("User navigates to Dashboard Fleet-Vehicle page")
    public void user_navigates_to_dashboard_fleet_vehicle_page() {
        editPage.waitUntilLoaderScreenDisappear();
        actions.moveToElement(editPage.fleetOpt).perform();
        editPage.vehiclesOpt.click();

    }

    @When("User clicks on a row in the table")
    public void user_clicks_on_a_row_in_the_table() {
        editPage.waitUntilLoaderScreenDisappear();
        actions.moveToElement(vehiclesPage.firstRow).click().perform();

    }

    @When("User click on Edit button located in the upper right corner of the page")
    public void user_click_on_edit_button_located_in_the_upper_right_corner_of_the_page() {
        editPage.waitUntilLoaderScreenDisappear();
        editPage.editButton.click();
    }

    @Then("User navigates to the Edit page")
    public void user_navigates_to_the_edit_page() {
        editPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("update"));
    }

    @When("User clicks the editing button under 3dot sign at the end of the row")
    public void user_clicks_the_editing_button_under_3dot_sign_at_the_end_of_the_row() {
        editPage.waitUntilLoaderScreenDisappear();
        String script = "var element = arguments[0];" +
                "var mouseEvent = document.createEvent('MouseEvents');" +
                "mouseEvent.initEvent('mouseover', true, true);" +
                "element.dispatchEvent(mouseEvent);";
        jsExecutor.executeScript(script, vehiclesPage.firstDropdown);
        //actions.moveToElement(vehiclesPage.firstDropdown).perform();
        vehiclesPage.edit3dot.click();
        BrowserUtils.sleep(1);
    }

    @When("User navigates to QuickLaunchpad Fleet-Vehicle page")
    public void user_navigates_to_quick_launchpad_fleet_vehicle_page() {
        editPage.waitUntilLoaderScreenDisappear();
        actions.moveToElement(editPage.fleetOpt).perform();
        editPage.vehiclesOpt.click();
    }

    @Then("User sees {string} message")
    public void user_sees_message(String expectedMessage) {
        editPage.waitUntilLoaderScreenDisappear();
        String actualMessage = vehiclesPage.flashMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Then("User sees the subtitle as license plate and driver name")
    public void user_sees_the_subtitle_as_license_plate_and_driver_name() {
        editPage.waitUntilLoaderScreenDisappear();
        String actualSubtitle = editPage.subtitle.getText();
        String expectedSubtitle = editPage.licensePlate.getAttribute("value") + " " + editPage.driver.getAttribute("value");
        Assert.assertEquals(expectedSubtitle, actualSubtitle);
    }

    @When("User fills out the form with the valid data")
    public void user_fills_out_the_form_with_the_valid_data() {
        editPage.licensePlate.clear();
        String newPlate = "06DRM211";
        editPage.licensePlate.sendKeys(newPlate);

        for (WebElement tag : editPage.tags) {
            tag.click();
        }

        editPage.driver.clear();
        String newDriver = "Burak Can";
        editPage.driver.sendKeys(newDriver);

        editPage.location.clear();
        String newLocation = "ANGARA";
        editPage.location.sendKeys(newLocation);

        editPage.chassisNumber.clear();
        String newChassis = "123456";
        editPage.chassisNumber.sendKeys(newChassis);

        editPage.modelYear.clear();
        String newModelYear = "2019";
        editPage.modelYear.sendKeys(newModelYear);

        editPage.lastOdometer.clear();
        String newOdometer = "123456";
        editPage.lastOdometer.sendKeys(newOdometer);

        editPage.catalogValue.clear();
        String newValue = "12345678";
        editPage.catalogValue.sendKeys(newValue);

        editPage.seatsNumber.clear();
        String newSeatNumber = "5";
        editPage.seatsNumber.sendKeys(newSeatNumber);

        editPage.doorsNumber.clear();
        String newDoorsNumber = "5";
        editPage.doorsNumber.sendKeys(newDoorsNumber);

        editPage.color.clear();
        String newColor = "Parliament Blue";
        editPage.color.sendKeys(newColor);

        if (Driver.getDriver().findElement(By.xpath("(//span[@class='select2-chosen'])[1]")).getText().equals("Choose a value...")) {
            Select select1 = new Select(editPage.trnType);
            String transmissionType = "Automatic";
            select1.selectByVisibleText(transmissionType);
        }

        if (Driver.getDriver().findElement(By.xpath("(//span[@class='select2-chosen'])[2]")).getText().equals("Choose a value...")) {
            Select select2 = new Select(editPage.fuelType);
            String fuelType = "Hybrid";
            select2.selectByVisibleText(fuelType);
        }

        editPage.co2Emissions.clear();
        String newCo2 = "0.24";
        editPage.co2Emissions.sendKeys(newCo2);

        editPage.horsePower.clear();
        String newHP = "200";
        editPage.horsePower.sendKeys(newHP);

        editPage.horsePowerTaxation.clear();
        String newHPTax = "0.1";
        editPage.horsePowerTaxation.sendKeys(newHPTax);

        editPage.powerKW.clear();
        String newPowerKW = "64";
        editPage.powerKW.sendKeys(newPowerKW);

        if (!Driver.getDriver().findElement(By.partialLinkText("car.jpg")).isEnabled()) {
            editPage.logo.sendKeys("C:\\Users\\brkcn\\OneDrive\\Masaüstü\\car.jpg");
        }

    }

    @Then("User should see the {string} message after saving data")
    public void user_should_see_the_message_after_saving_data(String expectedMessage) {
        editPage.saveDropdown.click();
        editPage.saveBtn.click();
        editPage.waitUntilLoaderScreenDisappear();
        String actualMessage = editPage.message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("User  fills out the form with the invalid data")
    public void user_fills_out_the_form_with_the_invalid_data() {
        editPage.licensePlate.sendKeys("*");

        editPage.driver.sendKeys(" 8");

        editPage.location.sendKeys("32");

        editPage.chassisNumber.sendKeys("BC");

        editPage.modelYear.sendKeys("XX");

        editPage.seatsNumber.sendKeys("1453");

        editPage.doorsNumber.sendKeys("666");

        editPage.color.sendKeys("75");

    }

    @Then("User should not save after invalid entry")
    public void user_should_not_save_after_invalid_entry() {

        editPage.saveDropdown.click();
        editPage.saveBtn.click();
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

//        System.out.println("b1 = " + b1);
//        System.out.println("b2 = " + b2);
//        System.out.println("b3 = " + b3);
//        System.out.println("b4 = " + b4);
//        System.out.println("b5 = " + b5);
//        System.out.println("b6 = " + b6);
//        System.out.println("b7 = " + b7);
//        System.out.println("b8 = " + b8);

        Select select1 = new Select(editPage.trnType);
        String transmissionType = "Manual";
        select1.selectByVisibleText(transmissionType);

        Select select2 = new Select(editPage.fuelType);
        String fuelType = "Diesel";
        select2.selectByVisibleText(fuelType);

        Driver.getDriver().findElement(By.xpath("//i[@data-role='remove']")).click();
        BrowserUtils.sleep(1);

        Assert.assertTrue(b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8);

    }

    @Then("User should remain on the same page if ''Save'' is selected")
    public void user_should_remain_on_the_same_page_if_save_is_selected() {
        editPage.saveDropdown.click();
        editPage.saveBtn.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("update"));

    }

    @Then("User should remain on the same page but the data should be removed if ''Save and New'' is selected")
    public void user_should_remain_on_the_same_page_but_the_data_should_be_removed_if_save_and_new_is_selected() {
        editPage.saveDropdown.click();
        editPage.saveAndNewBtn.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Create Car"));
    }

    @Then("User should be navigated to the General Information page if ''Save and Close'' is selected")
    public void user_should_be_navigated_to_the_general_ınformation_page_if_save_and_close_is_selected() {
        editPage.saveDropdown.click();
        editPage.saveAndCloseBtn.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Entities"));
    }


}
