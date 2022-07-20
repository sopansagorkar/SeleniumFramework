package com.test.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.test.automation.data.LoginData;
import com.test.automation.util.Base;
import com.test.automation.util.PropertyReader;

public class LoginPage extends Base {

	public void login(LoginData data) {
		PropertyReader.loadProperty();
		driver.get(PropertyReader.site_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.findElement(By.cssSelector(".dropdown-login > #dropdownCurrency")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("email")).sendKeys(data.getUserName());
		driver.findElement(By.name("password")).sendKeys(data.getPassword());
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	}

	public void verifyLogin(LoginData data) {
		driver.findElement(By.xpath("//a[@class=' waves-effect' and contains(text(),'My Profile')]")).click();
		Assert.assertEquals(data.getUserName(),
				driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value").toString());
	}

}
