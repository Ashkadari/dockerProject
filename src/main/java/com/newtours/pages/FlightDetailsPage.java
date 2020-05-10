package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(name="passCount")
    private WebElement passangersSlct;
    /*
    @FindBy(name="fromPort")
    private WebElement departfromSlct;
    @FindBy(name="fromMonth")
    private WebElement departMonthSlct;
    @FindBy(name="toDay")
    private WebElement departDaySlct;
    @FindBy(name="toPort")
    private WebElement arrivingInSlct;
    @FindBy(name="toMonth")
    private WebElement returnInMnthSlct;
    @FindBy(name="toDay")
    private WebElement returnInDaySlct;
     */
    @FindBy(xpath="//a[text()='Flights']")
    private WebElement flightsLink;
    @FindBy(name="findFlights")
    private WebElement submitBtn;


    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsSearch(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsLink)).click();
    }

    private void selectWebElementWithValue(WebElement el, String text){
        this.wait.until(ExpectedConditions.elementToBeClickable(el));
        Select select = new Select(el);
        select.selectByValue(text);
    }
    public void selectPassengers(String noOfPassengers){
        selectWebElementWithValue(this.passangersSlct, noOfPassengers);
    }

    public void goToFindFlights(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.submitBtn)).click();
    }

}
