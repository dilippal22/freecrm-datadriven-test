package com.dgsl.freecrm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dgsl.freecrm.base.TestBase;
import com.dgsl.freecrm.pages.HomePage;
import com.dgsl.freecrm.pages.LoginPage;
import com.dgsl.freecrm.util.WebEventListener;

@Listeners(WebEventListener.class)
public class LoginPageTest extends TestBase {

	@Test(priority = 1, groups = { "Sanity", "Regression" })
	public void verifyLoginPageTitleTest() {
		String loginTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		Assert.assertEquals(loginTitle, "CRM", "Failed: Mismatch Login Page Title Test");
	}

	@Parameters(value = { "email", "password" })
	@Test(priority = 2, groups = { "Smoke", "Sanity" })
	public void verifyLoginIntoApplicationTest(String email, String password) {
		HomePage homePage = page.getInstance(LoginPage.class).validLoginIntoApplication(email, password);
		String homeHeader = homePage.getHomePageHeader();
		Assert.assertEquals(homeHeader, "COGMENTO", "Failed: Mismatch Home Page Header Test");
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" })
	public void verifyLoginIntoApplicationTest() {
		String invalidLoginError = page.getInstance(LoginPage.class).invalidLoginIntoApplication();
		Assert.assertEquals(invalidLoginError, "Something went wrong...",
				"Failed: Mismatch Invalid Login Error Message Test");
	}

}
