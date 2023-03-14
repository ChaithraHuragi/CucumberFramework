package com.tekarch.runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(com.tekarch.utilityforsaleforce.TestEventListners.class)

@CucumberOptions(
		features = {"src/test/resources/FeatureforSalesForce.feature"},
		glue = {"com.tekarch.steps"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber.html"}
		
		)



public class RunnerForSalesForce extends AbstractTestNGCucumberTests{


}
