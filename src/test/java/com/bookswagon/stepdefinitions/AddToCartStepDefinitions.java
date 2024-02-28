package com.bookswagon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bookswagon.pages.AddToCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDefinitions {

	private static final Logger logger = LogManager.getLogger(AddToCartStepDefinitions.class);
	

	private SharedSteps sp;
	private AddToCartPage page;
	public AddToCartStepDefinitions(SharedSteps sp) {
		this.sp=sp;
		this.page=new AddToCartPage(sp.getDriver());
	}
	
	@Given("user navigates home page")
	public void user_navigates_to_the_home_page() {
		logger.info("user navigates to the home page");
		
		try {
			page.navigateToURL("https://www.bookswagon.com/");
			
        } catch (Exception ex) {
            Assert.fail("Unable to open browser");
        }
	}
	


	@When("user enters {string}")
	public void user_enters(String product) { 
		logger.info("user enters product"+product);
		
		try {
			page.type_product(product);
        } catch (Exception ex) {
            Assert.fail("Unable to give input");
        }
	}
	

	@When("user clicks on Go to cart")
	public void user_clicks_on_go_to_cart() {
		logger.info("user clicks on Go to cart");
		
		try {
			page.clicksOncart();
			
        } catch (Exception ex) {
            Assert.fail("Unable to click Go to cart");
        }
	}
	

	@Then("user clicks on add to cart")
	public void user_clicks_on_add_to_cart() {
		logger.info("user clicks on add to cart");
	
		try {
			page.addToCart();
			
        } catch (Exception ex) {
            Assert.fail("Unable to click add to cart");
        }
	}
	
	@Then("user adds the quantity")
	public void user_adds_the_quantity() {
		logger.info("user adds the quantity");
		
		try {
			page.addQuantity();
			
        } catch (Exception ex) {
            Assert.fail("Unable to adds the quantity");
        }
	    
	}

	@Then("user reduce the quantity")
	public void user_reduce_the_quantity() {
       logger.info("user reduce the quantity");
		
		try {
			page.reduceQuantity();
			
        } catch (Exception ex) {
            Assert.fail("Unable to reduce the quantity");
        }
	}

	@When("user remove the product")
	public void user_remove_the_product() {
		logger.info("user remove the product");
		
		try {
			page.removeProduct();
			
        } catch (Exception ex) {
            Assert.fail("Unable to remove the product");
        }
	}

	

	@Then("message should be displayed")
	public void message_should_be_displayed() {
       logger.info("message should be displayed");
		
		try {
			page.validateResults();
			
        } catch (Exception ex) {
            Assert.fail("Message shouldn't be displayed");
        }
	}
}
