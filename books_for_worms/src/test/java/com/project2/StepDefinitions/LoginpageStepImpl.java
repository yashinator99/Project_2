package com.project2.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.project2.models.POM.LoginPageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class LoginpageStepImpl {
    public WebDriver driver;
    public LoginPageFactory loginPF;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://localhost:9090/login");
        loginPF = new LoginPageFactory(driver);
    }
    @Given("I am on the Login Page")
    public void a_user_is_on_the_login_page() {
        Assert.assertEquals(driver.getTitle(), "Login");
    }
    @When("I input a valid username")
    public void a_user_enters_a_valid_username() {
        loginPF.inputUsername("yash");
    }
    @When("I input a valid password")
    public void a_user_enters_a_valid_password() {
        loginPF.inputPassword("bosh");
    }
    @When("I click on the login button")
    public void a_user_clicks_login_button() {
        loginPF.clickLoginButton();
    }
    @Then("I should see the homepage")
    public void the_user_can_see_the_book_details() {
        try {
            java.lang.Thread.sleep(3000);
        } catch (Exception e) {

        }
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:9090/homepage.html");
    }
    @After
    public void finish(){
        //driver.close();
        driver.quit();
    }

}
