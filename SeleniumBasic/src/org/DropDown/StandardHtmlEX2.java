package org.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StandardHtmlEX2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Akshay");
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Kumar");
		driver.findElement(By.cssSelector(".col-md-8 .form-control")).sendKeys("Mumbai");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		
		WebElement skillDrop=driver.findElement(By.id("Skills"));
		Select dd=new Select(skillDrop);
		if(dd.isMultiple()) {
			System.out.println("Dropdown is Multiple Selection Type");
		}else{
			System.out.println("Single Selection Type");
		}
		
//		driver.findElement(By.id("Skills")).click();
		System.out.println(dd.getFirstSelectedOption().getText());
		List<WebElement> ddList=dd.getOptions();
		for(WebElement getList : ddList) {
			System.out.println(getList.getText());
		}
		
		dd.selectByIndex(5);
		dd.selectByValue("Engineering");
		System.out.println("*****************");
		List<WebElement> selectedOptions=dd.getAllSelectedOptions();
		for(WebElement getSelOpt : selectedOptions) {
			System.out.println(getSelOpt.getText());
		}
		driver.close();
		
		
	}

}
