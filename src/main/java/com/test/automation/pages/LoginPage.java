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
		driver.findElement(By.xpath("//span[contains(text(),\"Customer\")]")).click();
        driver.findElement(By.xpath("(//li/a/small[contains(text(),\"Login\")])[2]")).click();
		driver.findElement(By.name("email")).sendKeys(data.getUserName());
		driver.findElement(By.name("password")).sendKeys(data.getPassword());
		driver.findElement(By.xpath("//button[@id=\"submitBTN\"]")).click();
	}

	public void verifyLogin(LoginData data) {
		driver.findElement(By.xpath("//a/span[contains(text(),'My Profile')]")).click();
		Assert.assertEquals(data.getUserName(),
                driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value").toString());
	}

}
