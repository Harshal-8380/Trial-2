package org.PropertyPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeByPropertyFile{
	WebDriver driver;
	FileInputStream fis;
	Properties prop;

	@BeforeTest
	public void preRequisites() throws IOException {
		String fileLocation = System.getProperty("user.dir")
				+ ".\\src\\main\\resources\\TestData\\ActitimeData.properties";
		fis = new FileInputStream(fileLocation);
		prop = new Properties();
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(prop.getProperty("appURL"));
	}

//	@FindBy(xpath = "//input[@id='username']")
//	public WebElement userName;
//
//	@FindBy(xpath = "//input[@name='pwd']")
//	public WebElement password;
//
//	@FindBy(xpath = "//a[@id='loginButton']")
//	public WebElement loginButton;

	@Test
	public void login() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();

	}
}
