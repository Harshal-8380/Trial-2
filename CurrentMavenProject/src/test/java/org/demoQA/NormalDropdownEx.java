package org.demoQA;

import org.Utility.BaseUtility;
import org.openqa.selenium.WebDriver;

public class NormalDropdownEx extends BaseUtility{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=BaseUtility.bUtil.setUp("chrome","https://demoqa.com/");
		bUtil.clickOn(driver,"xpath","//h5[text()='Widgets']");

		bUtil.clickOn(driver,"xpath","(//div[@class='element-group'])[4]/div/ul/li[1]");

		driver.get("https://demoqa.com/select-menu");
		bUtil.gotoEndOfPage();
		bUtil.clickOn(driver,"xpath","(//div[@class=' css-yk16xz-control'])[3]");
		bUtil.clickOn(driver,"xpath","//div[text()='Green']");
		bUtil.clickOn(driver,"xpath","//div[text()='Red']");
		bUtil.clickOn(driver,"xpath","//div[text()='Blue']");
		bUtil.clickOn(driver,"xpath","//div[text()='Black']");
		
		bUtil.tearDown();
		
	}
}
