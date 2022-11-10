package org.PracticeProg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenYoutube2 {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='contents']/ytd-rich-grid-row[1]"
				+ " //ytd-rich-item-renderer[2]"
				+ " //div[div[h3[a[yt-formatted-string[@id='video-title']]]]]")).click();
	
//		driver.findElement(By.xpath("(//img[@id='img']) [7]")).click();//improperly working
	}
}