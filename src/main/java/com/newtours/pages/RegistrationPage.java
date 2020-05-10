package com.newtours.pages;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameTxtBox;
    @FindBy(name="lastName")
    private WebElement lastNameTxtBox;
    @FindBy(name="email")
    private WebElement userNameTxtBox;
    @FindBy(name="password")
    private WebElement passwordTxtBox;
    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxtBox;
    @FindBy(name="register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxtBox));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameTxtBox.sendKeys(firstName);
        this.lastNameTxtBox.sendKeys(lastName);
    }

    public void enterUserCredentials(String userEmail, String userPassword){
        this.userNameTxtBox.sendKeys(userEmail);
        this.passwordTxtBox.sendKeys(userPassword);
        this.confirmPasswordTxtBox.sendKeys(userPassword);
    }

    public void submit(){
        this.submitBtn.click();
    }
}
