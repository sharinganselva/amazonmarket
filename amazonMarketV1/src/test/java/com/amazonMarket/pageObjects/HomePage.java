package com.amazonMarket.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	String hamburger_xpath = "//header//a[@id='nav-hamburger-menu']/i";
	String top_category_xpath = "//div[@id=\"hmenu-content\"]//*[contains(text(), \"__TOP_CATEGORY\")]";
	String sub_menu_xpath = "//div[@id='hmenu-content']//a[contains(text(), \"__SUB_CATEGORY\")]";
	String aspect_value_xpath = "((((//div[@id='s-refinements']//span[contains(text(), \"__ASPECT_NAME\")]/parent::div)/parent::div)//span[contains(text(), \"__ASPECT_VALUE\")]))";
	String nth_result_xpath = "//span[@data-component-type=\"s-search-results\"]//div[@data-component-type=\"s-search-result\"][__NTH_RESULT]";
	
	public String TV_APPL_ELECTRONICS_UNDER_TOP_CATEGORY = "TV, Appliances, Electronics"; // Ideally should be an enum for all top level categories
	public String TV_UNDER_SUB_CATEGORY = "Televisions"; // Ideally should be an enum for all sub categories

	WebDriver localDriver;
	WebDriverWait wait;

	public HomePage(WebDriver remoteDriver) 
	{
		localDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver, Duration.ofSeconds(5));
		PageFactory.initElements(remoteDriver, this);

	}

	public WebElement get_hamburger_menu() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hamburger_xpath)));
		return this.localDriver.findElement(By.xpath(hamburger_xpath));
	}

	public WebElement get_top_category(String category_name) 
	{
		String actual_category_xpath = top_category_xpath.replace("__TOP_CATEGORY", category_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(actual_category_xpath)));
		return this.localDriver.findElement(By.xpath(actual_category_xpath));
	}

	public WebElement get_sub_category(String sub_category_name) 
	{
		String actual_sub_category_xpath = sub_menu_xpath.replace("__SUB_CATEGORY", sub_category_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(actual_sub_category_xpath)));
		return this.localDriver.findElement(By.xpath(actual_sub_category_xpath));
	}

	public WebElement get_aspect_value(String aspect_name, String aspect_value) 
	{
		String actual_aspect_value_xpath = aspect_value_xpath.replace("__ASPECT_NAME", aspect_name)
				.replace("__ASPECT_VALUE", aspect_value);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(actual_aspect_value_xpath)));
		return this.localDriver.findElement(By.xpath(actual_aspect_value_xpath));
	}

	public HomePage clickOnHamburgerMenu() 
	{
		this.get_hamburger_menu().click();
		return this;
	}

	public HomePage clickOnTopCategory(String categoryName) 
	{
		this.get_top_category(categoryName).click();
		return this;
	}

	public HomePage clickOnSubCategory(String subCategoryName) 
	{
		this.get_top_category(subCategoryName).click();
		return this;
	}

	public SearchResultsPage selectAspectValue(String aspectName, String aspectValue) 
	{
		this.get_aspect_value(aspectName, aspectValue).click();
		return new SearchResultsPage(this.localDriver);
	}
}