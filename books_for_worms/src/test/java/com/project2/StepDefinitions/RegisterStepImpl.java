package com.project2.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.project2.models.POM.RegisterPageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepImpl {
    public WebDriver driver;
    public RegisterPageFactory RegisterPF;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("http://localhost:9090/homepage.html");
        RegisterPF = new RegisterPageFactory(driver);
    }
    @Given("I am on the home Page")
    public void a_user_is_on_the_login_page() {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }
    @When("a non-user clicks on the Register page")
    public void a_non_user_is_on_the_register_page(){
        RegisterPF.clickRegisterPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @When("a non-user inputs a valid username")
    public void a_non_user_inputs_a_valid_username() {
        RegisterPF.inputUsername("testuser");
    }
    @When("a non-user inputs a valid password")
    public void a_non_user_inputs_a_valid_password() {
        RegisterPF.inputPassword("pass123");
    }

    @When("a non-user inputs a valid email")
    public void a_non_user_inputs_a_valid_email() {
        RegisterPF.inputEmail("email@test");
    }

    @When("clicks on the register button")
    public void a_non_user_clicks_on_the_register_button() {
        RegisterPF.clickRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Then("users should be on Login page")
    public void new_user_can_see_login_page() {
        try {
            java.lang.Thread.sleep(3000);
        } catch (Exception e) {

        }
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:9090/login.html");
    }

    @After
    public void teardown(){
        this.driver.quit();
    }
}
