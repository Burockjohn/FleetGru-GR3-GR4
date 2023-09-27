package com.test.step_definitions;

import com.test.pages.BasePage;
import com.test.pages.LoginPage;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddEvent_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);



    @When("The {string} log in with username and password")
    public void theLogInWithUsernameAndPassword(String role) {
        loginPage.login(role);
        wait.until(ExpectedConditions.invisibilityOf(loginPage.loadingBar));

    }


    @And("The user hover over Fleet menu then clicks Vehicles page")
    public void theUserHoverOverFleetMenuThenClicksVehiclesPage() {
    }

    @And("The user clicks the the vehicle in the first row")
    public void theUserClicksTheTheVehicleInTheFirstRow() {
    }

    @Then("The user see the Add Event button on the right upper corner")
    public void theUserSeeTheAddEventButtonOnTheRightUpperCorner() {
    }
}
