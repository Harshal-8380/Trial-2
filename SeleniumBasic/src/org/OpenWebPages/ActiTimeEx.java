package org.OpenWebPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTimeEx {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		
		String loginPageUrl=driver.getCurrentUrl();
		System.out.println("Login Page URL Validation: "+loginPageUrl.equals("https://demo.actitime.com/login.do"));
		
		String loginPageTitle=driver.getTitle();
		System.out.println("Login Page Title Validation: "+loginPageTitle.equals("actiTIME - Login"));
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(4000);
		String homePageUrl=driver.getCurrentUrl();
		System.out.println("Home Page Url: "+homePageUrl);
		String homePageTitle=driver.getTitle();
		System.out.println("Home Page Title: "+homePageTitle);
		
		driver.findElement(By.cssSelector(".content.tasks")).click();
		driver.findElement(By.cssSelector(".addNewButton")).click();
		driver.findElement(By.cssSelector(".item.createNewTasks")).click();
		driver.findElement(By.cssSelector(".projectSelector div[class='emptySelection']")).click();
		driver.findElement(By.cssSelector(".projectSelector div[class='searchItemList']>div:nth-of-type(4)")).click();
		
		driver.findElement(By.cssSelector("tbody>tr:first-child input[placeholder='Enter task name']")).sendKeys("MyTask1");
		driver.findElement(By.cssSelector("#createTasksPopup .components_button_label")).click();
		driver.findElement(By.cssSelector(".createdTasksTableContainer td:first-child .img")).click();
		driver.findElement(By.cssSelector(".delete.button")).click();
		driver.findElement(By.cssSelector(".deleteDialog .submitTitle")).click();
	
		List<WebElement> webEle=driver.findElements(By.cssSelector("tbody>tr>td:nth-of-type(2)>div>div>div:first-child>div:nth-of-type(2)"));
		for(WebElement wl:webEle) {
			System.out.println(wl.getText());
			;
		}
		System.out.println("MyTest1 is present: "+webEle.contains("MyTest1"));
		
		driver.findElement(By.cssSelector("#logoutLink"));
		System.out.println("Logout Successful");
		
		driver.close();
	}
}
