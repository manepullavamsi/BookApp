package com.Legato.demo.BookApp.stepdefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "bookappfinal/src/test/resources/features",
				glue = "com.Legato.demo.BookApp.stepdefinitions")
public class TestRunner {
	
	

}

