package com.dgsl.freecrm.base;

import org.openqa.selenium.WebDriver;

public class DriverInstance {

	WebDriver driver;
	private static DriverInstance driverInstance = null;

	private DriverInstance() {

	}

	public static DriverInstance getDriverInstance() {
		if (driverInstance == null) {
			driverInstance = new DriverInstance();
		}
		return driverInstance;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
