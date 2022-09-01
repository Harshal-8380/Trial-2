package org.PositionOfElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PositionOfElement {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(4000);
		WebElement errMsg=driver.findElement(By.className("errormsg"));
		
		Point errorMsg=errMsg.getLocation();
		
		System.out.println("Error Msg Location in X: "+errorMsg.getX());
		System.out.println("Error Msg Location in Y: "+errorMsg.getY());
		
		System.out.println("Username Field Location in X: "+driver.findElement(By.id("username")).getLocation().getX());
		System.out.println("Username Field Location in Y: "+driver.findElement(By.id("username")).getLocation().getY());
		
		System.out.println((errorMsg.getY())>(driver.findElement(By.id("username")).getLocation().getY()));
	
	
	}
}
