package com.bookswagon.stepdefinitions;


import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.Logger;

import com.bookswagon.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinitions {

     private static final Logger logger = LogManager.getLogger(SearchStepDefinitions.class);
	
	SharedSteps sp;
	SearchPage page;


	public SearchStepDefinitions(SharedSteps sp) {
		this.sp=sp;
		this.page=new SearchPage(sp.getDriver());

		
	}

	@Given("user navigates to the book website")
	public void user_navigates_to_the_book_website() {
		logger.info("T am on Book website page");
	   page.navigateToUrl("https://www.bookswagon.com");
	    
	}

	@When("user clicks on search bar and enter the {string}")
	public void user_clicks_on_search_bar_and_enter_the(String title) {
		 
	    logger.info("user clicks on search bar and enter the "+title);
	    page.search(title);
	    
		    }

	
	@When("user click on search button")
	public void user_click_on_button() {
		logger.info("T click on search button");
		page.clicksOnSearchButton();
		
	    
	}
	@When("user refine your search based on title on the books")
	public void user_refine_your_search_based_on_title_on_the_books() {
		logger.info("I click on the title on the books");
		page.bytitle();
	
	}
	@When("user refine your search based on price on the books")
	public void user_refine_your_search_based_on_price_on_the_books() {
		logger.info("I click on the price on the books");
		page.price();
	    
	}
	
	@When("user refine your search based on shipping on the books")
	public void user_refine_your_search_based_on_shipping_on_the_books() {
		logger.info("I click on the shipping on the books");
		//page.shipping();
	}
	
	@Then("user see list of the books")
	public void user_see_list_of_the_books() {
		logger.info(" List of the books ");
		page.viewListOfBooks();
	}
	
}