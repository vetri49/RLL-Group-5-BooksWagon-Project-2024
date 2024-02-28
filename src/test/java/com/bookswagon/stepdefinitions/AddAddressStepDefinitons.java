package com.bookswagon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bookswagon.pages.AddAddressPage;
import com.bookswagon.pages.Credentials;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAddressStepDefinitons {
	private static final Logger logger = LogManager.getLogger(AddAddressStepDefinitons.class);
   private Credentials cred;
	private SharedSteps sp;
	private AddAddressPage page;
	
	public AddAddressStepDefinitons(SharedSteps sp) {
		this.sp=sp;
		this.page=new AddAddressPage(sp.getDriver());
		this.cred=new Credentials();
	}
	
	@Given("the URL bookswagon website")
	public void the_url_bookswagon_website() {
		logger.info("the URL bookswagon website");
	    page.navigateToURL("https://www.bookswagon.com");
	    
	}
	
	@Then("User clicks myaccount")
	public void user_clicks_myaccount() {
		logger.info("User clicks myaccount");
	    page.MyAccount();
	}
	@When("User enters phone no")
	public void user_enters_phone_no() {
		logger.info("User enters phone no");
	    page.EnterPhone(cred.getMobileNumber());
	}

	@When("User enters password")
	public void user_enters_password() {
		logger.info("User enters password");
	    page.EnterPassword(cred.getPassword());
	}

	@When("the User clicks login button")
	public void the_user_clicks_login_button() {
		logger.info("the User clicks login button");
	    page.ClickOnLoginButton();
	}
	@When("User clicks on My Address")
	public void user_clicks_on_my_address() {
		logger.info("User clicks on My Address");
	    page.click_MyAddress();
	}

	@Then("User clicks on Add Address")
	public void user_clicks_on_add_address() {
		logger.info("User clicks on Add Address");
	    page.click_AddAddress();
	}

	@Then("User enters the FullName")
	public void user_enters_the_full_name() {
		logger.info("User enters the FullName");
	    page.Enterfullname("SubaShree");
	}

	@When("User enters the StreetAddress")
	public void user_enters_the_street_address() {
		logger.info("User enters the StreetAddress");
	    page.EnterStreetAddress("No 1,Imperial garden Street,Kazhipattur");
	}

	@Then("User clicks the country dropdown")
	public void user_clicks_the_country_dropdown() {
		logger.info("User clicks the country dropdown");
	    page.EnterCountry();
	}

	@Then("User clicks the state dropdown")
	public void user_clicks_the_state_dropdown() {
		logger.info("User clicks the state dropdown");
	    page.EnterState();
	}

	@Then("User clicks the City dropdown")
	public void user_clicks_the_city_dropdown() throws InterruptedException {
		logger.info("User clicks the City dropdown");
	    page.EnterCity();
	}

	@Then("User enters the Pin code")
	public void user_enters_the_pin_code() {
		logger.info("User enters the Pin code");
	    page.EnterPinCode("649733");
	}

	@Then("User enters the Phone")
	public void user_enters_the_phone() {
		logger.info("User enters the Phone");
	    page.modifyPhoneNumber("94567456782");
	}

	@Then("User clicks Update Option")
	public void user_clicks_update_option() throws InterruptedException {
		logger.info("User clicks Update Option");
	   page.ClickUpdate();
	}

	@Then("User clicks on Edit Address")
	public void user_clicks_on_edit_address() {
		logger.info("User clicks on Edit Address");
	    page.clickEditAddress();
	}

	@When("User modifies the StreetAddress")
	public void user_modifies_the_street_address() {
		logger.info("User modifies the StreetAddress");
		
	    page.modifyStreetAddress("3/402,Padavattamman Kovil Street,Kazhipattur");
	}

	@When("User modifies the Pin code")
	public void user_modifies_the_pin_code() {
		logger.info("User modifies the Pin code");
	    page.modifyPincode("975542");
	}

	@Then("User clicks on remove address")
	public void user_clicks_on_remove_address() throws InterruptedException {
		logger.info("User clicks on remove address");
	    page.clickRemoveAddress();
	}

	@Then("User Confirms the removal of address")
	public void user_confirms_the_removal_of_address() {
		logger.info("User Confirms the removal of address");
	    
	}
	
	

	

	

	
}
