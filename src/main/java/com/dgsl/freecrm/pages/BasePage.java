package com.dgsl.freecrm.pages;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	// Generic util Wrapper
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Some error occured while creating element: "
					+ locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(locator);
			return elements;
		} catch (Exception e) {
			System.out
					.println("Some error occured while creating list of elements: "
							+ locator.toString());
		}
		return elements;
	}

	@Override
	public String getAttribute(By locator, String attributeName) {
		return driver.findElement(locator).getAttribute(attributeName);
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out
					.println("Some error occured while locating the element: "
							+ locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out
					.println("Some error/exception occured while waiting for page title: "
							+ title);
			e.printStackTrace();
		}
	}

	@Override
	public void selectDropDownByText(By locator, String dropDownName) {
		Select selectByName = new Select(getElement(locator));
		selectByName.selectByVisibleText(dropDownName);
	}

	@Override
	public void searchFieldSuggestionValue(By locator, By suggestionBoxLocator,
			String suggestionKeyWord, String searchName) {
		getElement(locator).sendKeys(suggestionKeyWord);
		List<WebElement> suggestedNames = getElements(suggestionBoxLocator);
		for (WebElement eachSuggestion : suggestedNames) {
			if (eachSuggestion.equals(searchName)) {
				eachSuggestion.click();
			}
		}
	}

	@Override
	public void dateTimePicker(By locator, By datePickerTable,
			By datePickerCells, String date) {
		getElement(locator).click();
		WebElement table = getElement(datePickerTable);
		List<WebElement> tableRows = table.findElements(datePickerTable);
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(datePickerCells);
			for (WebElement cell : cells) {
				if (cell.getText().equals(date)) {
					cell.click();
				}
			}
		}
	}

	@Override
	public String getDateTime() {
		return LocalDateTime.now().toString();
		
	}
}
