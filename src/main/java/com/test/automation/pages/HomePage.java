package com.test.automation.pages;

import org.openqa.selenium.By;
import com.test.automation.data.HomeData;
import com.test.automation.util.Base;

public class HomePage extends Base {

	public void searchHotel(HomeData data) {
		
		driver.findElement(By.xpath("//img[@class=\"logo p-1 rounded\"]")).click();
		driver.findElement(By.xpath("//input[@name='from']")).click();
        driver.findElement(By.xpath("//input[@name='from']")).sendKeys(data.getSource());
        driver.findElement(By.xpath("//button[contains(text(),\"IDR\")]")).click();
        driver.findElement(By.xpath("//input[@name='to']")).click();
        driver.findElement(By.xpath("//input[@name='to']")).sendKeys(data.getDestination());
        driver.findElement(By.xpath("//button[contains(text(),\"PNQ \")]")).click();
        driver.findElement(By.id("departure")).click();
        driver.findElement(By.xpath("(//div[@class='datepicker dropdown-menu']//td[contains(text(),'10')])[3]")).click();

	}

}
