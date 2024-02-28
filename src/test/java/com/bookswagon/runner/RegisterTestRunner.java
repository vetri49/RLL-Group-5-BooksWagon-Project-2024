package com.bookswagon.runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
    features = "src/test/resources/Features/PersonalSettings.feature",
    glue = {"com/bookswagon/stepdefinitions"}
    
		)
public class RegisterTestRunner extends AbstractTestNGCucumberTests {

}
