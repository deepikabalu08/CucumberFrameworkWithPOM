package com.training.steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.firebase.pages.homepages.HomePage;
import com.firebase.pages.loginpages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
// extends TestNGRunCucumberTest ---------->if you calling this class from testng.xml
public class StepsPOM{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	@Before(order=0)
	public void setUp1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	@Before(order=1) // we can have multiple before and after method using order parameter mention order sequence
	public void setUp2() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Given("User open firebase application")
	public void user_open_firebase_application() {
		driver.get("https://qa-tekarch.firebaseapp.com/");
	}
	@When("user on {string}")
	public void user_on(String page) {
	    if(page.equalsIgnoreCase("loginpage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("homepage"))
	    	home=new HomePage(driver);
	}

	@When("User enters value into text box username as {string}")
	public void user_enters_value_into_text_box_username_as(String data) {
		login.enterIntoUsername(data);
		
		System.out.println("user name entered");
	}

	@When("User enters value into text box password as {string}")
	public void user_enters_value_into_text_box_password_as(String data) {
		login.enterIntoPassword(data);
		System.out.println("password entered");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		login.clcikLoginButton();
		System.out.println("login button clicked");
	}

	@Then("verify page title as {string}")
	public void verify_page_title_as(String expectedString) {
		String actual=home.getTitleOfTheHomePage();
		Assert.assertEquals(actual, expectedString);

	}
	
	@Then("alert is present with the text {string}")
	public void alert_is_present_with_the_text(String expected) {
	   String actul= login.handleAlert();
	   Assert.assertEquals(actul, expected);
	}
	@After
	public void tearDown() {
		driver.quit();
	}

}
