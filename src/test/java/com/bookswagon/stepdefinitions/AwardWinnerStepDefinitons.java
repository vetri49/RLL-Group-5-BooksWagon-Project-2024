package com.bookswagon.stepdefinitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.bookswagon.pages.AwardWinnersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AwardWinnerStepDefinitons{
	AwardWinnersPage page;
	SharedSteps sp;
	private static  Logger logger=LogManager.getLogger("AwardWinnerStepDefinitons.class");
	
	public AwardWinnerStepDefinitons(SharedSteps sp) {
		this.sp=sp;
		this.page=new AwardWinnersPage(sp.getDriver());
	}
	
	@Given("User launches the chrome browser")
	public void user_launches_the_chrome_browser() {
		logger.info("User launches the chrome browser");
		
		
	}

	@When("User enters the URL {string}")
	public void user_enters_the_url(String url) {
		page.navigateToURL(url);
		logger.info("URL:" +url);
		
	}	

	@When("User clicks on the Award winners field")
	public void user_clicks_on_the_award_winners_field()  {
		try {
	    page.ClickAwardWinnersField();
	    
	    logger.info("User clicked on the Award winners field");
	    
		}catch (Exception e) {
		logger.error("Exception Object :: " + e.toString());
		logger.error("End Exception :: "+e.getLocalizedMessage());
			}
	}

	

	@When("User clicks on the checkbox of Paper Back")
	public void user_clicks_on_the_checkbox_of_paper_back()   {
		try {
	    page.ClickCheckboxPaperBack();
	   
	    logger.info("User clicked on the checkbox of Paper Back");
	    
		}catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}

	

	@When("User unchecks the Paper Back")
	public void user_unchecks_the_paper_back()   {
	    try {
		page.ClickCheckboxPaperBack();
		
	    logger.info("User unchecked the Paper Back");
	    
	    }catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}

	@When("User clicks on Dropdown")
	public void user_clicks_on_dropdown()   {
	   try {
		page.ClickDropdown();
	   
	    logger.info("User clicked on Dropdown");
	    
	   }catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}

	@When("User clicks on Low to High")
	public void user_clicks_on_low_to_high()   {
		try {
	    page.ClickLowToHigh();
	   
	    logger.info("User clicked on Low to High");
	    
		}catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}

	

	@When("User clicks on High to Low")
	public void user_clicks_on_high_to_low()   {
	    try {
		page.ClickHighToLow();
	   
	    logger.info("User clicked on High to Low");
	    
	    }catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}

	
	
	@When("User clicks on Discount")
	public void user_clicks_on_discount() throws InterruptedException {
		try {
		page.ClickDiscount();
		
		logger.info("User clicked on Discount");
		
		}catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}

	@When("User clicks the product and adds to cart")
	public void user_clicks_the_product_and_adds_to_cart()   {
	    try {
		page.ClickProduct();
		
	    page.ClickAddToCart();
	   
	    logger.info("User clicked on product and adds to cart");
	    
	    }catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}
	
    @Then("User validates the Page")
	public void user_validates_the_page()   {
		try {
		page.ValidatePage();
	    
	    logger.info("Page has been validated");
	    
		}catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}

   @Then("User validates the sorted page after clicking to Paper Back")
	public void user_validates_the_sorted_page_after_clicking_to_paper_back()   {
		try {
			page.ValidatePage();
	    
	    logger.info("Page has been validated");
	    
		}catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}
    @Then("User validates the sorted page after clicking to Low to High")
	public void user_validates_the_sorted_page_after_clicking_to_low_to_high()   {
		try {
		page.ValidatePage();
	    
	    logger.info("Page has been validated");
	    
		}catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}
 @Then("^User validates the \"([^\"]*)\" of the page$")
	public void user_validates_the_title_of_the_page(String title1)   {
		try {
	    page.ValidateHighToLow(title1);
	    
	    logger.info("Page has been validated");
	    
		}catch (Exception e) {
			logger.error("Exception Object :: " + e.toString());
			logger.error("End Exception :: "+e.getLocalizedMessage());
				}
		}
    @Then("^User validates the add to cart \"(.*)\" of the page$")
	public void user_validates_the_add_to_cart_of_the_page(String title2) throws InterruptedException {
		try {
	    page.ValidateAddToCart(title2);
	   
	    logger.info("Page has been validated");
	    
		 }catch (Exception e) {
				logger.error("Exception Object :: " + e.toString());
				logger.error("End Exception :: "+e.getLocalizedMessage());
				
					}
		}
}






















