package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage {
    public void VehicleInfo(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//tr[@class='grid-row row-click-action']")
    public WebElement rowButton;
    @FindBy(xpath = "//span[.='General Information']")
    public WebElement genInfoPageName;
}
