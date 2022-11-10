package org.demoQA;

import java.util.Iterator;
import java.util.Set;

import org.Utility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowHandler extends BaseUtility {
	public static void main(String[] args) {
		WebDriver driver = bUtil.setUp("chrome", "https://demoqa.com/");

		bUtil.clickOn(driver, "xpath", "//h5[text()='Alerts, Frame & Windows']");
		bUtil.clickOn(driver, "xpath", "//span[text()='Browser Windows']");
		String currentWindowId = driver.getWindowHandle();

		bUtil.clickOn(driver, "id", "windowButton");

		Set<String> allWinId = driver.getWindowHandles();

		allWinId.remove(currentWindowId);

		Iterator<String> itr = allWinId.iterator();

		String newWinId = itr.next();

		driver.switchTo().window(newWinId);

		bUtil.printText(bUtil.clickOn(driver, "id", "sampleHeading"));

		driver.close();

		driver.switchTo().window(currentWindowId);

		System.out.println(driver.findElement(By.className("main-header")).getText());

		driver.quit();
	}
}
