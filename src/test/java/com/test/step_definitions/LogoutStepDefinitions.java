package com.test.step_definitions;

import com.test.pages.LogoutPage;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutStepDefinitions {
    LogoutPage logoutPage=new LogoutPage();



    @When("User click on the profile info button")
    public void user_click_on_the_profile_info_button() throws InterruptedException {
      WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
      wait.until(ExpectedConditions.elementToBeClickable(logoutPage.profileName));
      logoutPage.profileName.click();


    }
    @When("User click on the Logout button")
    public void user_click_on_the_logout_button() {
       logoutPage.logoutButton.click();
    }

    @Then("user should see the Login page title")
    public void user_should_see_the_login_page_title() {
       logoutPage.loginButton.isDisplayed();



}

    @And("user clicks the step back button")
    public void userClicksTheStepBackButton() {
     Driver.getDriver().navigate().back();
    }

    @Then("user can not access to the main page")
    public void userCanNotAccessToTheMainPage() {
        Assert.assertFalse(logoutPage.profileName.isDisplayed());
    }
}
