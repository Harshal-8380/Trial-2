package org.OpenWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLoginEx {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		WebElement logIn=driver.findElement(By.id("email"));
		logIn.sendKeys("sunnyboyharshal@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("Harshal@8380");
		
		driver.findElement(By.name("login")).click();
		
		driver.close();
				
	}
}
