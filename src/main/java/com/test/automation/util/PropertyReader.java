package com.test.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertyReader {

	public static String site_url;
	public static String excelPath;
	public static Properties properties = new Properties();
	private static final Logger logger = Logger.getLogger(PropertyReader.class);

	public static void loadProperty() {
		try {
			properties.load(new FileInputStream(new File("src/main/resources/config.properties")));
		} catch (FileNotFoundException e) {
			logger.error("config.properties file not found", e);
		} catch (IOException e) {
			logger.error("Failed to load config.properties", e);
		}
		site_url = properties.getProperty("site-url");
		excelPath=properties.getProperty("excel-path");
	}
}
