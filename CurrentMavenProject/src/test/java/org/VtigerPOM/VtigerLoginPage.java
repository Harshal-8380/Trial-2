package org.VtigerPOM;

import org.Utility.BaseUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VtigerLoginPage extends BaseUtility {
	WebDriver driver;

	public VtigerLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	public WebElement userName;

	@FindBy(name = "password")
	public WebElement pswd;

	@FindBy(xpath = "//button[text()='Sign in']")
	public WebElement signInButton;

	@Test
	public void vtigerLogin() {
//		typeIn(userName, "admin");
//		typeIn(pswd, "Test@123");
//		clickOn(signInButton);
	}

}