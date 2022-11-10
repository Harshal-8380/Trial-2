package org.demoQA;

import java.util.Iterator;
import java.util.Set;

import org.Utility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTab extends BaseUtility {
	public static void main(String[] args) {
		WebDriver driver = bUtil.setUp("chrome","https://demoqa.com/");
		
		bUtil.clickOn(driver, "xpath", "//h5[text()='Alerts, Frame & Windows']");
		bUtil.clickOn(driver,"xpath","//span[text()='Browser Windows']");
		
		String currentWindowId= driver.getWindowHandle();
		
		bUtil.clickOn(driver,"id","tabButton");
		
		Set<String> allWindowId= driver.getWindowHandles();
		
		allWindowId.remove(currentWindowId);
		
		Iterator<String> itr=allWindowId.iterator();
		
		String id2= itr.next();
		
		driver.switchTo().window(id2);
		
		bUtil.printText(bUtil.clickOn(driver,"id","sampleHeading"));
		
		driver.switchTo().window(currentWindowId);
		
		System.out.println(driver.findElement(By.className("main-header")).getText());
		
	}

}
