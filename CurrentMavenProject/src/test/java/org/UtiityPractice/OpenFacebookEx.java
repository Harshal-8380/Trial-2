package org.UtiityPractice;

import org.Utility.BaseUtility;
import org.openqa.selenium.WebDriver;

public class OpenFacebookEx extends BaseUtility {
	public static BaseUtility bu = new BaseUtility();

	public static void main(String[] args) {
		String url = "https://www.facebook.com/";
		WebDriver driver = bu.setUp("chrome", url);

		bu.typeInput(driver, "id", "email", "8380959453");
		bu.typeInput(driver, "id", "pass", "Harshal@8380");
		bu.clickOn(driver, "name", "login");

		bu.clickOn(driver, "xpath", "//div[@role='banner']/div[3]/div/span/div/div/div");
		bu.clickOn(driver, "xpath", "//span[text()='Log Out']");
		bu.tearDown();
	}
}
