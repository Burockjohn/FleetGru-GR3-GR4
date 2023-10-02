package com.test.step_definitions;

import com.sun.source.tree.AssertTree;
import com.test.pages.VehiclesPage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DeleteCar_StepDef {
    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions= new Actions(Driver.getDriver());

    @When("The user hover over the the three dots at the end of each row")
    public void the_user_hover_over_the_the_three_dots_at_the_end_of_each_row() {

        int count=0;
        for (WebElement eachDot : vehiclesPage.threeDot) {
            count++;
            actions.moveToElement(eachDot).perform();
          BrowserUtils.sleep(1);
          if(count>2){
              actions.moveToElement(vehiclesPage.action.get(2)).perform();
              BrowserUtils.sleep(1);
              break;
          }
        }

    }
        @Then("The user should see the Delete button")
    public void the_user_should_see_the_delete_button() {

            Assert.assertEquals(vehiclesPage.action.get(2).getAttribute("title"),"Delete");

        }





}
