package com.test.automation.test;


import org.testng.annotations.Test;

import com.test.automation.data.LoginData;
import com.test.automation.dataproviders.LoginDataProvider;
import com.test.automation.pages.LoginPage;


public class SampleTest {

	@Test(dataProvider = "loginData",dataProviderClass = LoginDataProvider.class)
	public void TestURL(LoginData data) {
		LoginPage login=new LoginPage();
		login.login(data);
		login.verifyLogin(data);
	}
}
