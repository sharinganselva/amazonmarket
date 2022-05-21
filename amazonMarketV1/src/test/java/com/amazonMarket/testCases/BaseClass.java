package com.amazonMarket.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String baseURL="http://www.amazon.in";
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver");
		driver = new ChromeDriver();		
		logger = LogManager.getLogger(BaseClass.class.getName());
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}