package org.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownEx1 {
	public static void main(String[]args) {
		System.setProperty("webdriver.gecko.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement dropdown=driver.findElement(By.id("Skills"));
		Select skillsDropDown = new Select(dropdown);
		
		List<WebElement> webEle=driver.findElements(By.id("Skills"));
		for(int i=0;i<webEle.size();i++) {
			System.out.println(webEle.get(i).getText());
		}
		System.out.println("Default Selection: "+skillsDropDown.getFirstSelectedOption().getText());
		
		System.out.println("Multiple or not? "+skillsDropDown.isMultiple());
		
		skillsDropDown.selectByIndex(10);
		System.out.println("selected options : "+skillsDropDown.getFirstSelectedOption().getText());
		
		driver.close();
	}
}
