package com.tekarch.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tekarch.pages.base.BasePage;

public class ForgotPassword extends BasePage {

	public ForgotPassword(WebDriver driver) {
		super(driver);
	}

	public String getText(WebDriver driver) {
		return getTitleofWebelemnt(driver);
		
	}
}
