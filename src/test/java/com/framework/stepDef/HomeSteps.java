package com.framework.stepDef;

import com.framework.pages.HomePage;
import com.framework.utils.DriverUtils;

import io.cucumber.java.en.Then;

public class HomeSteps extends DriverUtils{
	
	HomePage home = new HomePage(getWebDriver());
	
	
	@Then("^verify user is on homepage$")
	public void verify_user_is_on_homepage() throws Throwable {
		home.verifyHomePage();
	}
	
}
