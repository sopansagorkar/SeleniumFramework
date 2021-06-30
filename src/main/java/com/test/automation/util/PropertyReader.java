package com.test.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String site_url;
	public static String excelPath;
	public static Properties properties = new Properties();

	public static void loadProperty() {
		try {
			properties.load(new FileInputStream(new File("src/main/resources/config.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		site_url = properties.getProperty("site-url");
		excelPath=properties.getProperty("excel-path");
	}
}
