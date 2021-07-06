package com.test.automation.dataproviders;

import org.testng.annotations.DataProvider;

import com.test.automation.data.HomeData;
import com.test.automation.util.PropertyReader;

public class HomeDataProvider {
	
	@DataProvider(name = "homeData")
	public Object[][] homeDataProvider() {
		PropertyReader.loadProperty();
		HomeData[][] data = HomeData.getHomeData(PropertyReader.excelPath.toString());
		return data;
	}

}
