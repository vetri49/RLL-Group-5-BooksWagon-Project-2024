package com.bookswagon.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(xpath = "//span[@id='ctl00_lblUser']")
	WebElement myaccount;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement password;

	@FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//label[@id='ctl00_phBody_SignIn_lblemailmsg']")
    WebElement wrongUsernameErrorMessage;

    @FindBy(xpath="//label[@id='ctl00_phBody_SignIn_lblmsg']")
    WebElement wrongPasswordErrorMessage;
	
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void MyAccount() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    myaccount.click();

	}

	public void EntermobileNumber(String mobileNumber1) {
		mobileNumber.sendKeys(mobileNumber1);
	}

	public void EnterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void ClickOnLoginButton() {
		loginButton.click();
	}

    public void getWrongPasswordErrorMessage() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	String expectedErrorMessage = "Please enter correct Password.";
		String actualErrorMessage =wrongPasswordErrorMessage.getText();
		try {
		        assertEquals(expectedErrorMessage, actualErrorMessage);
		}catch(AssertionError e) {
			e.printStackTrace();
		}
    }
    
  
	public void navigateToURL(String url) {
		driver.get(url);
	}
	public void successfulLogin() {
		System.out.println(myaccount.getText());
		assertEquals("Naveen N K",myaccount.getText());
	}

}
