package com.tekarch.SalesForce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.tekarch.base.BaseClass;
import com.tekarch.pages.home.HomePage;
import com.tekarch.pages.login.LoginPage;
import com.tekarch.pages.login.ForgotPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

@Listeners(com.tekarch.utilityforsaleforce.TestEventListners.class)
public class SalesForceWithFrameLoginPage extends BaseClass {

	@Test(alwaysRun = true, priority = 1)
	public static void errorMessageBlankPassword() throws IOException {
		// tc01
		logger.info("test case 1 inside");
		extentReport.logTestInfo("test case 1 inside");
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");

		String userid = propertiesUtility.getPropertyData("login.valid.userid");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userid);
		driver = loginpage.clickLogin();
		loginpage.validateIsEnabled(loginpage.getErrormessage());
	}

	@Test(alwaysRun = true, priority = 2)

	public static void loginPage() {
		// tc02
		String expected = "Home Page ~ Salesforce - Developer Edition";
		logger.info("test case 2 inside");
		extentReport.logTestInfo("test case 2 inside");
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		String userid = propertiesUtility.getPropertyData("login.valid.userid");
		String pwd = propertiesUtility.getPropertyData("login.valid.password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userid);
		loginpage.enterPasswords(pwd);
		driver = loginpage.clickLogin();
		HomePage homepage = new HomePage(driver);
		System.out.println("About to get the title");
		String actual = homepage.getText(driver);
		System.out.println("actual:" + actual);
		Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			System.out.println("loginPage");
			logger.info("loginPage");
			extentReport.logTestpassed("loginPage");
		} else {
			System.out.println(" loginPage test case fail");
			logger.info("loginPage");
			extentReport.logTestFailed("loginPage");
		}

	}

	@Test(alwaysRun = true, priority = 6)

	public static void validateCheck() throws InterruptedException {
		// tc03
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		String userid = propertiesUtility.getPropertyData("login.valid.userid");
		String pwd = propertiesUtility.getPropertyData("login.valid.password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userid);
		loginpage.enterPasswords(pwd);
		loginpage.clickRemembermeCheck();
		driver = loginpage.clickLogin();
		HomePage homepage = new HomePage(driver);
		homepage.userMenu();
		driver = homepage.logout(driver);
		WebElement checkremember = loginpage.rememberMe(driver);
		loginpage.validateIsEnabled(checkremember);

	}

	@Test(alwaysRun = true, priority = 4)
	public static void forgotPassword() throws IOException {
		// tc 4A String expected = "Check Your Email";
		String expected = "Forgot Your Password | Salesforce";
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		LoginPage loginpage = new LoginPage(driver);
		driver = loginpage.clickForgotPassword(driver);
		ForgotPassword forgotpassword = new ForgotPassword(driver);
		System.out.println("finding actual");
		String actual = forgotpassword.getText(driver);
		System.out.println("actual:" + actual);
		Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			System.out.println("forgotPassword testcase pass");
			logger.info("Forgotpassword");
			extentReport.logTestpassed("Forgot password");
		} else {
			System.out.println(" forgotpassword test case fail");
			logger.info("Forgotpassword");
			extentReport.logTestFailed("Forgot password");
		}

	}

	@Test(alwaysRun = true, priority = 5)
	public static void errorWithInvalidCred() {
		// 4b
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		String userid = propertiesUtility.getPropertyData("login.invalid.userid");
		String pwd = propertiesUtility.getPropertyData("login.invalid.password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userid);
		loginpage.enterPasswords(pwd);
		driver = loginpage.clickLogin();
		loginpage.validateIsEnabled(loginpage.getErrorloginmessage());
		

	}

}
