package com.framework.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = "src\\test\\resources\\feature\\Demo.feature", 
					glue = "com.sprintqa.stepDef", 
					monochrome = true,
					plugin = {"json:target/cucumber.json", "junit:target/cucumber.xml"}
				)
public class Runner {

}
