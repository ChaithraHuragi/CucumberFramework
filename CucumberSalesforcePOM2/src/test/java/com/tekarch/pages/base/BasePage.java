package com.tekarch.pages.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.base.BaseClass;
import com.tekarch.utilityforsaleforce.ExtentReportsUtility;

public class BasePage {
	protected static WebDriver driver = null;
	protected static Logger logger = LogManager.getLogger(BasePage.class.getName());
	protected static ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();


	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static void sendText(WebElement element, String text, String webElementName) {
		if (element.isDisplayed()) {
			System.out.println("Find Element: " + webElementName);
			element.clear();
			element.sendKeys(text);
		} else {
			System.out.println(webElementName + "WebElement is not found  ");
		}
	}
	
	public static WebDriver click(WebElement webElement) {
		logger.info("clicked" + webElement);
		webElement.click();
		return driver;
		
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}

	public String getTextFromWebElement(WebElement element,String name) {
		return element.getText();
	}
	
	public String getTitleofWebelemnt(WebDriver driver) {
		return driver.getTitle();
	}
	public static void waitForElementVisibility(WebElement element) {
		logger.info("waiting for element:" + element);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public static void action(WebElement element) {
		logger.info("action performing on:" + element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}
	
	public static void validateIsEnabled(WebElement element) {
		
		
		if(element.isEnabled()) {
			System.out.println("Test Case Passed" );//+ method.getName());
			extentReport.logTestpassed(getTitle());
	
			//logger.info(method.getName());
			//extentReport.logTestpassed(method.getName());
			
		}else {
			System.out.println("Test case failed" );//+ method.getName());
		//	extentReport.logTestFailed(method.getName());
		//	logger.info(method.getName());
			extentReport.logTestFailed(getTitle());
		}
		
	}
	

	
}
