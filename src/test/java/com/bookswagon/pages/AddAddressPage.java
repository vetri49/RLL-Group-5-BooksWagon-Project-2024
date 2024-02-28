package com.bookswagon.pages;

import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddAddressPage {

	    WebDriver driver;

	    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div[1]/div/div[3]/ul/li[1]/a/span[1]/img")
	    WebElement myaccount;

	    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	    WebElement phone;

	    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	    WebElement password;

	    @FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
	    WebElement loginButton;

	    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[5]/div/a/img")
	    WebElement My_Address;

	    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[2]/div/a")
	    WebElement Add_Address;
	    
	    @FindBy(id = "ctl00_phBody_ShippingAddress_txtRecipientName")
	    WebElement FullName;

	    @FindBy(id = "ctl00_phBody_ShippingAddress_txtAddress")
	    WebElement StreetAddress;

	    @FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlCountry']")
	    WebElement country;

	    @FindBy(xpath = "(//option[contains(text(),'India')])[1]")
	    WebElement selectCountrydrop;

	    @FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlState']")
	    WebElement state;

	    @FindBy(xpath = "(//option[contains(text(),'Tamil Nadu')])[1]")
	    WebElement selectStatedrop;

	    @FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlCities']")
	    WebElement city;

	    @FindBy(xpath = "(//option[contains(text(),'Chennai')])[1]")
	    WebElement selectCitydrop;

	    @FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_txtPincode']")
	    WebElement pin_code;

	    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ShippingAddress_txtMobile\"]")
	    WebElement mobile;

	    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ShippingAddress_imgSubmit\"]")
	    WebElement save;

	 // Additional WebElement variables for Edit and Remove Address
	    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[2]/div[1]/div[3]/a[1]")
	    WebElement editAddressLink;

	    @FindBy(xpath = "//button[@id='confirmRemovalButton']")
	    WebElement confirmRemovalButton;

	    @FindBy(xpath = "//*[@id=\"ctl00_phBody_AddressList_lvCustomerAdd_ctrl0_ctl00_imgDeleteShipAdd\"]")
	    WebElement removeAddressLink;


	    public AddAddressPage(WebDriver driver) {
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

	    
	   public void click_MyAddress() {
	        myaccount.click();
		   My_Address.click();
	    }

	    public void click_AddAddress() {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        Add_Address.click();
	    }

	    public void Enterfullname(String name) {
	        FullName.click();
	        FullName.sendKeys(name);
	    }

	    public void EnterStreetAddress(String Address) {
	        StreetAddress.click();
	        StreetAddress.sendKeys(Address);
	    }

	    public void EnterCountry() {
	        country.click();
	        selectCountrydrop.click();
	    }

	    public void EnterState() {
	        state.click();
	        selectStatedrop.click();
	    }

	    
		public void EnterCity()  {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        city.click();
	        
	        selectCitydrop.click();
	    }

	    public void EnterPinCode(String Pincode) {
	        pin_code.click();
	        pin_code.sendKeys(Pincode);
	    }

	    public void EnterPhone1(String Phone) {
	        mobile.click();
	        mobile.sendKeys(Phone);
	    }

	    public void ClickUpdate() 
	    {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        save.click();
	    }

	    public void clickEditAddress() {
	        editAddressLink.click();
	    }

	    

	    public void clickRemoveAddress() throws InterruptedException {
	    	
	        removeAddressLink.click();
	        Thread.sleep(3000);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	    public void modifyStreetAddress(String address) {
	    	StreetAddress.clear();
	    	StreetAddress.sendKeys(address);
	    }
        public void modifyPhoneNumber(String mobileno) {
        	mobile.clear();
        	mobile.sendKeys(mobileno);
        }
        public void modifyPincode(String pin) {
        	pin_code.clear();
        	pin_code.sendKeys(pin);
        }
}
