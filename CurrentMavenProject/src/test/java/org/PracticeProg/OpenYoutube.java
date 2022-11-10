package org.PracticeProg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenYoutube {
	public static void main(String[] args) {
		String videoName="TIME IS EVERYTHING | Standup Comedy by Mohd Vivian";
		String path="//yt-formatted-string[text()='"+videoName+"']";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(videoName);
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(path)).click();
		
	}
}
