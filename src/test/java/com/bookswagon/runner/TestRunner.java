package com.bookswagon.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com/bookswagon/stepdefinitions"},
    plugin = {"pretty",
			"html:target/myreport.html" ,
            "json:target/json-report/cucumber.json"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
