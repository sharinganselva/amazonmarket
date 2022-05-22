package com.amazonMarket.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage 
{

	String about_this_item_text_xpath = "//h1[contains(text(), \"About this item\")]";

	WebDriver localDriver;
	WebDriverWait wait;

	public ItemPage(WebDriver remoteDriver) 
	{
		localDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver, Duration.ofSeconds(5));
		PageFactory.initElements(remoteDriver, this);
	}

	public WebElement get_about_this_item_element() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(about_this_item_text_xpath)));
		return this.localDriver.findElement(By.xpath(about_this_item_text_xpath));
	}
	
	public boolean verifyAboutItemDisplayed()
	{
		return get_about_this_item_element().isDisplayed();
	}
}