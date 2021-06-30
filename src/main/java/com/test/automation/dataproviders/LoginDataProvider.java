package com.test.automation.dataproviders;

import org.testng.annotations.DataProvider;

import com.test.automation.data.LoginData;
import com.test.automation.util.PropertyReader;

public class LoginDataProvider {
	
	@DataProvider(name = "loginData")
	public Object[][] loginDataProvider() {
		PropertyReader.loadProperty();
		LoginData[][] data = LoginData.getLoginData(PropertyReader.excelPath.toString());
		return data;
	}

}
