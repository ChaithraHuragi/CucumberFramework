package com.tekarch.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.tekarch.base.BaseClass;
import com.tekarch.pages.home.HomePage;
import com.tekarch.pages.login.ForgotPassword;
import com.tekarch.pages.login.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationForSalesForce extends BaseClass {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	ForgotPassword forgot;

	
	  
	  @Before public void setup() { 
		  System.out.println("in setup");
	  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  }
	  
	  @After public void tearDown(){ 
		  driver.close(); 
		  }
	  
	 

	@Given("User opens SalesForce App")
	public void user_opens_sales_force_app() {
		driver.get("https://login.salesforce.com");
		System.out.println("launched chrome");
	}

	@When("user on  {string}")
	public void user_on(String page) {
		System.out.println("decide the page");
		if (page.equalsIgnoreCase("loginpage"))
			login = new LoginPage(driver);
		else if (page.equalsIgnoreCase("homepage"))
			home = new HomePage(driver);
		else if (page.equalsIgnoreCase("forgotpassword"))
			forgot = new ForgotPassword(driver);
		else
			System.out.println("page not indentified");
	}

	@When("user enters Username as  {string}")
	public void user_enters_username_as(String username) {

		login.enterUserName(username);
		System.out.println(username);
	}

	@When("click on loginButton")
	public void click_on_login_button() {
		login.clickLogin();
		System.out.println("click login");
	}

	@Then("verify the error message displayed")
	public void verify_the_error_message_displayed() {
		login.getErrorloginmessage();
	}

	@When("user enters password as  {string}")
	public void user_enters_password_as(String pwd) {
		login.enterPasswords(pwd);
	}

	@Then("verify for homepage")
	public void verify_for_homepage() {
		String expected = "Home Page ~ Salesforce - Developer Edition";
		String actual = home.getTitleofWebelemnt(driver);
		Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			System.out.println("loginPage test case pass");
		} else {
			System.out.println(" loginPage test case fail");
		}

	}

	@When("click LogoutButton")
	public WebDriver click_logout_button() throws InterruptedException {
		home.userMenu();
		driver = home.logout(driver);
		return driver;

	}

	@Then("check for RememberMe")
	public void check_for_remember_me() throws Exception {
		Thread.sleep(3000);
		WebElement checkremember = login.rememberMe(driver);
		login.validateIsEnabled(checkremember);
	}

	@When("click RememberMe")
	public void click_remember_me() {
		login.clickRemembermeCheck();
	}

	@Then("verify for errorLoginMessage")
	public void verify_for_error_login_message() {
		login.validateIsEnabled(login.getErrorloginmessage());
	}

	@When("click on forgotPassword")
	public void click_on_forgot_password() {
		login.clickForgotPassword(driver);
	}

	@Then("verify for forgotPageTitle")
	public void verify_for_forgot_page_title() {
		String expected = "Forgot Your Password | Salesforce";
		String actual = forgot.getText(driver);
		System.out.println("actual:" + actual);
		Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			System.out.println("forgotPassword testcase pass");
		} else {
			System.out.println(" forgotpassword test case fail");
		}

	}

}
