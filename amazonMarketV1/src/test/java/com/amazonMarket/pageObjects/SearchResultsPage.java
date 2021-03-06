package com.amazonMarket.pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage 
{

	String nth_result_xpath = "(//span[@data-component-type=\"s-search-results\"]//div[@data-component-type=\"s-search-result\"][__NTH_RESULT])//span[@data-component-type='s-product-image']";
	String sort_by_drop_down = "//span[@data-component-type=\"s-result-info-bar\"]//span[@data-csa-c-func-deps=\"aui-da-a-dropdown-button\"]";
	String drop_down_option_high_to_low = "//a[@id=\"s-result-sort-select_2\"]";

	WebDriver localDriver;
	WebDriverWait wait;

	public SearchResultsPage(WebDriver remoteDriver) 
	{
		localDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver, Duration.ofSeconds(5));
		PageFactory.initElements(remoteDriver, this);
	}

	public WebElement get_result(int n) 
	{
		String actual_nth_result_xpath = nth_result_xpath.replace("__NTH_RESULT", n + "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(actual_nth_result_xpath)));
		return this.localDriver.findElement(By.xpath(actual_nth_result_xpath));
	}
	
	public WebElement get_dropdown_button()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sort_by_drop_down)));
		return this.localDriver.findElement(By.xpath(sort_by_drop_down));
	}
	
	public WebElement get_high_to_low_dropdown_button()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(drop_down_option_high_to_low)));
		return this.localDriver.findElement(By.xpath(drop_down_option_high_to_low));
	}

	public SearchResultsPage sortByHighToLow()
	{
		this.get_dropdown_button().click();
		this.get_high_to_low_dropdown_button().click();
		return this;
	}
	
	public ItemPage clickNthResult(int result_number) {
		this.get_result(result_number).click();
		Set<String> window_handles = this.localDriver.getWindowHandles();
		Object new_handle = window_handles.toArray()[1];
		String new_handle_name = new_handle.toString();
		localDriver.switchTo().window(new_handle_name);

		return new ItemPage(this.localDriver);

	}
}