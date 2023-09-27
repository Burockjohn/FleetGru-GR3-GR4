package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventPage {

    public AddEventPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "oro_calendar_event_form[title]")
    public WebElement titleBox;

    @FindBy(id = "ui-id-4")
    public WebElement titleText;
}
