package com.test.automation.pages;

import org.openqa.selenium.By;
import com.test.automation.data.HomeData;
import com.test.automation.util.Base;

public class HomePage extends Base {

	public void searchHotel(HomeData data) {
		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//input[@role='searchbox']")).click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(data.getDestination());
		driver.findElement(By.id("checkin")).sendKeys(data.getCheckIn());
		driver.findElement(By.id("checkout")).sendKeys(data.getCheckOut());
		driver.findElement(By.name("adults")).sendKeys(data.getAdult());
		driver.findElement(By.name("children")).sendKeys(data.getChild());

	}

}
