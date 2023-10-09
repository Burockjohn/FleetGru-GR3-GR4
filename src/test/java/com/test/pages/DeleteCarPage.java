package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCarPage {

    public DeleteCarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy(xpath = "//a[@data-message='Are you sure you want to delete this Car?']")
        public WebElement deleteButton;




}
