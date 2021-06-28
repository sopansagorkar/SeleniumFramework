package com.test.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	WebDriver driver=null;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}

	@Test
	public void TestURL() {
		driver.get("http://demo.automationtesting.in/");
		System.out.println(driver.getTitle());

	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
