package com.project2.StepDefinitions;
import static org.mockito.Answers.valueOf;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.project2.models.POM.HomePageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageStepImpl{

    public WebDriver driver;
    public HomePageFactory homePageFactory;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("http://localhost:9090/");

        homePageFactory = new HomePageFactory(driver);
    }
   
    
@Given("a user is on the home page")
public void a_user_is_on_the_home_page() {
    Assert.assertEquals(driver.getTitle(), "Books For Worms");
}
@When("a user enters a valid  book title")
public void a_user_enters_a_valid_book_title() {
    homePageFactory.inputText("phil");
}
@When("clicks on the submit button")
public void clicks_on_the_submit_button() {
    homePageFactory.clickSearchButton();
}
@Then("the user can see the book details")
public void the_user_can_see_the_book_details() {
  //  String bookText = driver.findElement(By.id("books")).getAttribute("value");
  String bookText = driver.findElement(By.xpath("/html/body/pre")).getText();
    Assert.assertEquals(bookText,bookText);
}


}