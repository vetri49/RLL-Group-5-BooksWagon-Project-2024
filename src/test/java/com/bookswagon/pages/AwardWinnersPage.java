package com.bookswagon.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AwardWinnersPage {
	
	  public  WebDriver driver;
		
	    public AwardWinnersPage(WebDriver driver){  // constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	    }
		
	    //WebElements Locators
		@FindBy(xpath="//a[text()='Award Winners']")
		private WebElement AwardWinnersField;
		
		@FindBy(xpath="//a[normalize-space()='Paper Back']")
		private WebElement CheckboxPaperBack;
		
		@FindBy(xpath="//select[@id='ddlSort']")
		private WebElement Dropdown;
		
		@FindBy(xpath="//option[@value='Ranking asc']")
		private WebElement LowToHigh;
		
		@FindBy(xpath="//option[@value='Product_ActualPrice desc']")
		private WebElement HighToLow;
		
		@FindBy(xpath="//option[@value='Product_discount desc']")
		private WebElement Discount;
		
		@FindBy(xpath="//a[normalize-space()='English']")
		private WebElement CheckboxEnglish;
		
		@FindBy(xpath="//img[@alt='How to Write a Mystery']")
		private WebElement Product;
		
		@FindBy(xpath="//a[@id='btnAddtocart']")
		private WebElement AddToCart;
		
		public void navigateToURL(String url) {
			driver.get(url);
		}
		
		//Action Methods
		public void ClickAwardWinnersField() {
			AwardWinnersField.click();
		}
		
		public void ClickCheckboxPaperBack() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			CheckboxPaperBack.click();
		}
		
		public void ClickDropdown() {
			Dropdown.click();
		}
		
		public void ClickLowToHigh() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			LowToHigh.click();
		}
		
		public void ClickHighToLow() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			HighToLow.click();
		}
		
		public void ClickDiscount() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Discount.click();
		}
		
		public void ClickCheckboxEnglish() {
			CheckboxEnglish.click();
		}
		
		public void ClickProduct() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Product.click();
		}
		
		public void ClickAddToCart() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			AddToCart.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		public void validateaddtoCart() {
			
		}

		public void ValidatePage() {
			String title= "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
		    assertEquals(driver.getTitle(), title);
		    //Assert.assertTrue(false);
		}
		
		public void ValidateHighToLow(String title1) {
			assertEquals(driver.getTitle(), title1);
		}
		
		public void ValidateAddToCart(String title2) {
			assertEquals(driver.getTitle(), title2);
		}
	}