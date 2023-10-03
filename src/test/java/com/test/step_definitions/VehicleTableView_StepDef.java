package com.test.step_definitions;

import com.test.pages.EditPage;
import com.test.pages.LoginPage;
import com.test.pages.VehicleTableArrangementsPage;
import com.test.pages.VehiclesPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class VehicleTableView_StepDef {

    EditPage editPage = new EditPage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions = new Actions(Driver.getDriver());
    VehicleTableArrangementsPage tableArrangementsPage = new VehicleTableArrangementsPage();
    LoginPage loginPage = new LoginPage();

    @Then("User should see all vehicle information")
    public void user_should_see_all_vehicle_information(){

    String License=editPage.licensePlate.getText();
        System.out.println(License);
    }

    @Then("User should see total page number")
    public void user_should_see_total_page_number(){
        BrowserUtils.waitFor(3);
        Assert.assertTrue(tableArrangementsPage.totalPageNumber.isDisplayed());
    }

    @When("User logs in as each {string}")
    public void userLogsInAsEach(String role) {
        BrowserUtils.waitFor(3);
        loginPage.login(role);

    }

    @And("User clicks {string} for next previous page")
    public void userClicksForNextPreviousPage(String button) {
        BrowserUtils.waitFor(3);
        editPage.waitUntilLoaderScreenDisappear();
        switch (button){
            case "next" :
                vehiclesPage.nextBtn.click();
                break;
            case "previous" :
                vehiclesPage.prevBtn.click();
                break;
        }

    }
    @Then("User can see next page")
    public void userCanSeeNextPage() {
        System.out.println("passed");
    }
}
