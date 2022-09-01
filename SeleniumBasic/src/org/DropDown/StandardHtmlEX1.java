package org.DropDown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StandardHtmlEX1 {

	public static void main(String[] args) {

		String driverPath = System.getProperty("user.dir") + "\\executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement skillDropdown=driver.findElement(By.id("Skills"));
	
		Select selectSkill=new Select(skillDropdown);

		System.out.println("Is dropdown is allowing you to select multiple option: "+selectSkill.isMultiple());
	
		System.out.println("Already selected option name: "+selectSkill.getFirstSelectedOption().getText());

		List<WebElement> options=selectSkill.getOptions();
		System.out.println("Option count is:"+options.size());
		List<String> str= new ArrayList<String>();
		List<String> str2= new ArrayList<String>();
		//Get dropdown option names
		for(int i=1;i<78;i++) {
//			System.out.println("Option "+i+": "+options.get(i).getText()+" : str: "+str);
			str.add(options.get(i).getText().toLowerCase());
			str2.add(options.get(i).getText().toLowerCase());
		}
		
		Collections.sort(str);
		System.out.println("str: "+str);
		System.out.println("str2: "+str2);
		System.out.println(str2.equals(str));
		//validation dropdown skills are getting displayed in ascending order
		
			//select options from dropdown
//		selectSkill.selectByIndex(4);
//		System.out.println("Already selected option name: "+selectSkill.getFirstSelectedOption().getText());
//		//or
//		selectSkill.selectByValue("Backup Management");
//		System.out.println("Already selected option name: "+selectSkill.getFirstSelectedOption().getText());
//		//or
//		selectSkill.selectByVisibleText("Analytics");
//		System.out.println("Already selected option name: "+selectSkill.getFirstSelectedOption().getText());
//
//		//perform validation on following
//		//1. Year(ascending order validation)
//		//2. Month(month Sequence validation)
		//3. Days(ascending order validation

	}

}
