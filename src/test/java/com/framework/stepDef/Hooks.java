package com.framework.stepDef;

import com.framework.utils.DriverUtils;
import com.framework.utils.ConfigsReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void setUp() {
		ConfigsReader.readProperties("src\\test\\resources\\configs\\credentials.properties");
		DriverUtils.setUp();
	}
	
	@After
	public void tearDown() {
		DriverUtils.tearDown();
	}

}
