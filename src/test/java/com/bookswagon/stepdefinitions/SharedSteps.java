package com.bookswagon.stepdefinitions;

import java.time.Duration;

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
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	         driver.manage().window().maximize();
	         Listener.setDriver(driver);
	               
	    }

	    @After
	    public void tearDown() {
//	        if (driver != null) {
//	        	driver.quit();	        }
	    }
}
