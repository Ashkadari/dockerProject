package com.searchmodule.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="search_form_input_homepage")
    private WebElement searchBar;
    @FindBy(id="search_button_homepage")
    private WebElement searchBtn;
    @FindBy(linkText="Videos")
    private WebElement videosLink;
    @FindBy(css=".tile-wrap .tile--vid")
    private List<WebElement> noOfVideos;




    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyWord){
       this.wait.until(ExpectedConditions.visibilityOf(this.searchBar)).sendKeys(keyWord);
       this.wait.until(ExpectedConditions.elementToBeClickable(this.searchBtn)).click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink)).click();
    }

    public int getResult(){
        return this.wait.until(ExpectedConditions.visibilityOfAllElements(noOfVideos)).size();
    }
}
