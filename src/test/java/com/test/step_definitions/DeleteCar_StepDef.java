package com.test.step_definitions;

import com.sun.source.tree.AssertTree;
import com.test.pages.DeleteCarPage;
import com.test.pages.VehiclesPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.BreakIterator;
import java.time.Duration;

public class DeleteCar_StepDef {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    String numberOfCarAfterDeleted;
    String numberOfCarBeforeDeleted;

    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions = new Actions(Driver.getDriver());
    DeleteCarPage deleteCarPage = new DeleteCarPage();

    @When("The user hover over the the three dots at the end of each row")
    public void the_user_hover_over_the_the_three_dots_at_the_end_of_each_row() {

        int count = 0;
        for (WebElement eachDot : vehiclesPage.threeDot) {
            count++;
            actions.moveToElement(eachDot).perform();
            BrowserUtils.waitFor(3);
            if (count > 1) {
                actions.moveToElement(vehiclesPage.action.get(2)).perform();
                break;
            }
        }

    }

    @Then("The user should see the Delete button")
    public void the_user_should_see_the_delete_button() {

        Assert.assertEquals(vehiclesPage.action.get(2).getAttribute("title"), "Delete");

    }

    @When("The user clicks on the delete button")
    public void the_user_clicks_on_the_delete_button() {
        for (WebElement element : vehiclesPage.action) {

            if (element.getAttribute("title").equals("Delete")) element.click();
        }
    }

    @Then("The user should see {string}")
    public void the_user_should_see(String expectText) throws InterruptedException {
        BrowserUtils.sleep(2);
        String actualText = vehiclesPage.popupMessage.getText();
        Assert.assertEquals(expectText, actualText);
    }

    @When("The user accepts confirmation")
    public void the_user_accepts_confirmation() {
       wait.until(ExpectedConditions.visibilityOf(vehiclesPage.deleteConfirmButton));
        vehiclesPage.deleteConfirmButton.click();

        numberOfCarAfterDeleted = vehiclesPage.totalOfCar.getText();
        System.out.println("numberOfCarAfterDeleted = " + numberOfCarAfterDeleted);

    }

    @Then("The user should see {string} message")
    public void the_user_should_see_message(String expectMessage) {

        String actualMessage = vehiclesPage.permissionMessage.getText();
        Assert.assertEquals(expectMessage, actualMessage);
    }

    @Then("The user should see {string} flash message")
    public void the_user_should_see_flash_message(String expectedFlashMessage) {
        String actualFlashMessage = vehiclesPage.flashMessageHolder.getText();

        Assert.assertEquals(expectedFlashMessage, actualFlashMessage);
    }

    @When("The user clicks on any car")
    public void the_user_clicks_on_any_car() throws InterruptedException {
        BrowserUtils.waitFor(3);
        vehiclesPage.nextPage.click();
        numberOfCarBeforeDeleted = vehiclesPage.totalOfCar.getText();

        BrowserUtils.waitFor(3);
        vehiclesPage.carToBeDeleted.click();

    }

    @When("The user clicks on the delete button on the page")
    public void the_user_clicks_on_the_delete_button_on_the_page() {

        BrowserUtils.waitFor(3);
        deleteCarPage.deleteButton.click();

    }

    @Then("The user should see that the car is missing")
    public void the_user_should_see_that_the_car_is_missing() {
        int beforeDeleted = 0;
        int afterDeleted = 0;


        String[] num2 = numberOfCarBeforeDeleted.split(" ");
        String[] num1 = numberOfCarAfterDeleted.split(" ");


        for (String word : num2) {
            try {
                beforeDeleted = Integer.parseInt(word);
            } catch (NumberFormatException e) {

            }
        }
        for (String word : num1) {
            try {
                afterDeleted = Integer.parseInt(word);
            } catch (NumberFormatException e) {

            }
        }


        Assert.assertEquals(1, beforeDeleted - afterDeleted);
    }


}
