package com.bookswagon.pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalSettingsPage {
	
	public WebDriver driver;

	@FindBy(xpath="//input[@id='ctl00_phBody_SignIn_txtEmail']")
	 private WebElement username;
	 
	 @FindBy(xpath="//input[@id='ctl00_phBody_SignIn_txtPassword']")
	 private WebElement Password;
	 
	 @FindBy(xpath="//a[@id='ctl00_phBody_SignIn_btnLogin']")
	 private WebElement LoginButton;
	 
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[1]/div/div[3]/ul/li[1]/a/span[1]/img")
	private WebElement Myaccount_Click;
	
	@FindBy(xpath="//*[@id=\"ctl00_lblUser\"]")
	private WebElement Account;
	
	@FindBy(xpath="//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[1]/div/a/img")
	WebElement personalSetting;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_AccountSetting_fvCustomer_txtLName\"]")
	WebElement lastName;

	@FindBy(xpath="//*[@id=\"ctl00_phBody_AccountSetting_fvCustomer_txtemail\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_AccountSetting_fvCustomer_txtProfileName\"]")
	WebElement profileName;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_AccountSetting_fvCustomer_txtMobile\"]")
	WebElement MobileNumber;
	
	@FindBy(xpath="//*[@id=\"recaptcha-anchor-label\"]")
	WebElement captcha;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_AccountSetting_fvCustomer_imgUpdate\"]")
	WebElement updateButton;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_AccountSetting_fvCustomer_btnOTP\"]")
	WebElement verifyButton;
	
	 public PersonalSettingsPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);	
			
		}
	 
	 public void navigateToUrl(String URL) {
		 driver.get(URL);
	 }
	 public void click_MyAccount() {
		 Myaccount_Click.click();
	 
	 }
	 public void click_Login(String MobileNumber,String password) {
		 
		username.sendKeys(MobileNumber);
		 Password.sendKeys(password);
	 }
	 
	 
	 public void click_Loginbutton() {
		 LoginButton.click();
	 }
		 
     public void click_Account() throws InterruptedException {
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(Account).click().perform();
    	 Thread.sleep(1000);

    	 
     }
	 public void click_PersonalSetting() {
		 personalSetting.click();
		 
		
	 }
		
		public void click_Email(String Email) {
			lastName.clear();
			lastName.sendKeys("Basuvaraj");
			email.clear();
			email.sendKeys(Email);
			
		}
		
		public void click_Profilename() {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500)");
			
			
			
			
		}
			
			public void Click_Mobilenumber(String Mobilenumber) {
				MobileNumber.clear();
				MobileNumber.sendKeys(Mobilenumber);
				
			}
				
				public void Captcha_click( ) throws InterruptedException {
					Thread.sleep(30000);
				
			}
			
			public void Click_update() {
				updateButton.click();
	
			}
			public void click_Verify(){
				
			}

			public void validate_Update_Scenario(String Email) {
				String expectResult=Account.getText();
				String ActualResult="Jaya Basuvaraj";
				System.out.println(expectResult);
				assertEquals(expectResult,ActualResult);
			}

}

