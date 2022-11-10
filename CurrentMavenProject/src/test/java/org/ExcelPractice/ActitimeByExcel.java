package org.ExcelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeByExcel {
	public static void main(String[] args) throws IOException {
		String fileLocation = System.getProperty("user.dir") + ".\\src\\main\\resources\\TestData\\TestData.xlsx";

		FileInputStream fis = new FileInputStream(fileLocation);

		Workbook workbook = new XSSFWorkbook(fis);

		String ActitimeUrl = workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
		String userName = workbook.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
		String password = workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		String expectedHomePageTitle = workbook.getSheetAt(0).getRow(1).getCell(4).getStringCellValue();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get(ActitimeUrl);

		driver.switchTo().activeElement().sendKeys(userName, Keys.TAB);
		driver.switchTo().activeElement().sendKeys(password, Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='content tasks']"))));

		String actualHomePageTitle = driver.getTitle();

		workbook.getSheetAt(0).getRow(1).createCell(5).setCellValue(actualHomePageTitle);

//		if (actualHomePageTitle.equals(expectedHomePageTitle)) {
//			workbook.getSheetAt(0).getRow(1).createCell(6).setCellValue("Pass");
//			System.out.println("Pass");
//		} else {
//			workbook.getSheetAt(0).getRow(1).createCell(6).setCellValue("Fail");
//			System.out.println("Fail");
//		}
		
		Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle,"Pass");
		
		FileOutputStream fos = new FileOutputStream(fileLocation);
		
		workbook.write(fos);
		
		fos.close();
		
		System.out.println("expected title: "+expectedHomePageTitle);
		System.out.println("actual title  : "+actualHomePageTitle);
		driver.close();

	}
}
