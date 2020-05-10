package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath="//td[@class='frame_header_info']//font[contains(text(), 'Confirmation')]")
    private WebElement flightConfirmationNo;
    @FindBy(xpath="//font[contains(text(), 'Price (including taxes)')]/following::font[@color='blaCK']//font")
    private WebElement totalPrice;
    @FindBy(linkText="SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public String  getPrice(){
        System.out.println(this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationNo)).getText());
        String price = this.wait.until(ExpectedConditions.visibilityOf(this.totalPrice)).getText();
        this.signOffLink.click();
        return price;
    }
}
