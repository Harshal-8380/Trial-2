package org.DropDown;

//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownEx2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebElement year =driver.findElement(By.id("yearbox"));
		Select yearDropDown=new Select(year);
//		List<WebElement> yearDD=yearDropDown.getOptions();
		Thread.sleep(2000);
		yearDropDown.selectByValue("1996");
//		System.out.println("Selected Option is: "+yearDropDown.getFirstSelectedOption().getText());
		
		WebElement month=driver.findElement(By.cssSelector("select[ng-model='monthbox']"));
		Select monthDropDown=new Select(month);
//		List<WebElement> monthDD=monthDropDown.getOptions();
		Thread.sleep(2000);
		monthDropDown.selectByValue("June");
		
		WebElement day=driver.findElement(By.id("daybox"));
		Select dayDropDown= new Select(day);
//		List<WebElement> dayDD=dayDropDown.getOptions();
		dayDropDown.selectByValue("20");
		Thread.sleep(2000);
		System.out.println("Selected Date is: "+dayDropDown.getFirstSelectedOption().getText()+" "
		+monthDropDown.getFirstSelectedOption().getText()+", "+yearDropDown.getFirstSelectedOption().getText());
		
		driver.close();
	}
}
