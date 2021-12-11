package com.dgsl.freecrm.util;

public class Constants {

	// Config Properties File Path
	public static final String GLOBAL_CONFIG_FILE = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\dgsl\\freecrm\\config\\config.properties";

	// Chrome Driver File Path
	public static final String CHROME_DRIVER = System.getProperty("user.dir")
			+ "\\BrowserDrivers\\chromedriver-v2.36-win32.exe";

	// Gecko Driver File Path
	public static final String GECKO_DRIVER = System.getProperty("user.dir")
			+ "\\BrowserDrivers\\geckodriver-v0.20.0-win64.exe";

	// Excel Reader File Path
	public static final String EXCEL_READER = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\dgsl\\freecrm\\util\\Excel_Reader.java";

	// Test Data File Path
	public static final String TEST_DATA = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\dgsl\\freecrm\\testdata\\DealsData.xlsx";

	// Extent Config File Path
	public static final String EXTENT_CONFIG = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\dgsl\\freecrm\\config\\extent-config.xml";

	// Screenshot path
	public static final String SCRRENSHOT_PATH = System.getProperty("user.dir") + "\\Screenshot\\";

	// Extent Report path
	public static final String EXTENT_REPORT_PATH = System.getProperty("user.dir")
			+ "\\extent-report\\FreeCRMReport.html";
	// + LocalDateTime.now() + ".html";

}
