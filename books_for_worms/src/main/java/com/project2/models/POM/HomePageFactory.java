package com.project2.models.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
    WebDriver webDriver;

    @FindBy(id = "Home_search_container")
    WebElement searchContainer;

    @FindBy(xpath = "/html/body/form/div/div[2]/input")
    WebElement textInput;
    

    @FindBy(xpath = "/html/body/form/div/div[3]/input")
    WebElement searchbutton;

    @FindBy(xpath = "/html/body/pre")
    WebElement bookInfo;


    public HomePageFactory(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void inputText(String text){
        this.textInput.sendKeys(text);
    }

    public void clickSearchButton(){
        this.searchbutton.click();


    
}
}
