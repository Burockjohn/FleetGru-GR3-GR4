package com.test.step_definitions;

import com.test.pages.BasePage;
import com.test.pages.CreateVehiclePage;
import com.test.pages.GeneralInformationPage;
import com.test.pages.LoginPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VehicleGeneralInfoStepDef extends BasePage {
    LoginPage loginPage=new LoginPage();
    CreateVehiclePage vehiclePage=new CreateVehiclePage();
    GeneralInformationPage informationPage=new GeneralInformationPage();
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base.url"));
        loginPage.username.sendKeys(ConfigurationReader.getProperty("driver.username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("user.password"));
        loginPage.loginBtn.click();
    }
    @When("User can see the {string}  page by clicking on any vehicle \\(row), under Fleet-Vehicle module")
    public void user_can_see_the_page_by_clicking_on_any_vehicle_row_under_fleet_vehicle_module(String genPageName) {
        BrowserUtils.sleep(10);
        vehiclePage.fleetOpt.click();
        vehiclePage.vehiclesOpt.click();
        BrowserUtils.sleep(10);
        informationPage.rowButton.click();
        BrowserUtils.sleep(10);
       Assert.assertEquals(informationPage.genInfoPageName.getText(),genPageName);

    }
    @When("User can see the {string} page clicking on the Eye \\(View) icon at the end of each row, under Fleet-Vehicle module")
    public void user_can_see_the_page_clicking_on_the_eye_view_icon_at_the_end_of_each_row_under_fleet_vehicle_module(String string) {

    }
    @When("Sales manager and store manager should see {string}, {string} and {string} buttons on the {string} page")
    public void sales_manager_and_store_manager_should_see_and_buttons_on_the_page(String string, String string2, String string3, String string4) {

    }
    @When("Driver shouldn't see {string}, {string} and {string} buttons")
    public void driver_shouldn_t_see_and_buttons(String string, String string2, String string3) {

    }
    @Then("Vehicle information displayed on the {string} page and {string} page should be the same")
    public void vehicle_information_displayed_on_the_page_and_page_should_be_the_same(String string, String string2) {

    }

}
