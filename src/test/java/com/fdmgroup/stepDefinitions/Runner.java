package com.fdmgroup.stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "com.fdmgroup.stepDefinitions",
		tags = "",
		plugin = {
				"pretty",
				"json:reports/cucumber.json",
				"junit:reports/cucumber.junit",
				"html:reports/cucumber.html"
		},
		publish = false
)
public class Runner {

}
