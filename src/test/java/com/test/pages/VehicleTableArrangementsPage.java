package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleTableArrangementsPage extends BasePage{

    public VehicleTableArrangementsPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//button[@class= 'btn dropdown-toggle ']")
    public WebElement viewPerPage;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement pageNumber;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> itemsOfDropdown;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[4]")
    public WebElement option100;

    @FindBy(tagName = "tr")
    public List<WebElement> carRecord;

    @FindBy(xpath = "(//i[@class='fa-refresh'])[2]")
    public WebElement refreshButton;

    @FindBy(xpath = "(//span[@class='grid-header-cell__label'])[6]")
    public WebElement modelYearColumnName;

    @FindBy(xpath = "//tr[@class='grid-row']/td[6]")
    public List<WebElement> totalModelYear;

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filterButton;

    @FindBy(xpath = "(//span[@class='caret'])[1]")
    public WebElement manageFilterDropdown;

    @FindBy(xpath = "(//input[@name='multiselect_0'])[6]")
    public WebElement modelYearCheckbox;

    @FindBy(xpath = "(//span[@class='caret'])[2]")
    public WebElement modelYearAllDropdown;

    @FindBy(xpath = "(//span[@class='caret'])[3]")
    public WebElement containsDropdown;

    @FindBy(xpath = "//a[.='is equal to']")
    public WebElement isEqualTo;

    @FindBy(xpath = "//div[@class='value-field-frame']/input")
    public WebElement input;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement updateButton;

}
