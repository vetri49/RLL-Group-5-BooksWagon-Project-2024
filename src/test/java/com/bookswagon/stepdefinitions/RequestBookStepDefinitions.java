package com.bookswagon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bookswagon.pages.Credentials;
import com.bookswagon.pages.RequestBookPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestBookStepDefinitions {
	
	private SharedSteps sp;
	private RequestBookPage page;
	private Credentials cred;
	private static final Logger logger = LogManager.getLogger(LoginStepDefinitions.class);
	
	
	public RequestBookStepDefinitions(SharedSteps sp) {
		super();
		this.sp = sp;
		this.page = new RequestBookPage(sp.getDriver());
		this.cred=new Credentials();
	}

	@Given("I want to Open a website in browser")
	public void i_want_to_open_a_website_in_browser() {
		logger.info("I want to Open a website in browser");
	    page.navigateToURL("https://www.bookswagon.com");
	}

	@Given("clicks on request book")
	public void clicks_on_request_book() {
		logger.info("clicks on request book");
	    page.click_RequestBook();
	}

	@When("enter a ISBN13 number {string}")
	public void enter_a_isbn13_number(String string) {
		logger.info("enter a ISBN13 number"+string);
	    page.enter_details(string);
	}

	@When("enter a book title {string}")
	public void enter_a_book_title(String title) {
		logger.info("enter a book title"+title);
	   page.enterBookTitle(title);
	}

	@When("enter and verify your mailid")
	public void enter_and_verify_your_mailid() throws InterruptedException {
		logger.info("enter and verify your mailid");
	    page.enterEmail(cred.getEmail());
	    page.verifyEmail();
	}

	@Then("submit the request")
	public void submit_the_request() {
		logger.info("submit the request");
	    page.click_submit();
	}

	@Then("check the results")
	public void check_the_results() {
		logger.info("check the results");
	    page.verifyResult();
	}

	

}
