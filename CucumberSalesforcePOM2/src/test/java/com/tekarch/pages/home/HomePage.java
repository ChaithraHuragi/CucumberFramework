package com.tekarch.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tekarch.pages.base.BasePage;

public class HomePage extends BasePage{
		
	WebDriver driver;
	@FindBy(xpath ="/html[1]/head[1]/title[1]") WebElement homePageTitle;
	@FindBy (id ="userNavLabel") WebElement usermenu ;
	@FindBy (xpath="//a[text() ='Logout']") WebElement logout;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getText(WebDriver driver) {
		//waitForElementVisibility(homePageTitle);
		
		return getTitleofWebelemnt(driver);
		
	}
	

	public void userMenu() {
		waitForElementVisibility(usermenu);
		action(usermenu);
		click(usermenu);
	}
	
	public WebDriver logout(WebDriver driver) throws InterruptedException {
		waitForElementVisibility(logout);
		click(logout);
		Thread.sleep(3000);
		return driver;
	}

}
