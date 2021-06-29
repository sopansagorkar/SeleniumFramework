package com.test.automation.test;


import org.testng.annotations.Test;

import com.test.automation.pages.LoginPage;


public class SampleTest {

	@Test
	public void TestURL() {
		LoginPage login=new LoginPage();
		login.login();

	}
}
