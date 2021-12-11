package com.dgsl.freecrm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebEventListener extends TestUtil implements ITestListener, WebDriverEventListener {

	public void onFinish(ITestContext arg0) {

	}

	public void onStart(ITestContext arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Tests");
		takeScreenshotOnFail(driver, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult arg0) {

	}

	public void onTestStart(ITestResult arg0) {

	}

	public void onTestSuccess(ITestResult arg0) {

	}

	public void afterAlertAccept(WebDriver arg0) {

	}

	public void afterAlertDismiss(WebDriver arg0) {

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {

	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {

	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {

	}

	public void afterNavigateBack(WebDriver arg0) {

	}

	public void afterNavigateForward(WebDriver arg0) {

	}

	public void afterNavigateRefresh(WebDriver arg0) {

	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {

	}

	public void afterScript(String arg0, WebDriver arg1) {

	}

	public void beforeAlertAccept(WebDriver arg0) {

	}

	public void beforeAlertDismiss(WebDriver arg0) {

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {

	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {

	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {

	}

	public void beforeNavigateBack(WebDriver arg0) {

	}

	public void beforeNavigateForward(WebDriver arg0) {

	}

	public void beforeNavigateRefresh(WebDriver arg0) {

	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {

	}

	public void beforeScript(String arg0, WebDriver arg1) {

	}

	public void onException(Throwable arg0, WebDriver arg1) {

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

}
