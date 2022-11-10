package org.demoQA;

import java.io.IOException;

import org.Utility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlePopUps extends BaseUtility {

	public static void main(String[] args) {
		WebDriver driver = bUtil.setUp("chrome", "https://demoqa.com/");
		bUtil.clickOn(driver, "xpath", "//h5[text()='Forms']");
		bUtil.clickOn(driver, "xpath", "//span[text()='Practice Form']");

		bUtil.pageDownBy(1);
		WebElement upload = driver.findElement(By.id("uploadPicture"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", upload);

		try {
			Runtime.getRuntime().exec("./AutoitFiles/ChromeUpload.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
