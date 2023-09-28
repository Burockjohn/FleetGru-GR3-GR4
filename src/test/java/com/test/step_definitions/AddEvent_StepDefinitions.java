package com.test.step_definitions;

import com.test.pages.*;
import com.test.utilities.BrowserUtils;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddEvent_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage =  new DashBoardPage();
    VehiclesPage vehiclePage = new VehiclesPage();
    AddEventPage addEventPage = new AddEventPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);



    @When("The {string} log in with username and password")
    public void theLogInWithUsernameAndPassword(String role) {
        loginPage.login(role);
        wait.until(ExpectedConditions.invisibilityOf(loginPage.loadingBar));

    }

    @And("The user clicks the the vehicle in the first row")
    public void theUserClicksTheTheVehicleInTheFirstRow() {
        vehiclePage.firstRow.click();
    }

    @Then("The user see the Add Event button on the right upper corner")
    public void theUserSeeTheAddEventButtonOnTheRightUpperCorner() {
        Assert.assertTrue(vehiclePage.addEvent.isDisplayed());
    }

    @And("The user clicks on Add event button")
    public void theUserClicksOnAddEventButton() {
        BrowserUtils.waitFor(3);
        vehiclePage.addEvent.click();
    }

    @Then("The user should see Add Event page")
    public void theUserShouldSeeAddEventPage() {
        //System.out.println("addEventPage.titleText.getText() = " + addEventPage.title.getAttribute("textContent"));
        Assert.assertEquals("Add Event", addEventPage.title.getAttribute("textContent"));
        addEventPage.cancelButton.click();
    }

    @Then("The user should see all the required fields")
    public void theUserShouldSeeAllTheRequiredFields() {

        Assert.assertTrue(addEventPage.titleLabel.getAttribute("textContent").contains("Title"));
        Assert.assertTrue(addEventPage.ownerLabel.getAttribute("textContent").contains("Owner"));
        Assert.assertTrue(addEventPage.orgDispNameLabel.getAttribute("textContent").contains("Organizer display name"));
        Assert.assertTrue(addEventPage.orgDispEmailLabel.getAttribute("textContent").contains("Organizer email"));
        Assert.assertTrue(addEventPage.startDateLabel.getAttribute("textContent").contains("Start"));
        Assert.assertTrue(addEventPage.endDateLabel.getAttribute("textContent").contains("End"));
        addEventPage.cancelButton.click();
    }

    @And("The user enters required information except {string}")
    public void theUserEntersRequiredInformationExcept(String field) {
        switch (field){
            case "Title" :
                addEventPage.orgDispNameTextBox.sendKeys("Serhat");
                addEventPage.orgDispEmailTextBox.sendKeys("scamur@gmail.com");
                break;
            case "Owner Display Name" :
                addEventPage.title.sendKeys("Mr");
                addEventPage.orgDispEmailTextBox.sendKeys("scamur@gmail.com");
                break;
            case "Owner Email" :
                addEventPage.title.sendKeys("Mr");
                addEventPage.orgDispNameTextBox.sendKeys("Serhat");
                break;
        }
        addEventPage.saveButton.click();
    }


    @Then("The user should get the message")
    public void theUserShouldGetTheMessage() {
        Assert.assertEquals("This value should not be blank.",addEventPage.errorMessage.getAttribute("innerText"));
        addEventPage.cancelButton.click();
    }
}
