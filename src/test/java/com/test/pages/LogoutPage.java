package com.test.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;


public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//li[@id='user-menu']/a")
    public WebElement profileName;

    @FindBy(xpath="//a[@href='/user/logout']")

    public WebElement logoutButton;

    @FindBy(id= "_submit")
    public WebElement loginButton;


}
