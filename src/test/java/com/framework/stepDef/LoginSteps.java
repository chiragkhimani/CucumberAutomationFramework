package com.framework.stepDef;

import com.framework.pages.LoginPage;
import com.framework.utils.DriverUtils;
import com.framework.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverUtils{

	LoginPage login = new LoginPage(getWebDriver());
	
	@Given("^user open the website$")
	public void user_open_the_website() throws Throwable {
		login.openWebsite();
	}

	@Then("^verify login page is displayed$")
	public void verify_login_page_is_displayed() throws Throwable {
		login.verifyLoginPage();
	}

	@When("^user login with valid cred$")
	public void user_login_with_valid_cred() throws Throwable {
		login.doLogin(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}
	
	@When("^user login with invalid cred$")
	public void user_login_with_invalid_cred() throws Throwable {
		login.doLogin("12345","12345");
	}

	@Then("^verify login is unsuccessful$")
	public void verify_login_is_unsuccessful() throws Throwable {
	    login.verifyInvalidLoginErrorMessage();
	}
	
	@When("^user login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_with_username_and_password(String usernameKey, String passwordKey) throws Throwable {
		login.doLogin(ConfigsReader.getProperty(usernameKey), ConfigsReader.getProperty(passwordKey));
	}


}
