package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DriverFilterPages {

    public DriverFilterPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='main-menu']/ul/li[1]/a/span")
    public WebElement fleetButton;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li[1]/div/div/ul/li[3]/a/span")
    public WebElement vehicleButton;

    @FindBy(xpath = "//a[@class='action btn mode-icon-only']")
    public WebElement filtersButton;

    @FindBy(xpath = "//a[@class='add-filter-button']")
    public WebElement manageFiltersButton;

    @FindBy(xpath = "//label[@title='Driver']")
    public WebElement driverButton;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement driverAllButton;

    @FindBy(xpath = "//div[@class='btn-group btn-block']/button")
    public WebElement selectButton;

    @FindBy(xpath = "//a[@data-value='1']")
    public WebElement contains;

    @FindBy(xpath = "//a[@data-value='2']")
    public WebElement doesNotContain;

    @FindBy(xpath = "//a[@data-value='4']")
    public WebElement startWith;

    @FindBy(xpath = "//a[@data-value='5']")
    public WebElement endWith;

    @FindBy(xpath = "//a[@data-value='3']")
    public WebElement isToEqual;

    @FindBy(xpath = "//a[@data-value='6']")
    public WebElement isAnyOf;

    @FindBy(xpath = "//a[@data-value='7']")
    public WebElement isNotAnyOf;

    @FindBy(xpath = "//a[@data-value='filter_empty_option']")
    public WebElement isEmpty;

    @FindBy(xpath = "//a[@data-value='filter_not_empty_option']")
    public WebElement isNotEmpty;

    @FindBy(xpath = "//div[@class='value-field-frame']/input[1]")
    public WebElement inputText;

    @FindBy(xpath = "//div[@class='value-field-frame']/button")
    public WebElement updateButton;

    @FindBy(xpath = "//div[@id='grid-custom-entity-grid-1122050429']/div[2]/div[2]/div[2]/div/table/tbody/tr/td[3]")
    public List<WebElement> verificationText;

    @FindBy(xpath = "//div[@class='no-data']/span")
    public WebElement verificationMessage;


}
