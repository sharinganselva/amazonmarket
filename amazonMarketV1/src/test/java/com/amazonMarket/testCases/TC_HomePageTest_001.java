package com.amazonMarket.testCases;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazonMarket.pageObjects.HomePage;
import com.amazonMarket.pageObjects.ItemPage;
import com.amazonMarket.pageObjects.SearchResultsPage;


public class TC_HomePageTest_001 extends BaseClass 
{
	@Test
	public void HamburgerMenuTest()
	{		
		driver.get(baseURL);
		logger.info("url opened: " + baseURL);
		
		HomePage home_page = new HomePage(driver);

		// Select Television category 
		home_page.clickOnHamburgerMenu();
		home_page.clickOnTopCategory(home_page.TV_APPL_ELECTRONICS_UNDER_TOP_CATEGORY);
		home_page.clickOnSubCategory(home_page.TV_UNDER_SUB_CATEGORY);
		logger.info("Search Results page is displayed");
		
		// Select Samsung checkbox under the Brands section 
		SearchResultsPage search_page = home_page.selectAspectValue("Brands", "Samsung");
		search_page.sortByHighToLow();
		logger.info("Samsung TV under Brands section is filtered in the search result");
		
		// Click on the second result
		ItemPage item_page = search_page.clickNthResult(2);
		logger.info("Secind item in the search result is selected which opened a new tab to display that item page");
		
		// 'About this item' section validation
		Assert.assertTrue(item_page.verifyAboutItemDisplayed(), "Verify if About the Item section is visible");
		logger.info("About this Item section is displayed ");
	}
}
