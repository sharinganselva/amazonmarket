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
		  
		// Comment this try block to run locally that shows browser UI   
		// try { driver = new RemoteWebDriver(new URL(hostURL), opt); }
		// catch(MalformedURLException e) { e.printStackTrace(); }
		 		 	
		// Comment these two lines and uncomment the above try block to run against docker container using remote web driver. 
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
