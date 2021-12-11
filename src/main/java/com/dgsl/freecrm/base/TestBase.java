package com.dgsl.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.dgsl.freecrm.pages.BasePage;
import com.dgsl.freecrm.pages.Page;
import com.dgsl.freecrm.util.Constants;
import com.dgsl.freecrm.util.TestUtil;
import com.dgsl.freecrm.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	WebEventListener eventListener;
	EventFiringWebDriver e_driver;
	public Page page;
	WebDriver driver = DriverInstance.getDriverInstance().getDriver();;
	public ExtentReports report;
	public ExtentTest test;
	TestUtil util;
	static ExtentHtmlReporter htmlReport;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream inputstream = new FileInputStream(Constants.GLOBAL_CONFIG_FILE);
			prop.load(inputstream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void startTest() {
		htmlReport = new ExtentHtmlReporter(Constants.EXTENT_REPORT_PATH);
		report = new ExtentReports();
		report.attachReporter(htmlReport);

		htmlReport.config().setDocumentTitle("Automation Report");
		htmlReport.config().setReportName("FREE CRM Extent Report V4.0");
		htmlReport.config().setTheme(Theme.STANDARD);

		report.setSystemInfo("Application Name", "Free CRM Application Test");
		report.setSystemInfo("User Name", "Dilip P");
		report.setSystemInfo("Envirnoment", "Audit");

	}

	@Parameters(value = { "browser" })
	@BeforeMethod
	public void initialization(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER);
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", Constants.GECKO_DRIVER);
			driver = new InternetExplorerDriver();
		} else {
			System.out.println(browser + " is invalid...");
		}

		// To display on console all the events performed by WebDriver
		eventListener = new WebEventListener();
		e_driver = new EventFiringWebDriver(driver);
		e_driver.register(eventListener);
		driver = e_driver;

		driver.get(prop.getProperty("URL"));

		page = new BasePage(driver);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			String screenShotPath = util.takeScreenshotOnFail(driver, result.getMethod().getMethodName());
			test.log(Status.PASS, result.getName() + " Test Case PASSED");
			try {
				test.pass("Test Case Passed Snapshot is below: " + test.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = util.takeScreenshotOnFail(driver, result.getMethod().getMethodName());
			test.log(Status.FAIL, result.getThrowable().getMessage());
			try {
				test.fail("Test Case Failed Snapshot is below: " + test.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			String screenShotPath = util.takeScreenshotOnFail(driver, result.getMethod().getMethodName());
			test.log(Status.SKIP, result.getThrowable().getMessage());
			try {
				test.skip("Test Case Skipped Snapshot is below: " + test.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@AfterTest
	public void tearDown() {
		report.flush();
		driver.quit();
	}

}
