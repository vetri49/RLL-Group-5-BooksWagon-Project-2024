package com.bookswagon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bookswagon.pages.AddToCartPage;
import com.bookswagon.pages.RegisterPage;
import com.bookswagon.utilities.Listener;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {
	
	SharedSteps sp;
	RegisterPage page;
	
	private static final Logger logger = LogManager.getLogger(LoginStepDefinitions.class);
	
	
	public RegisterStepDefinition(SharedSteps sp) {
		this.sp=sp;
		this.page=new RegisterPage(sp.getDriver());
		
		
	}
	@Given("hit the URL of bookswagon website")
	public void hit_the_url_of_bookswagon_website() {
		logger.info("hit the URL of bookswagon website");
	  page.navigateToURL("https://www.bookswagon.com");   
	}
	

	@Then("user open the myaccount option")
	public void user_open_the_myaccount_option() {
		logger.info("user open the myaccount option");
	  page.goToMyAccountButton();
	}

	@Then("user clicks on new user option")
	public void user_clicks_on_new_user_option() {
		logger.info("user clicks on new user option");
	    page.goToNewUserButton();
	}

	@When("user enters full name as {string}")
	public void user_enters_full_name_as(String name) {
		logger.info("user enters full name as "+name);
	    page.enterName(name);
	}

	@When("user enters phone no as {string}")
	public void user_enters_phone_no_as(String mobile) throws InterruptedException {
		logger.info("user enters phone no as "+mobile);
	  page.enterPhoneNumber(mobile);
	}

	@Then("user clicks on continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		logger.info("user clicks on continue button");
	    page.clickContinueButton();
	}

	@When("user enter password as {string}")
	public void user_enter_password_as(String password) {
		logger.info("user enter password as "+password);
	    page.enterPassword(password);
	}

	@When("user enter confirm-password as {string}")
	public void user_enter_confirm_password_as(String password) {
		logger.info("user enter confirm-password as "+password);
	    page.enterConfirmPassword(password);
	}

	@When("the User press on the register button")
	public void the_user_press_on_the_register_button() {
		logger.info("the User press on the register button");
	    page.clickSignUpButton();
	}

}
