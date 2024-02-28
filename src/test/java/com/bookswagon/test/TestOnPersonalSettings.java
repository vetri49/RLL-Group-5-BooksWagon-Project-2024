package com.bookswagon.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bookswagon.pages.Credentials;
import com.bookswagon.pages.PersonalSettingsPage;


public class TestOnPersonalSettings {
	private static final Logger logger = LogManager.getLogger(TestOnPersonalSettings.class);
	WebDriver driver;
	PersonalSettingsPage psPage;
	Credentials cred;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.bookswagon.com");
         this.psPage=new PersonalSettingsPage(driver);
         this.cred=new Credentials();
         
	}
	@AfterTest
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
	@Test(priority=1)
	public void naivigate_to_PersonalSettings_Page() throws InterruptedException  {
		logger.info("Start :: Open the URL in browser is successfully!!!");
		psPage.click_MyAccount();
		psPage.click_Login(cred.getMobileNumber(), cred.getPassword());
		psPage.click_Loginbutton();
		logger.info("Logged in your account successfully");
		
		psPage.click_Account();
		psPage.click_PersonalSetting();
	}
	@Test(priority=2)
	public void UpdateDetails() throws InterruptedException {
		logger.info("I can fill the details successfully");
		psPage.click_Email(cred.getEmail());
		psPage.Click_Mobilenumber(cred.getMobileNumber());
		psPage.click_Profilename();
		psPage.Captcha_click();
		psPage.Click_update();
		logger.info("Personal details updated successfully");
	}
	
	
}
