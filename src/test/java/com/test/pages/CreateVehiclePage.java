package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.ThreadLocalRandom;

public class CreateVehiclePage extends BasePage {

    public CreateVehiclePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarBtn;

    @FindBy(xpath = "//h1[.='Create Car']")
    public WebElement createCarTitle;

    @FindBy(xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement addEvent;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement selectMonth;

    @FindBy(xpath ="//select[@class='ui-datepicker-year']" )
    public WebElement selectYear;

    @FindBy(xpath ="//tbody//a[.='19']" )
    public WebElement selectDay;
  

}
