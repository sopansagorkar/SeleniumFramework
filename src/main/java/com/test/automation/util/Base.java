package com.test.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver getDriver(String driver) {
		String os = System.getProperty("os.name");
		String osarch = System.getProperty("os.arch");
		
		if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os) || "Windows 10".equalsIgnoreCase(os)
				&& "amd64".equalsIgnoreCase(osarch) && driver.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		} else if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os)
				|| "Windows 10".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
						&& driver.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		} else {
			return null;
		}
	}

}
