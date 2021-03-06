package com.amazonMarket.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage 
{
	String about_this_item_text_xpath = "//h1[contains(text(), \"About this item\")]";
	String about_this_item_list = "//h1[contains(text(), \"About this item\")]/parent::div//ul[@class=\"a-unordered-list a-vertical a-spacing-mini\"]/li";

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
	
	public String get_about_this_item_section_text()
	{
		String about_item_section_text = "";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(about_this_item_list)));
		List<WebElement> my_list = this.localDriver.findElements(By.xpath(about_this_item_list));
		for (WebElement my_each_list: my_list)
		{
			about_item_section_text = about_item_section_text + my_each_list.getText() + '\n'; 
		}
		
		return about_item_section_text;
	}
}