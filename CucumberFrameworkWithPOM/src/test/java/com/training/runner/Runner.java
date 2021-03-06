package com.training.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
							"json:target/cucumber-reports/cucumber.json" }, 
				 features = {"src/test/resources/com/training/features/FireBaseApp.feature" }, 
				 glue = { "com.training.steps" })

public class Runner extends AbstractTestNGCucumberTests {
	
}
