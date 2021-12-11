package com.dgsl.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	// Page locator
	private By emailId = By.xpath("//*[@type='text']");
	private By password = By.xpath("//*[@type='password']");
	private By loginBtn = By.xpath("//*[text()='Login']");
	private By pageHeader = By
			.xpath("//*[contains(text(),'No Account? Registration takes only a few seconds?')]");
	private By invalidLoginErrorMessage = By
			.xpath("//*[text()='Something went wrong...']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Public Getter Methods
	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public WebElement getInvalidLoginErrorMessage() {
		return getElement(invalidLoginErrorMessage);
	}

	// Actions performed on elements
	public String getLoginPageTitle() {
		return getPageTitle();
	}

	public String getLoginPageHeader() {
		return getPageHeader(pageHeader);
	}

	public HomePage validLoginIntoApplication(String email, String password) {
		getEmailId().sendKeys(email);
		getPassword().sendKeys(password);
		getLoginBtn().click();
		return getInstance(HomePage.class);
	}

	public String invalidLoginIntoApplication() {
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();
		return getInvalidLoginErrorMessage().getText();
	}
}
