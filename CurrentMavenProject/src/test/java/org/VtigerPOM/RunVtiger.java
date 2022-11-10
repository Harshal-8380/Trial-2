package org.VtigerPOM;

import org.Utility.BaseUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunVtiger {
	VtigerLoginPage login = null;
	VtigerHomePage homePage = null;
	LeadsPage leadsPage = null;
	BaseUtility su = new BaseUtility();

	@BeforeTest
	public void presetter() {

		WebDriver driver = su.setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");

		login = new VtigerLoginPage(driver);
		homePage = new VtigerHomePage(driver);
		leadsPage = new LeadsPage(driver);
	}

	@Test(priority = 1)
	public void login() {
		login.vtigerLogin();
	}

	@Test(priority = 2)
	public void selectContact() {
		homePage.selectFromHamburger("Marketing", "Contacts");
	}

	@Test(enabled = false)
	public void createLead() {
		leadsPage.leadCreation();
	}

	@Test(enabled = false)
	public void deleteLead() {
		homePage.leadSelection();
		leadsPage.leadDeletion();
	}

	@AfterTest(enabled = false)
	public void clearAll() {
		su.tearDown();
	}
}
