package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String expectedPrice;
    private String noOfPassengers;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setParameters(String noOfPassengers, String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("ash","kad");
        registrationPage.enterUserCredentials("test.test@email.com","ABCD1234");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.goToFlightDetailsSearch();
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlights();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightBtn();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

}
