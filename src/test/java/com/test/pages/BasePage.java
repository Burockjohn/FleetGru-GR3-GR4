package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    /**

     Waits until loader screen present. If loader screen will not pop up at all,
     NoSuchElementException will be handled  by try/catch block
     Thus, we can continue in any case.*/
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));} catch (Exception e) {
            e.printStackTrace();}

    }

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(xpath = "//*[text() = '\n    Fleet']") ////a[@class='unclickable']
    public WebElement fleetOpt;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehiclesOpt;




}
