package com.test.step_definitions;

import com.test.pages.*;
import com.test.utilities.BrowserUtils;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddEvent_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage =  new DashBoardPage();
    CreateVehiclePage vehiclePage = new CreateVehiclePage();
    AddEventPage addEventPage = new AddEventPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);



    @When("The {string} log in with username and password")
    public void theLogInWithUsernameAndPassword(String role) {
        loginPage.login(role);
        wait.until(ExpectedConditions.invisibilityOf(loginPage.loadingBar));

    }


    @And("The user hover over Fleet menu then clicks Vehicles page")
    public void theUserHoverOverFleetMenuThenClicksVehiclesPage() {
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(dashBoardPage.fleetBtn).perform();

       // actions.moveToElement(dashBoardPage.vehiclesBtn).click().build().perform();
        dashBoardPage.vehiclesBtn.click();
BrowserUtils.waitFor(5);

    }

    @And("The user clicks the the vehicle in the first row")
    public void theUserClicksTheTheVehicleInTheFirstRow() {
        vehiclePage.firstRow.click();
    }

    @Then("The user see the Add Event button on the right upper corner")
    public void theUserSeeTheAddEventButtonOnTheRightUpperCorner() {
       // wait.until(ExpectedConditions.visibilityOf(vehiclePage.addEvent));
        Assert.assertTrue(vehiclePage.addEvent.isDisplayed());
    }


    @And("The user clicks on Add event button")
    public void theUserClicksOnAddEventButton() {
        BrowserUtils.waitFor(3);
        vehiclePage.addEvent.click();
    }

    @Then("The user should see Add Event page")
    public void theUserShouldSeeAddEventPage() {
        String expected = "Add Event";
        Assert.assertTrue(vehiclePage.addEvent.getText().contains(expected));
    }
}
