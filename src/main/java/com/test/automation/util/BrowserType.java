package com.test.automation.util;

public enum BrowserType {
	chrome("chrome"), safari("safari"), edge("edge"), phantomjs("phantomjs"),firefox("firefox"),remote("remote");

	public final String browser;

	private BrowserType(String label) {
		this.browser = label;
	}
}