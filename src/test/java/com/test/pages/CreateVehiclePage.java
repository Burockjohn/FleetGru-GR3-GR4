package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVehiclePage extends BasePage {

    public CreateVehiclePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarBtn;

    @FindBy(xpath = "//h1[.='Create Car']")
    public WebElement createCarTitle;
}



