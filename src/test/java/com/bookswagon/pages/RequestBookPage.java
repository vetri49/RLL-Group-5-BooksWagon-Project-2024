package com.bookswagon.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestBookPage {
public static WebDriver driver;

	
	@FindBy(xpath = "//span[@id='ctl00_lblUser']")
	WebElement myaccount;

	@FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtEmailReq\"]")
	WebElement email;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement password;

	@FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
	WebElement loginButton;

	@FindBy(linkText = "Request a Book")
	WebElement requestButton;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtISBN']")
	WebElement ISBN;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtTitle']")
	WebElement Title;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtAuthor']")
	WebElement author;
	
	@FindBy(xpath="//*[@id='ctl00_phBody_RequestBook_txtPhone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtQty']")
	WebElement quantity;

	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_imgbtnSave']")
	WebElement Submitbtn;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_RequestBook_btnVeiry\"]")
	WebElement verifyEmail;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_RequestBook_lblsuccessmsg\"]")
	WebElement message;

	public RequestBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void navigateToURL(String url) {
		driver.get(url);
	}

	
	
	
	public void MyAccount() {
		myaccount.click();

	}
	public void EnterEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void EnterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void ClickOnLoginButton() {
		loginButton.click();
	}
	
		

		
		public void click_RequestBook() {		
	    	requestButton.click();
	        
	    }
		public void enter_details(String isbn){
			ISBN.sendKeys(isbn);
			
			
		}
		
		public void enterBookTitle(String title) {
			Title.sendKeys(title);
		}
		public void enterEmail(String Email) throws InterruptedException {
			email.sendKeys(Email);
			Thread.sleep(1000);
		}
		public void verifyEmail() throws InterruptedException {
			verifyEmail.click();
			
		}
		
		public void enterQuantity() {
			quantity.sendKeys("5");
		}
		
		public void click_submit() {
			Submitbtn.click();
		}
		
		
		public void verifyResult() {
			
			assertEquals(message.getText(),"You have requested for this book before.");
			
		}

		
		
}
