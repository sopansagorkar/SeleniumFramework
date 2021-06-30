package com.test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.automation.data.LoginData;
import com.test.automation.util.Base;
import com.test.automation.util.PropertyReader;

public class LoginPage extends Base {
	WebDriver driver;

	public String getDriverName() {
		String browser = System.getProperty("browser");
		return browser;
	}

	public void login(LoginData data) {
		PropertyReader.loadProperty();
		driver=getDriver(getDriverName());
		driver.get(PropertyReader.site_url);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".dropdown-login > #dropdownCurrency")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(data.getUserName());
		driver.findElement(By.name("password")).sendKeys(data.getPassword());
		driver.findElement(By.xpath("//*[@id='loginfrm']/button")).click();
		//driver.quit();
	}

}
