package org.CssValueEx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssValuesEx1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		WebElement loginBtn= driver.findElement(By.cssSelector("button[name='login']"));
		System.out.println("Button Background color: "+loginBtn.getCssValue("background-color"));
		System.out.println("Text Color: "+loginBtn.getCssValue("color"));
		
		System.out.println("Font Size: "+loginBtn.getCssValue("font-size"));
		
		Point btnLocation=loginBtn.getLocation();
		
		System.out.println("X location: "+btnLocation.getX());
		System.out.println("Y location: "+btnLocation.getY());
	}
}
