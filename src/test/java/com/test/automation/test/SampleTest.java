package com.test.automation.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.automation.data.HomeData;
import com.test.automation.data.LoginData;
import com.test.automation.pages.HomePage;
import com.test.automation.pages.LoginPage;
import com.test.automation.util.Base;
import com.test.automation.util.TestListener;
import com.test.automation.dataproviders.HomeDataProvider;
import com.test.automation.dataproviders.LoginDataProvider;

@Listeners(TestListener.class)
public class SampleTest extends Base {
	@BeforeClass
	public void setup() {
		driver = getDriver(System.getProperty("browser"));
	}

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void loginTest(LoginData data) {
		LoginPage login = new LoginPage();
		login.login(data);
		login.verifyLogin(data);
	}

	@Test(dataProvider = "homeData", dataProviderClass = HomeDataProvider.class)
	public void searchHotel(HomeData data) {
		HomePage homePage = new HomePage();
		homePage.searchHotel(data);
	}
}
