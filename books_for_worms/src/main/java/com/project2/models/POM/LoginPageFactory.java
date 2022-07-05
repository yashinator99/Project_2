package com.project2.models.POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageFactory {
    WebDriver webDriver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "btn-login")
    WebElement loginbutton;


    public LoginPageFactory(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void inputUsername(String text){
        this.username.sendKeys(text);
    }

    public void inputPassword(String text){
        this.password.sendKeys(text);
    }

    public void clickLoginButton(){
        this.loginbutton.click();
    }
}
