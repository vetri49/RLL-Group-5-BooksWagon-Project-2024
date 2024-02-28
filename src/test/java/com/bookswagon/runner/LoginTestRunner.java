package com.bookswagon.runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
    features = "src/test/resources/Features/Login.feature",
    glue = {"com/bookswagon/stepdefinitions"}
    
		)
public class LoginTestRunner extends AbstractTestNGCucumberTests {

}
