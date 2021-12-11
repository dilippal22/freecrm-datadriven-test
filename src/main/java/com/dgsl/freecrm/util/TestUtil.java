package com.dgsl.freecrm.util;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dgsl.freecrm.base.DriverInstance;
import com.google.common.io.Files;

public class TestUtil {

	WebDriver driver = DriverInstance.getDriverInstance().getDriver();
	static Excel_Reader reader;
	public static final long IMPLICIT_WAIT = 10;

	public static final long EXPLICIT_WAIT = 10;

	public static final long PAGE_LOAD_TIMEOUT = 20;

	public String takeScreenshotOnFail(WebDriver driver, String testMethodName) {
		File srcFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "\\Screenshot\\" + testMethodName + LocalDateTime.now()
				+ ".png";

		try {
			Files.copy(srcFile, new File(destPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destPath;
	}

	public static ArrayList<Object[]> getTestDataFromExcel() {
		ArrayList<Object[]> dealData = new ArrayList<Object[]>();
		try {
			reader = new Excel_Reader(Constants.EXCEL_READER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("DealTestData"); rowNum++) {
			String title = reader.getCellData("DealTestData", "Title", rowNum);
			String UserAccess = reader.getCellData("DealTestData", "UserAccess", rowNum);
			String AssignedTo = reader.getCellData("DealTestData", "AssignedTo", rowNum);
			String Product = reader.getCellData("DealTestData", "Product", rowNum);
			String Contact = reader.getCellData("DealTestData", "Contact", rowNum);
			String CloseDate = reader.getCellData("DealTestData", "CloseDate", rowNum);
			String TagKeyword = reader.getCellData("DealTestData", "TagKeyword", rowNum);
			String Description = reader.getCellData("DealTestData", "Description", rowNum);
			String Probability = reader.getCellData("DealTestData", "Probability", rowNum);
			String Amount = reader.getCellData("DealTestData", "Amount", rowNum);
			String Commission = reader.getCellData("DealTestData", "Commission", rowNum);
			String Stage = reader.getCellData("DealTestData", "Stage", rowNum);
			String Status = reader.getCellData("DealTestData", "Status", rowNum);
			String NextStep = reader.getCellData("DealTestData", "NextStep", rowNum);
			String Type = reader.getCellData("DealTestData", "Type", rowNum);
			String Source = reader.getCellData("DealTestData", "Source", rowNum);
			String Identifier = reader.getCellData("DealTestData", "Identifier", rowNum);

			Object[] ob = { title, UserAccess, AssignedTo, Product, Contact, CloseDate, TagKeyword, Description,
					Probability, Amount, Commission, Stage, Status, NextStep, Type, Source, Identifier };
			dealData.add(ob);
		}
		return dealData;

	}
}
