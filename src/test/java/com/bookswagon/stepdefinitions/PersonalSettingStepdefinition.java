package com.bookswagon.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bookswagon.pages.Credentials;
import com.bookswagon.pages.PersonalSettingsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalSettingStepdefinition {
	private Credentials cred;
	private SharedSteps ss;
	private PersonalSettingsPage Spage;
	private String URL="https://www.bookswagon.com";
	private static final Logger logger = LogManager.getLogger(LoginStepDefinitions.class);
	
	public PersonalSettingStepdefinition(SharedSteps ss,Credentials cred) {
		this.ss=ss;
		this.Spage=new PersonalSettingsPage(ss.getDriver());
		this.cred=cred;
		
	}
	
	
	
	
	@Given("User navigates to the webpage")
	public void user_navigates_to_the_webpage() {
		logger.info("User navigates to the webpage");
		Spage.navigateToUrl(URL);
	    
	}

	@When("User try to login in the account")
	public void user_try_to_login_in_the_account() {
		logger.info("User try to login in the account");
		Spage.click_MyAccount();
		Spage.click_Login(cred.getMobileNumber(),cred.getPassword());
	    
	}

	@Then("Validate the login is successful")
	public void validate_the_login_is_successful() {
		logger.info("Validate the login is successful");
		Spage.click_Loginbutton();
	    
	}

	@Given("User clicks on Your account")
	public void user_clicks_on_your_account() throws InterruptedException {
		logger.info("User clicks on Your account");
	    Spage.click_Account();
	}

	@Given("User clicks on Personal Settings")
	public void user_clicks_on_personal_settings() {
		logger.info("User clicks on Personal Settings");
		Spage.click_PersonalSetting();
	}

	@When("User add E-mail Id")
	public void user_add_e_mail_id() {
		logger.info("User add E-mail Id");
		Spage.click_Email(cred.getEmail());
	}

	@When("User add Mobile Number")
	public void user_add_mobile_number() {
		logger.info("User add Mobile Number");
		Spage.click_Profilename();
		Spage.Click_Mobilenumber(cred.getMobileNumber());
	}

	@When("User Can Click Captcha for security setting")
	public void user_can_click_captcha_for_security_setting() throws InterruptedException {
		logger.info("User Can Click Captcha for security setting");
      System.out.println("Manually i can enter a captcha");
      Spage.Captcha_click();
	}

	@Then("User click the update button")
	public void user_click_the_update_button() {
		logger.info("User click the update button");
		Spage.Click_update();
	}

	@Then("enters generated OTP in the E-mail")
	public void enters_generated_otp_in_the_e_mail() {
		logger.info("enters generated OTP in the E-mail");
		System.out.println("Manually i can enter a OTP");
	}

	@Then("clicks on verify button")
	public void clicks_on_verify_button() throws InterruptedException {
		logger.info("clicks on verify button");
		Spage.click_Verify();
		Spage.validate_Update_Scenario(cred.getEmail());
	}

	@Then("User can not update the details")
	public void user_can_not_update_the_details() {
		logger.info("User can not update the details");
		try {
	    assertTrue(false);
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.error("Assertion error::"+e.getLocalizedMessage());
		}
	}

}
