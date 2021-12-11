package com.dgsl.freecrm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dgsl.freecrm.base.TestBase;
import com.dgsl.freecrm.pages.DealsPage;
import com.dgsl.freecrm.pages.HomePage;
import com.dgsl.freecrm.util.WebEventListener;

@Listeners(WebEventListener.class)
public class HomePageTest extends TestBase {

	@Test
	public DealsPage clickOnDealsLink() {
		DealsPage dealsPage = page.getInstance(HomePage.class).clickOnDealsLink();
		String dealsheader = dealsPage.getDealsPageHeader();
		Assert.assertEquals(dealsheader, "Deals");
		return dealsPage;
	}

}
