package com.dgsl.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {

	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	// Private locators
	private By loginLink = By.xpath("//*[text()='Log In']");
	private By pageHeader = By.xpath("//*[text()='Free CRM Software in the Cloud']");

	// Public Getter Methods
	public WebElement getLoginLink() {
		return getElement(loginLink);
	}

	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}

	// Action performed on element
	public String getWelcomePageTitle() {
		return getPageTitle();
	}

	public String getWelcomePageHeader() {
		return getPageHeader(pageHeader);
	}

	public LoginPage clickOnLoginLink() {
		getLoginLink().click();
		return getInstance(LoginPage.class);

	}

}
