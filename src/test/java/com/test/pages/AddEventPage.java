package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventPage {

    public AddEventPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='ui-dialog-title']")
    public WebElement title;

    @FindBy(xpath = "//button[.='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;



    //Labels
    @FindBy(xpath = "(//div[@class='control-label wrap']/label)[1]")
    public WebElement titleLabel;
    @FindBy(xpath = "(//div[@class='control-label wrap']/label)[8]")
    public WebElement ownerLabel;

    @FindBy(xpath = "(//div[@class='control-label wrap']/label)[9]")
    public WebElement orgDispNameLabel;

    @FindBy(xpath = "(//div[@class='control-label wrap']/label)[10]")
    public WebElement orgDispEmailLabel;
    @FindBy(xpath = "(//div[@class='control-label wrap']/label)[11]")
    public WebElement startDateLabel;

    @FindBy(xpath = "(//div[@class='control-label wrap']/label)[12]")
    public WebElement endDateLabel;

    //Text Boxes
    @FindBy(xpath = "(//div[@class='controls']/input)[1]")
    public WebElement titleTextBox;

    @FindBy(xpath = "//input[contains (@id, 'oro_calendar_event_form_organizerDisplayName')]")
    public WebElement orgDispNameTextBox;

    //input[contains (@id, 'oro_calendar_event_form_organizerDisplayName')]
    //tagname[contains (@Attribute, 'Value')]


    @FindBy(xpath = "//input[contains (@id, 'oro_calendar_event_form_organizerEmail')]")
    public WebElement orgDispEmailTextBox;

    @FindBy(xpath = "//span[@class='validation-failed']")
    public WebElement errorMessage;
}
