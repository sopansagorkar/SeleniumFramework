package com.test.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static WebDriver getDriver(String driverName) {
		String os = System.getProperty("os.name");
		String osarch = System.getProperty("os.arch");

		if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os) || "Windows 10".equalsIgnoreCase(os)
				&& "amd64".equalsIgnoreCase(osarch) && driverName.equalsIgnoreCase(BrowserType.chrome.toString())) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			return driver;
		} else if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os)
				|| "Windows 10".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
						&& driverName.equalsIgnoreCase(BrowserType.firefox.toString())) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			return driver;
		} else if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os)
				|| "Windows 10".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
						&& driverName.equalsIgnoreCase(BrowserType.phantomjs.toString())) {
			WebDriverManager.phantomjs().setup();
			driver=new PhantomJSDriver();
			return driver;
		} else if ("Linux".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
				&& driverName.equalsIgnoreCase(BrowserType.phantomjs.toString())) {
			WebDriverManager.phantomjs().setup();
			driver=new PhantomJSDriver();
			return driver;
		} else {
			return null;
		}
	}

}
