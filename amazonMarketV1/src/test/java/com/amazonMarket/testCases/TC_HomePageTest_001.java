package com.amazonMarket.testCases;

import org.testng.annotations.Test;
import com.amazonMarket.pageObjects.HomePage;


public class TC_HomePageTest_001 extends BaseClass 
{
	@Test
	public void HamburgerMenuTest()
	{
		driver.get(baseURL);
		logger.info("url opened: " + baseURL);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnHamburgerMenu();
	}
}