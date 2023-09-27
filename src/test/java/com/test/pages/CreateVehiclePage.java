package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.By;
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


    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarBtn;

    //Serhat edit
    @FindBy(xpath = "(//tr[@class='grid-row row-click-action']/td)[2]")
    public WebElement firstRow;

    //Serhat edit
    @FindBy(xpath = "(//a[@href='javascript: void(0);'])[2]")
    public WebElement addEvent;


}
