package com.test.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import org.apache.log4j.Logger;

public class Base {
	public static WebDriver driver;
	private static final Logger logger = Logger.getLogger(Base.class);
	public static WebDriver getDriver(String driverName) {
		String os = System.getProperty("os.name");
		String osarch = System.getProperty("os.arch");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME,	"firefox");

		if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os) || "Windows 11".equalsIgnoreCase(os)
				&& "amd64".equalsIgnoreCase(osarch) && driverName.equalsIgnoreCase(BrowserType.chrome.toString())) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			return driver;
		} else if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os)
				|| "Windows 11".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
						&& driverName.equalsIgnoreCase(BrowserType.firefox.toString())) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			return driver;
		} else if ("Windows 7".equalsIgnoreCase(os) || "Windows 8".equalsIgnoreCase(os)
				|| "Windows 11".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
						&& driverName.equalsIgnoreCase(BrowserType.phantomjs.toString())) {
			WebDriverManager.firefoxdriver().setup();
			driver=new PhantomJSDriver();
			return driver;
		} else if ("Linux".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)
				&& driverName.equalsIgnoreCase(BrowserType.phantomjs.toString())) {
			WebDriverManager.firefoxdriver().setup();
			driver=new PhantomJSDriver();
			return driver;
		}
		else if (driverName.equalsIgnoreCase(BrowserType.remote.toString())) {
			try {
				URL gridUrl = URI.create("http://localhost:4444/wd/hub").toURL();
				driver = new RemoteWebDriver(gridUrl, capabilities);
			} catch (MalformedURLException e) {
				logger.error("Failed to create Grid URL for RemoteWebDriver", e);
			}
			return driver;
		}
		else {
			return null;
		}
	}

}
