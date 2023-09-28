package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditPage extends BasePage{

    public EditPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(className = "user-name")
    public WebElement subtitle;

    @FindBy(xpath = "//div[@class='oro-clearfix']/input")
    public List<WebElement> tags;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[1]")
    public WebElement licensePlate;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[2]")
    public WebElement driver;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[3]")
    public WebElement location;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[4]")
    public WebElement chassisNumber;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[5]")
    public WebElement modelYear;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[6]")
    public WebElement lastOdometer;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[7]")
    public WebElement immatriculationDate;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[8]")
    public WebElement firstContractDate;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[9]")
    public WebElement catalogValue;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[10]")
    public WebElement seatsNumber;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[11]")
    public WebElement doorsNumber;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[12]")
    public WebElement color;

    @FindBy(xpath = "//*[.='Automatic']/..")
    public WebElement trnType;

    @FindBy(xpath = "//*[.='Hybrid']/..")
    public WebElement fuelType;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[13]")
    public WebElement co2Emissions;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[14]")
    public WebElement horsePower;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[15]")
    public WebElement horsePowerTaxation;

    @FindBy(xpath = "(//div[@class='controls']/input[1])[16]")
    public WebElement powerKW;

    @FindBy(xpath = "//*[.='Choose File']/preceding-sibling::input")
    public WebElement logo;

    @FindBy(css = "a[class^='btn-success']")
    public WebElement saveDropdown;

    @FindBy(xpath = "//*[text() = '\n            Save\n        ']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[text() = '\n            Save and New\n        ']")
    public WebElement saveAndNewBtn;

    @FindBy(xpath = "//*[text() = '\n            Save and Close\n        ']")
    public WebElement saveAndCloseBtn;

    @FindBy(xpath = "(//div[@class='message'])[1]")
    public WebElement message;


    //-----------------------------------------------------------------//

    @FindBy(css = "a[class$='main-group']")
    public WebElement editButton;

}
