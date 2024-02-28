package com.bookswagon.stepdefinitions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import com.bookswagon.utilities.Listener;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SharedSteps {
	
	WebDriver driver;
	
	public SharedSteps() {
		
	}
	
	 public WebDriver getDriver() {
	        return driver;
	    }

	    @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
	        driver = new ChromeDriver();
	         driver.manage().window().maximize();
	         Listener.setDriver(driver);
	               
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	        	driver.close();
	        }
	    }
}
