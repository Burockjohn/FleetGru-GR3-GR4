package com.test.step_definitions;

import com.test.pages.LoginPage;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {
    LoginPage loginPage=new LoginPage();
    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base.url"));
    }

    @When("user enters username {string}")
    public void userEntersUsername(String arg0) {
        loginPage.userName.sendKeys(arg0);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String arg0) {
      loginPage.password.sendKeys(arg0);
    }

    @Then("user clicks to login button")
    public void userClicksToLoginButton() {
        loginPage.signInBtn.click();
    }
}
