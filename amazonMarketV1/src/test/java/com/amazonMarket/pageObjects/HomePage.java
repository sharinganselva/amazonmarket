package com.amazonMarket.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver localDriver;
	public HomePage(WebDriver remoteDriver)
	{
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	@FindBy(id="nav-hamburger-menu")
	WebElement hamburgerMenu;
	
	public void clickOnHamburgerMenu()
	{
		hamburgerMenu.click();
	}
	
}