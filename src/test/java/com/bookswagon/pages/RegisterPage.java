package com.bookswagon.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"ctl00_lblUser\"]")
    WebElement MyAccountButton;
    
    @FindBy(xpath = "/html/body/form/div[10]/div/div/div/div/div[2]/div[1]/div[4]/div/a")
    WebElement NewUserButton;
    
    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_txtName']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_txtEmail']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_btnContinue']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_txtPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_txtConfirmPwd']")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//a[@id='ctl00_phBody_SignUp_btnSubmit']")
    WebElement signUpButton;

    public void navigateToURL(String url) {
		driver.get(url);
	}
    public void goToMyAccountButton() {
		MyAccountButton.click();
    }
    
    public void goToNewUserButton() {
		NewUserButton.click();
    }

    
    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
        phoneNumberInput.sendKeys(phoneNumber);
        Thread.sleep(30000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void clickContinueButton() throws InterruptedException {
        continueButton.click();
        
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

}
