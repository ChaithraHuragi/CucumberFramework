package com.tekarch.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tekarch.pages.base.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver ;
	@FindBy(id = "username") WebElement userName;
	@FindBy(id = "password") WebElement password;
	@FindBy(id = "Login") WebElement loginPage;
	@FindBy(xpath="//div[text() = 'Please enter your password.']") WebElement errormessage;
	@FindBy (xpath="//div[@id='error']") WebElement errorloginmessage;
	@FindBy (id ="idcard-identity") WebElement rememberMe ;
	@FindBy (id ="forgot_password_link") WebElement forgot;
	
	
	@FindBy (xpath="//input[@id='rememberUn']") WebElement rememberMeCheck;
		
		public LoginPage(WebDriver driver) {
			super(driver);
			
		}
	
		public void enterUserName(String data) {
			sendText(userName, data, "userName");
		}
		
		public void enterPasswords(String data) {
			sendText(password, data,"password");
		
		}
		
		public WebDriver clickLogin() {
			driver =click(loginPage);
			return driver;
		}
		
		public void clickRemembermeCheck() {
			click(rememberMeCheck);
		}
		
		public WebDriver clickForgotPassword(WebDriver driver) {
			click(forgot);
			return driver;
		}
		
		public WebElement getErrormessage() {
			return errormessage;
		}
		
		public WebElement getErrorloginmessage() {
			return errorloginmessage;
		}
		
		public WebElement rememberMe(WebDriver driver) {
			waitForElementVisibility(rememberMe);
			return rememberMe;
		}
		
	
}
