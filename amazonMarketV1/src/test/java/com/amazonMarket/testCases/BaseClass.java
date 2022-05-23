package com.amazonMarket.testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String baseURL = "http://www.amazon.in";
	public String hostURL = "http://localhost:4444/wd/hub";
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{			
		  ChromeOptions opt = new ChromeOptions();
		  
		  try 
		  { 
			  driver = new RemoteWebDriver(new URL(hostURL), opt); 
		  } 
		  catch(MalformedURLException e) 
		  {
			  e.printStackTrace(); 
		  }
		 		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver");
		//driver = new ChromeDriver();		
		logger = LogManager.getLogger(BaseClass.class.getName());		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
