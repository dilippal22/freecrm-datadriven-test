package com.dgsl.freecrm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dgsl.freecrm.base.TestBase;
import com.dgsl.freecrm.pages.LoginPage;
import com.dgsl.freecrm.pages.WelcomePage;
import com.dgsl.freecrm.util.WebEventListener;

@Listeners(WebEventListener.class)
public class WelcomePageTest extends TestBase {

	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void verifyWelcomePageTitleTest() {
		String welcomeTitle = page.getInstance(WelcomePage.class).getWelcomePageTitle();
		Assert.assertEquals(welcomeTitle, "#1 Free CRM software for any business - FreeCRM.com",
				"Failed: Mismatch Welcome Page Title Test");
	}

	@Test(priority = 2, groups = { "Sanity", "Regression" })
	public void verifyWelcomePageHeaderTest() {
		String welcomeHeader = page.getInstance(WelcomePage.class).getWelcomePageHeader();
		Assert.assertEquals(welcomeHeader, "#1 Free CRM software for any business",
				"Failed: Mismatch Welcome Page Header Test");
	}

	@Test(priority = 3, groups = { "Smoke", "Sanity" })
	public LoginPage doClickOnLoginLinkTest() {
		LoginPage loginPage = page.getInstance(WelcomePage.class).clickOnLoginLink();
		String loginHeader = loginPage.getLoginPageHeader();
		Assert.assertEquals(loginHeader, "No Account? Registration takes only a few seconds? ",
				"Failed: Mismatch Login Page Title Test");
		return loginPage;
	}

}
