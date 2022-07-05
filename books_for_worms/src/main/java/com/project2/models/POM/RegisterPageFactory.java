package com.project2.models.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory {
    WebDriver webDriver;
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "register btn")
    WebElement registerbutton;

    @FindBy(id = "register_nav")
    WebElement registerPage;


    public RegisterPageFactory(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void inputUsername(String text){
        this.username.sendKeys(text);
    }

    public void inputPassword(String text){
        this.password.sendKeys(text);
    }

    public void inputEmail(String text){
        this.email.sendKeys(text);
    }

    public void clickRegisterButton(){
        this.registerbutton.click();
    }

    public void clickRegisterPage(){
        this.registerPage.click();
    }
}
