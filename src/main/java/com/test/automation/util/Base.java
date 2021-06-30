package com.test.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver getDriver(String driver) {
		String os = System.getProperty("os.name");
		String osarch = System.getProperty("os.arch");

		if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os) || "Windows 10".equalsIgnoreCase(os)
				&& "amd64".equalsIgnoreCase(osarch) && driver.equalsIgnoreCase(BrowserType.chrome.toString())) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		} else if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os)
				|| "Windows 10".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
						&& driver.equalsIgnoreCase(BrowserType.firefox.toString())) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		} else if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os)
				|| "Windows 10".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
						&& driver.equalsIgnoreCase(BrowserType.phantomjs.toString())) {
			WebDriverManager.phantomjs().setup();
			return new PhantomJSDriver();
		} else if ("Linux".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
				&& driver.equalsIgnoreCase(BrowserType.phantomjs.toString())) {
			WebDriverManager.phantomjs().setup();
			return new PhantomJSDriver();
		} else {
			return null;
		}
	}

}
