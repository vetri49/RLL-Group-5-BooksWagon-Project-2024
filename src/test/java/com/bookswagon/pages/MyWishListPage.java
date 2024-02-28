package com.bookswagon.pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MyWishListPage {

	WebDriver driver;

	@FindBy(xpath = "//span[@id='ctl00_lblUser']")
	WebElement myaccount;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement phone;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement password;

	@FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@href='wishlist.aspx']")
	WebElement MyWishlist;

	@FindBy(xpath = "//input[@id='inputbar']")
	WebElement SearchBar;

	@FindBy(xpath = "//input[@id='btnTopSearch']")
	WebElement SearchIcon;

	@FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[1]/div[4]/div[4]/input[2]")
	WebElement AddtoWishist;
	
	@FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[2]/div[4]/div[4]/input[2]")
	WebElement AddtoWishist2;
	

	@FindBy(xpath= "//*[@id=\"ctl00_lblUser\"]")
	WebElement DemoUser;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_WishList_lvWishList_ctrl0_ImageButton1\"]")
	WebElement RemoveOption;
	
	@FindBy(xpath= "//*[@id=\"ctl00_phBody_WishList_lvWishList_chkAll\"]")
	WebElement Selectall_checkbox;
	
	@FindBy(id= "ctl00_phBody_WishList_lvWishList_imgDelete")
	WebElement RemoveButton;
	
	@FindBy(xpath="//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[2]/div/div[3]/ul/li")
	WebElement wishList;
	

	@FindBy(xpath="//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[2]/div/div[3]")
	WebElement emptywishList;
	
	public MyWishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public void MyAccount() {
		myaccount.click();

	}

	public void EnterPhone(String userPhone) {
		phone.sendKeys(userPhone);
	}

	public void EnterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void ClickOnLoginButton() {
		loginButton.click();
	}
	
	public void click_MyWishlist() {
		MyWishlist.click();
	}
	
	public void type_product(String samplebook) {
		SearchBar.sendKeys(samplebook);	
		SearchIcon.click();
    }
	
	public void click_AddWishlist() {
	AddtoWishist.click();
	}
	
	public void click_AddWishlist2() {
    AddtoWishist2.click();
	}
	
	public void click_demouser() {
	DemoUser.click();
	}
	
	public void click_Remove() {
	RemoveOption.click();
	}
	
	public void click_selectall() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
	Selectall_checkbox.click();
	}
	
	public void click_removebutton() {
	RemoveButton.click();
	}
	public void displayWishList() {
		assertTrue(wishList.isDisplayed());
	}
	public void assertResults(String result) {
		assertEquals(result,emptywishList.getText());
	}

	
	
}
