package com.dgsl.freecrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dgsl.freecrm.base.DriverInstance;
import com.dgsl.freecrm.util.TestUtil;

public abstract class Page {

	WebDriver driver = DriverInstance.getDriverInstance().getDriver();
	WebDriverWait wait;

	// Page Class Constructor
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, TestUtil.EXPLICIT_WAIT);
	}

	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract List<WebElement> getElements(By locator);

	public abstract String getAttribute(By locator, String attributeName);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitle(String title);

	public abstract void selectDropDownByText(By locator, String dropDownName);

	public abstract void searchFieldSuggestionValue(By locator, By suggestionBoxLocator, String KeyWord, String Name);

	public abstract void dateTimePicker(By locator, By dateTable, By dateCell, String date);

	public abstract String getDateTime();

	// Create a method with Java Generic and return a new page
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {

		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
}
