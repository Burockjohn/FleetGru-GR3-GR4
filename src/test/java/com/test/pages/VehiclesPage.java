package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesPage extends BasePage {

    public VehiclesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement firstRow;

    @FindBy(xpath = "(//div[@class='dropdown']/a)[1]")
    public WebElement firstDropdown;

    @FindBy(xpath = "(//li[@class='launcher-item'])[2]")
    public WebElement edit3dot;

    @FindBy(css = "div.message")
    public WebElement flashMessage; // alert

    @FindBy(xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement addEvent;


    @FindBy(xpath = "//a[@title='Filters']")
    public WebElement filterIcon;


    @FindBy(xpath = "//a[.='Manage filters']")
    public WebElement linkManageFilter;


    @FindBy(css = "ul[class^='ui-multiselect-checkboxes'] span")
    public List<WebElement> filterNames;


    @FindBy(css = "ul[class^='ui-multiselect-checkboxes']>li[style='']")
    public WebElement filterName;


    //@FindBy(css = ".filter-items>div>div[class*='btn']")
    @FindBy(css = ".filter-items>div[style='display: inline-block;']")
    public List<WebElement> chosenFilters;



    @FindBy(css = "[type='search']")
    public WebElement inputSearchForFiltering;


    @FindBy(css = "a[class*='reset-action']")
    public WebElement resetIcon;




}
