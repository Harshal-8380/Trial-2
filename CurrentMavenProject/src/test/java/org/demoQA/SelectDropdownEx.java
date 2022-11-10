package org.demoQA;

import org.Utility.BaseUtility;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

public class SelectDropdownEx extends BaseUtility {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = bUtil.setUp("chrome", "https://demoqa.com/");
		bUtil.clickOn(driver, "xpath", "//h5[text()='Widgets']");
		bUtil.clickOn(driver, "xpath", "(//div[@class='element-group'])[4]/div/ul/li[1]");

		driver.get("https://demoqa.com/select-menu");
		WebElement element = bUtil.clickOn(driver, "id", "oldSelectMenu");
		bUtil.selectDropdown(element);
		bUtil.getAllOptions(element);
		bUtil.printAllFromSelectDropdown(element);
		bUtil.selectByIndex(1);
		
		driver.close();
	}
}
