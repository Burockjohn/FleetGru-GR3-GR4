package com.test.pages;

import com.test.utilities.Driver;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage extends BasePage{
    public  GeneralInformationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[2]")
    public WebElement rowButton;
    @FindBy(xpath = "//span[.='General Information']")
    public WebElement genInfoPageName;
    //@FindBy(xpath = "(//a[@class='dropdown-toggle'])[4]")
    @FindBy(xpath = "(//div[@class='dropdown']/a)[2]")
    public WebElement threeDot;
   //@FindBy(xpath = "(//i[@class='fa-eye hide-text'])[1]")
     @FindBy(xpath = "//a[@title='View']")
    public WebElement eye;
    @FindBy(xpath = "//a[@class='btn back icons-holder-text edit-button main-group']")
    public WebElement editButton;
    @FindBy(xpath = "//a[@class=' btn icons-holder-text no-hash remove-button']")
    public WebElement deleteButton;
    @FindBy(xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement AddButton;
    @FindBy(xpath = "//div[@class='row']")
    public WebElement headRow;



    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    public WebElement genLicencePlate;
    @FindBy(xpath = "(//div[@class='control-label'])[2]")
    public WebElement genTags;

    @FindBy(xpath = "(//div[@class='control-label'])[3]")
    public WebElement genDriver;

    @FindBy(xpath = "(//div[@class='control-label'])[4]")
    public WebElement genLocation;

    @FindBy(xpath = "(//div[@class='control-label'])[5]")
    public WebElement genChassisNumber;
    @FindBy(xpath = "(//div[@class='control-label'])[6]")
    public WebElement genModelYear;

    @FindBy(xpath = "(//div[@class='control-label'])[7]")
    public WebElement genLastOdometer;

    @FindBy(xpath = "(//div[@class='control-label'])[8]")
    public WebElement genImmatriculation;

    @FindBy(xpath = "(//div[@class='control-label'])[9]")
    public WebElement genFirstContract;

    @FindBy(xpath = "(//div[@class='control-label'])[10]")
    public WebElement genCatalogValue;

    @FindBy(xpath = "(//div[@class='control-label'])[11]")
    public WebElement genSeatsNumber;
    @FindBy(xpath = "(//div[@class='control-label'])[12]")
    public WebElement genDoorsNumber;

    @FindBy(xpath = "(//div[@class='control-label'])[13]")
    public WebElement genColor;

    @FindBy(xpath = "(//div[@class='control-label'])[14]")
    public WebElement genTransmission;

    @FindBy(xpath = "(//div[@class='control-label'])[15]")
    public WebElement genFuelType;

    @FindBy(xpath = "(//div[@class='control-label'])[16]")
    public WebElement genCO2 ;

    @FindBy(xpath = "(//div[@class='control-label'])[17]")
    public WebElement genHorsepower;

    @FindBy(xpath = "(//div[@class='control-label'])[18]")
    public WebElement genHorsepowerTax;

    @FindBy(xpath = "(//div[@class='control-label'])[19]")
    public WebElement genPower;

    @FindBy(xpath = "(//div[@class='control-label'])[20]")
    public WebElement genLogo;

    @FindBy(xpath = "(//div[@class='control-label'])[21]")
    public WebElement genVehicleModel;

    @FindBy(xpath = "(//div[@class='control-label'])[22]")
    public WebElement genVehicleMake;

    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate'])[2]")
    public WebElement carsPageLicencePlate;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Tags'])[2]")
    public WebElement carsPageTags;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Driver'])[2]")
    public WebElement carsPageDriver;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Location'])[2]")
    public WebElement carsPageLocation;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-ChassisNumber'])[2]")
    public WebElement carsPageChassisNumber;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-ModelYear'])[2]")
    public WebElement carsPageModelYear;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-LastOdometer'])[2]")
    public WebElement carsPageLastOdometer;
    @FindBy(xpath = "(//td[@class='date-cell grid-cell grid-body-cell grid-body-cell-ImmatriculationDate'])[2]")
    public WebElement carsPageImmatriculation;
    @FindBy(xpath = "(//td[@class='date-cell grid-cell grid-body-cell grid-body-cell-FirstContractDate'])[2]")
    public WebElement carsFirstContract;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-CatalogValue'])[2]")
    public WebElement carsPageCatalogValue;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-SeatsNumber'])[2]")
    public WebElement carsPageSeatsNumber;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-DoorsNumber'])[2]")
    public WebElement carsPageDoorsNumber;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Color'])[2]")
    public WebElement carsPageColor;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Transmission'])[2]")
    public WebElement carsPageTransmission;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-FuelType'])[2]")
    public WebElement carsPageFuelType;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-CO2Emissions'])[2]")
    public WebElement carsPageCO2;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-Horsepower'])[2]")
    public WebElement carsPageHorsepower;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-HorsepowerTaxation'])[2]")
    public WebElement carsPageHorsepowerTax;
    @FindBy(xpath = "(//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-Power'])[2]")
    public WebElement carsPagePower;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate'])[2]")
    public WebElement carsPageLogo;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate'])[2]")
    public WebElement carsPageVehicleModel;
    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate'])[2]")
    public WebElement carsPageVehicleMake;






}
