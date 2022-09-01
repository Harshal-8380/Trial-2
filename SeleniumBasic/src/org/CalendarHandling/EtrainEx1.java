package org.CalendarHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EtrainEx1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("https://etrain.info/in");
		driver.findElement(By.name("station1")).click();
		driver.findElement(By.name("station1")).sendKeys("Pune");
		driver.findElement(By.cssSelector(".ui-menu-item i[class='icon-train-tunneled']")).click();
		
		driver.findElement(By.name("station2")).click();
		driver.findElement(By.name("station2")).sendKeys("Mumbai");
		driver.findElement(By.cssSelector("#suggest_row3 i[class='icon-train-tunneled']")).click();
		
		driver.findElement(By.id("tbsfi4")).click();
		driver.findElement(By.cssSelector("input[value='>']")).click();
		driver.findElement(By.cssSelector("table>tbody>tr:nth-of-type(4)>td:nth-of-type(4)>input")).click();
		
		WebElement quotaSelection=driver.findElement(By.id("tbsfi5"));
		Select quota=new Select(quotaSelection);
		Thread.sleep(3000);
		quota.selectByIndex(1);
		driver.findElement(By.id("tbssbmtbtn")).click();
		
		List<WebElement> trainId=driver.findElements(By.cssSelector("div.trainlist.rnd5 tr>td:first-child>a"));
		System.out.println("Train id found: "+trainId.size());
		List<WebElement> trainName=driver.findElements(By.cssSelector("div.trainlist.rnd5 tr>td:nth-of-type(2)>a"));
		System.out.println("Trains found: "+trainName.size());
		
		for(int i=0;i<trainId.size();i++) {
			System.out.println(trainId.get(i).getText()+" : "+trainName.get(i).getText());
		}
		
		driver.close();
	}
}
