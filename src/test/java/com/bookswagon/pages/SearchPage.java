package com.bookswagon.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	private final WebDriver driver;
	JavascriptExecutor js;
		@FindBy(id = "inputbar")
		private WebElement search;
	
	
		@FindBy(xpath  = "//*[@id=\"btnTopSearch\"]")
		private WebElement searchbutton;

		@FindBy(xpath= "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a")
		private WebElement bytitle;

		@FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[2]/a")
		private WebElement  price;

		@FindBy(xpath= "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[3]/li[2]/a")
		private WebElement discount;
		
		@FindBy(xpath= "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[5]/li[1]/a/span")
		private WebElement shipping;

		@FindBy(xpath="//*[@id=\"listSearchResult\"]/div[1]")
		WebElement listofBooks;
		
		@FindBy(xpath="//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[4]/li[2]/a")
		WebElement availability;

		public SearchPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			this.js=(JavascriptExecutor) driver;
		}
		
		
		public void navigateToUrl(String url) {
			driver.get(url);
		}
		
		public void search(String content) {
			search.sendKeys(content);
			
			
		}
		public void clicksOnSearchButton() {
			searchbutton.click();
		}
		public void bytitle() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bytitle.click();
			
		}
		public void price() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			price.click();
		}
		public void discount() {
			js.executeScript("window.scrollBy(0,100)");
			discount.click();
		}
		public void shipping() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        js.executeScript("window.scrollBy(0, 500)");
			shipping.click();
		}
		public void viewListOfBooks() {
			assertTrue(listofBooks.isDisplayed());
		}
			
			
			

	}