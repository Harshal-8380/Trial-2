package org.TestNGPractice;

import java.util.List;

import org.Utility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSuggestionInTestNG {
	WebDriver driver = null;
	BaseUtility su = new BaseUtility();

	@BeforeTest
	public void preRequisites() {
		driver = su.setUp("chrome", "https://www.google.com");
	}

	@Test
	public void suggestions() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Top 10 Richest People in the world");
		List<WebElement> webEle = driver
				.findElements(By.cssSelector("ul>li>div>div:nth-of-type(2)>div:first-child>span"));
		Thread.sleep(4000);
		System.out.println("*******Search Results*******");
		for (WebElement wl : webEle) {
			System.out.println(wl.getText());
		}
		webEle.get(1).click();
		Thread.sleep(4000);
		System.out.println(driver.getCurrentUrl());
	}

	@AfterTest
	public void shutDown() {
		su.tearDown();
	}
}
