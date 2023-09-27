package com.test.pages;

import com.test.utilities.BrowserUtils;
import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

/*    @FindBy(name = "_username")
    public WebElement username;

    @FindBy(name = "_password")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement loginBtn;*/

    @FindBy(id = "prependedInput")
    public WebElement userName;
    @FindBy(id = "prependedInput2")
    public WebElement password;
    @FindBy(id = "_submit")
    public WebElement signInBtn;

    @FindBy(xpath = "//h3[.='Loading...']")
    public WebElement loadingBar;


    public void login(String role) {
        String username = "";
        String passwrd = "";
        switch (role.toLowerCase()) {
            case "driver":
                username = ConfigurationReader.getProperty("driver.username");
                passwrd = ConfigurationReader.getProperty("driver.password");
                break;
            case "sales manager":
                username = ConfigurationReader.getProperty("SalesManager.UserName");
                passwrd = ConfigurationReader.getProperty("SalesManager.Password");
                break;

            case "store manager":
                username = ConfigurationReader.getProperty("StoreManager.UserName");
                passwrd = ConfigurationReader.getProperty("StoreManager.Password");
                break;
            default:
                System.out.println("There is no role such as " + role);

        }
        userName.sendKeys(username);
        password.sendKeys(passwrd);
        signInBtn.click();
    }


}
