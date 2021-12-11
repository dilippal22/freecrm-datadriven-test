package com.dgsl.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Private Locators:
	private By pageHeader = By.xpath("//*[@id='top-header-menu']/div[1]");
	private By dealsLink = By.xpath("//*[@href='/deals']");

	// Public getters:
	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}

	public WebElement getDealsLink() {
		return getElement(dealsLink);
	}

	// Page Actions:
	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getPageHeader(pageHeader);
	}
	
	public DealsPage clickOnDealsLink(){
		getDealsLink().click();
		return getInstance(DealsPage.class);
	}

}
