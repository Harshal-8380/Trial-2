package org.TestNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenWebPage {
  @Test
 public void openActiTime() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		driver.switchTo().activeElement().sendKeys("admin",Keys.TAB);
		driver.switchTo().activeElement().sendKeys("manager",Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@class='content tasks']")).click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='dropdownContainer addNewMenu']/div[3]")).click();
		driver.findElement(By.cssSelector(".customerSelector input[type='text']")).click();
		driver.findElement(By.xpath("//div[@class='searchItemList']/div[text()='Galaxy Corporation']")).click();
		driver.findElement(By.xpath("//div[text()='- Select Project -']")).click();
		driver.findElement(By.xpath("//div[@class='searchItemList']/div[text()='Android testing']")).click();
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("MyTest");
	  
	  }
	}
