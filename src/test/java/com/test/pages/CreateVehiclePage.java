package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVehiclePage {

    public CreateVehiclePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='unclickable']")
    public WebElement fleetOpt;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehiclesOpt;

    //Serhat edit
    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarBtn;

    //Serhat edit
    @FindBy(xpath = "(//tbody//tr)[1]")
    public WebElement firstRow;

    //Serhat edit
    @FindBy(xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement addEvent;
}
