package org.demoQA;

import org.Utility.BaseUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertHandling extends BaseUtility{
	public static void main(String[] args) {
		WebDriver driver = bUtil.setUp("chrome","https://demoqa.com/alerts");
		bUtil.clickOn(driver,"id","promtButton");
		
		Alert alert= driver.switchTo().alert();
		System.out.println("Alert Text : "+alert.getText());
		alert.sendKeys("Test Alert");
		alert.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		driver.close();
	}
}
