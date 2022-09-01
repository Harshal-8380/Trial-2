package org.OpenWebPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSuggestionsEx1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver"
				,"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("7 wonders of world");
		
		List <WebElement> webEle= driver.findElements(By.cssSelector("ul>li>div>div:nth-of-type(2)>div:first-child>span"));
		Thread.sleep(4000);
		System.out.println("*******Search Results*******");
		for(WebElement wl: webEle) {
			System.out.println(wl.getText());
		}
		driver.close();
	}
}
