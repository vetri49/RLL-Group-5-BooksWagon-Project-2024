package com.bookswagon.pages;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	

	private WebDriver driver;
		public AddToCartPage(WebDriver driver) {  
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		
		@FindBy(xpath="//input[@id='inputbar']") 
		private WebElement productinput;
		
		@FindBy(xpath="(//input[@type='button'])[1]")
		private WebElement search;
		
		@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[1]/div/div[3]/ul/li[2]/a/span")
		private WebElement cart;
		
		@FindBy(xpath="//*[@id=\"listSearchResult\"]/div[1]/div[4]/div[5]/input[1]")
		private WebElement addtocart;
		
		@FindBy(xpath="//*[@id=\"ctl00_phBody_BookCart_lvCart_ctrl0_txtQty\"]")
		private WebElement addquantity;
		
		@FindBy(xpath="(//input[@type='button'])[2]")
		private WebElement reducequantity;
		
		@FindBy(linkText="Remove")
		private WebElement 	removebutton;
		
		@FindBy(xpath="//*[@id=\"ctl00_phBody_BookCart_uplnShopping\"]/div[3]/ul/li")
		private WebElement cartItem;
		
		
		
		public void navigateToURL(String url) {   
			driver.get(url);
		}          
		public void type_product(String product) {   
			productinput.sendKeys(product);
					
			search.click();
		}
		public void search_product(String product) {	
			search.click();	
	   }
		public void addToCart() {
			addtocart.click();
			
		}
		public void clicksOncart() {
			cart.click();
		}
		
		public void addQuantity() {
			addquantity.clear();
			addquantity.sendKeys("5");
		}
       public void reduceQuantity() {
    	  
		reducequantity.click();	
    	   
		}
       
       public void removeProduct() {
    	   removebutton.click();
       }
       
       public void validateResults() {
    	   assertTrue(cartItem.isDisplayed());
       }
}
		
	

