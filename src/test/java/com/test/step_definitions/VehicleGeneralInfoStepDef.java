package com.test.step_definitions;

import com.test.pages.*;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.CharMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class VehicleGeneralInfoStepDef extends GeneralInformationPage {
    LoginPage loginPage = new LoginPage();
    CreateVehiclePage vehiclePage = new CreateVehiclePage();
    VehiclesPage vehiclesPage=new VehiclesPage();
    GeneralInformationPage informationPage = new GeneralInformationPage();
    String genPageName;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base.url"));

    }

    @When("User can see the {string}  page by clicking on any vehicle \\(row), under Fleet-Vehicle module")
    public void user_can_see_the_page_by_clicking_on_any_vehicle_row_under_fleet_vehicle_module(String genPageName) {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("driver.username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("driver.password"));
        loginPage.signInBtn.click();
        BrowserUtils.sleep(10);
        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();
        BrowserUtils.sleep(20);
        informationPage.rowButton.click();
        BrowserUtils.sleep(5);
        Assert.assertEquals(informationPage.genInfoPageName.getText(), genPageName);


    }

    @When("User can see the {string} page clicking on the Eye \\(View) icon at the end of each row, under Fleet-Vehicle module")
    public void user_can_see_the_page_clicking_on_the_eye_view_icon_at_the_end_of_each_row_under_fleet_vehicle_module(String genPageName) throws InterruptedException {

        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().navigate().back();
        BrowserUtils.sleep(3);
        // BrowserUtils.hover(informationPage.endHover);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String script = "var element = arguments[0];" +
                "var mouseEvent = document.createEvent('MouseEvents');" +
                "mouseEvent.initEvent('mouseover', true, true);" +
                "element.dispatchEvent(mouseEvent);";
        jsExecutor.executeScript(script, informationPage.threeDot);
//        actions.moveToElement(informationPage.threeDot).click();
        BrowserUtils.sleep(2);
        informationPage.eye.click();

        BrowserUtils.sleep(2);
        Assert.assertEquals(informationPage.genInfoPageName.getText(), genPageName);
    }


    @When("Sales manager should see {string}, {string} and {string} buttons on the {string} page")
    public void sales_manager_and_store_manager_should_see_and_buttons_on_the_page(String edit, String delete, String addEvent, String genPageName) {

        loginPage.userName.sendKeys(ConfigurationReader.getProperty("SalesManager.UserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("SalesManager.Password"));
        loginPage.signInBtn.click();
        BrowserUtils.sleep(10);
        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();
        BrowserUtils.sleep(20);
        informationPage.rowButton.click();
        BrowserUtils.sleep(5);
        Assert.assertEquals(informationPage.genInfoPageName.getText(), genPageName);
        System.out.println("informationPage.editButton = " + informationPage.editButton.getText());
        //Assert.assertEquals(informationPage.editButton.getText(), edit);
        Assert.assertTrue(informationPage.editButton.isDisplayed());
        Assert.assertTrue(informationPage.deleteButton.isDisplayed());
        Assert.assertTrue(informationPage.AddButton.isDisplayed());

    }

    @When("store manager should see {string}, {string} and {string} buttons on the {string} page")
    public void store_manager_and_store_manager_should_see_and_buttons_on_the_page(String edit, String delete, String addEvent, String genPageName) {

        loginPage.userName.sendKeys(ConfigurationReader.getProperty("StoreManager.UserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("StoreManager.Password"));
        loginPage.signInBtn.click();
        BrowserUtils.sleep(10);
        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();
        BrowserUtils.sleep(20);
        informationPage.rowButton.click();
        BrowserUtils.sleep(5);
        Assert.assertEquals(informationPage.genInfoPageName.getText(), genPageName);
        //System.out.println("informationPage.editButton = " + informationPage.editButton.getText());
        // System.out.println("informationPage.deleteButton = " + informationPage.deleteButton.getText());
        // System.out.println("informationPage.AddButton = " + informationPage.AddButton.getText());
        Assert.assertTrue(informationPage.editButton.isDisplayed());
        Assert.assertTrue(informationPage.deleteButton.isDisplayed());
        Assert.assertTrue(informationPage.AddButton.isDisplayed());

        // Assert.assertEquals(informationPage.editButton,edit);
        // Assert.assertEquals(informationPage.deleteButton.getText(),delete);
        //Assert.assertEquals(informationPage.AddButton.getText(),addEvent);


    }

    @When("Driver shouldn't see {string}, {string} and {string} buttons")
    public void driver_shouldn_t_see_and_buttons(String edit, String delete, String addEvent) {

        loginPage.userName.sendKeys(ConfigurationReader.getProperty("driver.username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("driver.password"));
        loginPage.signInBtn.click();
        BrowserUtils.sleep(3);
        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();
        BrowserUtils.sleep(3);
        informationPage.rowButton.click();
        BrowserUtils.sleep(3);

        List<String> aTagOuterText = new ArrayList<>();
        for (WebElement each : Driver.getDriver().findElements(By.xpath("//a"))) {
            aTagOuterText.add(each.getAttribute("outerText"));
        }

        for (String each : aTagOuterText) {
            Assert.assertEquals(false,each.contains(edit));
            Assert.assertEquals(false,each.contains(delete));
            Assert.assertEquals(false,each.contains(addEvent));



    }
    }

    @Then("Vehicle information displayed on the {string} page and {string} page should be the same")
    public void vehicle_information_displayed_on_the_page_and_page_should_be_the_same(String string, String string2) {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("StoreManager.UserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("StoreManager.Password"));
        loginPage.signInBtn.click();
        BrowserUtils.sleep(20);
        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();
        String carsPageLicencePlateText = informationPage.carsPageLicencePlate.getText();
        String carsPageTagsText = informationPage.carsPageTags.getText();
        String carsPageDriverText = informationPage.carsPageDriver.getText();
        String carsPageLocationText = informationPage.carsPageLocation.getText();
        String carsPageChassisNumberText = informationPage.carsPageChassisNumber.getText();
        carsPageChassisNumberText = carsPageChassisNumberText.replace(",", "");
        String carsPageModelYearText = informationPage.carsPageModelYear.getText();
        String carsPageLastOdometerText = informationPage.carsPageLastOdometer.getText();
        carsPageLastOdometerText = carsPageLastOdometerText.replace(",", "");
        String carsPageImmatriculationText = informationPage.carsPageImmatriculation.getText();
        String carsFirstContractText = informationPage.carsFirstContract.getText();
        String carsPageCatalogValueText = informationPage.carsPageCatalogValue.getText();
        String carsPageSeatsNumberText = informationPage.carsPageSeatsNumber.getText();
        String carsPageDoorsNumberText = informationPage.carsPageDoorsNumber.getText();
        String carsPageColorText = informationPage.carsPageColor.getText();
        String carsPageTransmissionText = informationPage.carsPageTransmission.getText();
        String carsPageFuelTypeText = informationPage.carsPageFuelType.getText();
        String carsPageCO2Text = informationPage.carsPageCO2.getText();
        String carsPageHorsepowerText = informationPage.carsPageHorsepower.getText();
        String carsPageHorsepowerTaxText = informationPage.carsPageHorsepowerTax.getText();
        String carsPagePowerText = informationPage.carsPagePower.getText();


        BrowserUtils.sleep(5);
        informationPage.rowButton.click();
        BrowserUtils.sleep(5);
        String genPageLicencePlate = informationPage.genLicencePlate.getText();
        String genTagsText = informationPage.genTags.getText();
        String genDriverText = informationPage.genDriver.getText();
        String genLocationText = informationPage.genLocation.getText();

        String genChassisNumberText = informationPage.genChassisNumber.getText();

        String genModelYearText = informationPage.genModelYear.getText();
        String genLastOdometerText=informationPage.genLastOdometer.getText();
        String genImmatriculationText = informationPage.genImmatriculation.getText();
        String genFirstContractText = informationPage.genFirstContract.getText();
        String genCatalogValueText = informationPage.genCatalogValue.getText();
        String genSeatsNumberText = informationPage.genSeatsNumber.getText();
        String genDoorsNumberText = informationPage.genDoorsNumber.getText();
        String genColorText = informationPage.genColor.getText();
        String genTransmissionText = informationPage.genTransmission.getText();
        String genFuelTypeText = informationPage.genFuelType.getText();
        String genCO2Text = informationPage.genCO2.getText();
        String genHorsepowerText = informationPage.genHorsepower.getText();
        String genHorsepowerTaxText = informationPage.genHorsepowerTax.getText();
        String genPowerText = informationPage.genPower.getText();


        Assert.assertEquals(carsPageLicencePlateText, genPageLicencePlate);
        Assert.assertEquals(carsPageTagsText, genTagsText);
        Assert.assertEquals(carsPageDriverText, genDriverText);
        Assert.assertEquals(carsPageLocationText, genLocationText);
        Assert.assertEquals(carsPageChassisNumberText, genChassisNumberText);
        Assert.assertEquals(carsPageModelYearText, genModelYearText);
        Assert.assertEquals(carsPageLastOdometerText, genLastOdometerText);
        Assert.assertEquals(carsPageImmatriculationText, genImmatriculationText);
        Assert.assertEquals(carsFirstContractText, genFirstContractText);
        Assert.assertEquals(carsPageCatalogValueText, genCatalogValueText);
        Assert.assertEquals(carsPageSeatsNumberText, genSeatsNumberText);
        Assert.assertEquals(carsPageDoorsNumberText, genDoorsNumberText);
        Assert.assertEquals(carsPageColorText, genColorText);
        Assert.assertEquals(carsPageTransmissionText, genTransmissionText);
        Assert.assertEquals(carsPageFuelTypeText, genFuelTypeText);
        Assert.assertEquals(carsPageCO2Text, genCO2Text);
        Assert.assertEquals(carsPageHorsepowerText, genHorsepowerText);
        Assert.assertEquals(carsPageHorsepowerTaxText, genHorsepowerTaxText);
        Assert.assertEquals(carsPagePowerText, genPowerText);


    }

}
