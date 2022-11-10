package org.PracticeProg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		driver.switchTo().activeElement().sendKeys("admin",Keys.TAB);
		driver.switchTo().activeElement().sendKeys("manager",Keys.ENTER);

		driver.findElement(By.xpath("//a[@class='content tasks']")).click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='dropdownContainer addNewMenu']/div[3]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".customerSelector .comboboxButton"))));
		driver.findElement(By.cssSelector(".customerSelector .comboboxButton")).click();
		
		driver.findElement(By.xpath("//div[@class='searchItemList']/div[text()='Galaxy Corporation']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".projectSelector .comboboxButton"))));
		driver.findElement(By.cssSelector(".projectSelector .comboboxButton")).click();
		driver.findElement(By.xpath("//div[@class='searchItemList']/div[text()='Android testing']")).click();
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("MyTest");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().click();
		driver.switchTo().activeElement().sendKeys(Keys.chord(Keys.CONTROL,Keys.ARROW_RIGHT));
		driver.findElement(By.xpath("//tbody/tr[3]/td[1]/a/em/span")).click();
		driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
		System.out.println("Task Created Succssfully");
		driver.findElement(By.xpath("//tr[td[div[div[div[div[text()='MyTask']]]]]]/td[1]/div/div")).click();
		driver.findElement(By.xpath("//div[@class='delete button']")).click();
		driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
		System.out.println("Task Deleted Succssfully");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("Logout Succssfully");
		driver.close();
	}
}