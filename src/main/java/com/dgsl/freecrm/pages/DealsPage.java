package com.dgsl.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DealsPage extends BasePage {

	public DealsPage(WebDriver driver) {
		super(driver);
	}

	// private Locators:
	private By pageHeader = By.xpath("//*[@id='dashboard-toolbar']/div[1]");
	private By newDealsLink = By.xpath("//*[@href='/deals/new']");
	private By title = By.xpath("//input[@name='title']");
	private By access = By.xpath("//*[contains(text(),'Public')]");
	private By userAccess = By.xpath("//div[@class='field']//div[2]/child::*[@role='listbox']");
	private By assignedTo = By.xpath("//div[@aria-disabled='false']");
	private By products = By.xpath("//div[@name='products' and @role='combobox']");
	private By productList = By.xpath("//div[@class='selected item addition' and @role='option']");
	private By contacts = By.xpath("//div[@name='contacts' and @role='combobox']");
	private By contactList = By.xpath("//div[@class='selected item addition' and @role='option']");
	private By closeDate = By.xpath("//input[starts-with(@class,'calendarField')]");
	private By dateTable = By.xpath("//div[@class='react-datepicker']/div[2]");
	private By dateCell = By.xpath("//div[contains(text(),'22')]");
	private By tags = By.xpath("//label[@for='tags']//child::div[@role='combobox']");
	private By tagList = By.xpath("//div[@class='selected item addition' and @role='option']");
	private By description = By.xpath("//textarea[@name='description']");
	private By probability = By.xpath("//input[@name='probability']");
	private By amount = By.xpath("//input[@name='amount']");
	private By comission = By.xpath("//input[@name='commission']");
	private By stage = By.xpath("//div[@name='stage']");
	private By closed = By.xpath("//div[@class='ui toggle checkbox']/input");
	private By status = By.xpath("//div[@name='status']");
	private By nextSteps = By.xpath("//textarea[@name='next_step']");
	private By type = By.xpath("//div[@name='type']");
	private By source = By.xpath("//div[@name='source']");
	private By identifier = By.xpath("//input[@name='identifier']");
	private By saveBtn = By.xpath("//button[contains(text(),'Save')]");

	// Public Getters:
	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}

	public WebElement getNewDealsLink() {
		return getElement(newDealsLink);
	}

	public WebElement getTitle() {
		return getElement(title);
	}

	public WebElement getAccess() {
		return getElement(access);
	}

	public void getUserAccess(String dropDownText) {
		selectDropDownByText(userAccess, dropDownText);
	}

	public void getAssignedTo(String assignedToUser) {
		selectDropDownByText(assignedTo, assignedToUser);
	}

	public void getProducts(String productKeyWord, String productName) {
		searchFieldSuggestionValue(products, productList, productKeyWord, productName);
	}

	public void getContacts(String contactKeyWord, String contactName) {
		searchFieldSuggestionValue(contacts, contactList, contactKeyWord, contactName);
	}

	public WebElement getCloseDate() {
		return getElement(closeDate);
	}

	public void getCloseDate(String dateValue) {
		dateTimePicker(closeDate, dateTable, dateCell, dateValue);
	}

	public void getTags(String tagKeyWord, String tagName) {
		searchFieldSuggestionValue(tags, tagList, tagKeyWord, tagName);
	}

	public WebElement getDescription() {
		return getElement(description);
	}

	public WebElement getProbability() {
		return getElement(probability);
	}

	public WebElement getAmount() {
		return getElement(amount);
	}

	public WebElement getComission() {
		return getElement(comission);
	}

	public void getStage(String stageDropDown) {
		selectDropDownByText(stage, stageDropDown);
	}

	public WebElement getClosed() {
		return getElement(closed);
	}

	public void getStatus(String statusDropDown) {
		selectDropDownByText(status, statusDropDown);
	}

	public WebElement getNextSteps() {
		return getElement(nextSteps);
	}

	public void getType(String typeDropDown) {
		selectDropDownByText(type, typeDropDown);
	}

	public void getSource(String sourceDropDown) {
		selectDropDownByText(source, sourceDropDown);
	}

	public WebElement getIdentifier() {
		return getElement(identifier);
	}

	public WebElement getSaveBtn() {
		return getElement(saveBtn);
	}

	// Page Actions:
	public String getDealsPageTitle() {
		return getPageTitle();
	}

	public String getDealsPageHeader() {
		return getPageHeader(pageHeader);
	}

	/*
	 * public WebElement getDynamicDay(int day){ return
	 * driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")); }
	 */

	public void createNewDeal(String dealsTitle, String dealsAccess, String dealsUserAccess, String dealsAssignedTo,
			String productkeyWord, String productName, String contactKeyWord, String contactName, String dealsCloseDate,
			String tagKeyWord, String tagName, String dealsDescription, String dealsProbability, String dealsAmount,
			String dealsCommission, String dealsStage, String dealsStatus, String dealsNextSteps, String dealsType,
			String dealsSource, String dealsIdentifier) {

		getTitle().sendKeys(dealsTitle);
		getAccess().click();
		getUserAccess(dealsUserAccess);
		getAssignedTo(dealsAssignedTo);
		getProducts(productkeyWord, productName);
		getContacts(contactKeyWord, contactName);

		String dateTime = getDateTime();
		getCloseDate().sendKeys(dateTime);

		// getCloseDate(dealsCloseDate);
		getTags(tagKeyWord, tagName);
		getDescription().sendKeys(dealsDescription);
		getProbability().sendKeys(dealsProbability);
		getAmount().sendKeys(dealsAmount);
		getComission().sendKeys(dealsCommission);
		getStage(dealsStage);
		getClosed().click();
		getStatus(dealsStatus);
		getNextSteps().sendKeys(dealsNextSteps);
		getType(dealsType);
		getSource(dealsSource);
		getIdentifier().sendKeys(dealsIdentifier);
		getSaveBtn().click();

	}
}
