package com.bookswagon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bookswagon.pages.Credentials;
import com.bookswagon.pages.MyWishListPage;
import com.bookswagon.pages.PersonalSettingsPage;
import com.bookswagon.utilities.Listener;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListStepDefinitions {


	private static final Logger logger = LogManager.getLogger(WishListStepDefinitions.class);
	
	WebDriver driver;
	MyWishListPage lp;
	SharedSteps sp;
	Credentials cred;
	public WishListStepDefinitions(SharedSteps sp) {
		this.sp=sp;
		this.lp=new MyWishListPage(sp.getDriver());
		this.cred=new Credentials();
	}
	
	@Given("the URL of bookswagon website")
	public void the_url_of_bookswagon_website() {
		logger.info("the URL of bookswagon website");
		lp.navigateToURL("https://www.bookswagon.com/");
		
	}

	@Then("click on myaccount option")
	public void click_on_myaccount_option() {
		logger.info("click on myaccount option");
		lp.MyAccount();
	
	}
	
	@When("the User enters phone no")
	public void the_user_enters_phone_no() {
		logger.info("the User enters phone no as {string}");
		lp.EnterPhone(cred.getMobileNumber());
	}

	@When("the User enters password")
	public void the_user_enters_password_as() {
		logger.info("the User enters password");
		lp.EnterPassword(cred.getPassword());
	}

	@When("the User clicked on the login button")
	public void the_user_clicked_on_the_login_button() {
		logger.info("the User clicked on the login button");
		lp.ClickOnLoginButton();
	}
	
	@When("User click on My Wishlist")
	public void user_click_on_my_wishlist() {
		logger.info("User click on My Wishlist");
        lp.click_MyWishlist();
	}

	@When("User search for a book titled {string}")
	public void user_search_for_a_book_titled(String string) {
		logger.info("User search for a book titled {string}");
	    lp.type_product("Ikigai");
	}

	@When("User click on the Add to Wishlist button")
	public void user_click_on_the_add_to_wishlist_button() throws InterruptedException {
		logger.info("User click on the Add to Wishlist button");
        lp.click_AddWishlist();
        Thread.sleep(1000);
        lp.click_AddWishlist2();
        Thread.sleep(1000);
        lp.click_demouser();
        
	}

	@Then("User should see the list of books in my wishlist")
	public void user_should_see_the_list_of_books_in_my_wishlist() throws InterruptedException {
		logger.info("User should see the list of books in my wishlist");
		lp.displayWishList();

	}

	@Then("User can remove a book from my wishlist")
	public void user_can_remove_a_book_from_my_wishlist() throws InterruptedException {
		logger.info("User can remove a book from my wishlist");
		Thread.sleep(2000);
		lp.click_Remove();
		
		
	}

	@Then("User should see a message indicating that my wishlist is empty {string}")
	public void user_should_see_a_message_indicating_that_my_wishlist_is_empty(String result) throws InterruptedException {
		logger.info("User should see a message indicating that my wishlist is empty {string}");
		Thread.sleep(2000);
		lp.click_selectall();
		Thread.sleep(3000);
	    lp.click_removebutton();
	    lp.assertResults(result);
	}

}
