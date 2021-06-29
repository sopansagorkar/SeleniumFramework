package com.test.automation.pages;

import org.openqa.selenium.WebDriver;

import com.test.automation.util.Base;

public class LoginPage extends Base {
	WebDriver driver;

	public String getDriverName() {
		String browser = System.getProperty("browser");
		return browser;
	}

	public void login() {
		driver=getDriver(getDriverName());
		driver.get("https://www.phptravels.net/");
		driver.quit();
	}

}
