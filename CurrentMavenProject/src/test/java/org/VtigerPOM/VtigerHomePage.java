package org.VtigerPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerHomePage {
	WebDriver driver;

	public VtigerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on Hamburger
	@FindBy(xpath = "//div[@id='appnavigator']")
	public WebElement navigator;

	// List of Options
	@FindBy(xpath = "//div[@class='app-list row']//div/div/span[2]")
	public List<WebElement> dropdown;

	@FindBy(xpath = "//span[text()=' MARKETING']")
	private WebElement marketing;

	@FindBy(xpath = "//span[text()=' Leads']")
	private WebElement leads;

	public void leadSelection() {
		navigator.click();
		marketing.click();
		leads.click();
	}

	public void selectFromHamburger(String options, String subOptions) {
		navigator.click();
		switch (options) {
		//1
		case "Dashboard":
			dropdown.get(0).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//2
		case "Marketing":
			dropdown.get(1).click();
			switch (subOptions) {
			case "Campaigns":
				driver.findElement(By.xpath("//span[text()=' Campaigns']")).click();
				break;
			case "Leads":
				driver.findElement(By.xpath("//span[text()=' Leads']")).click();
				break;
			case "Contacts":
				driver.findElement(By.xpath("(//span[text()=' Contacts'])[1]")).click();
				break;
			case "Organizations":
				driver.findElement(By.xpath("(//span[text()=' Organizations'])[1]")).click();
				break;
			}

			System.out.println(options+" & "+subOptions+" is selected");
			break;
			
		//3
		case "Sales":
			dropdown.get(2).click();
			switch (subOptions) {
			case "Opportunities":
				driver.findElement(By.xpath("//span[text()=' Opportunities']")).click();
				break;
			case "Quotes":
				driver.findElement(By.xpath("//span[text()=' Quotes']")).click();
				break;
			case "Products":
				driver.findElement(By.xpath("(//span[text()=' Products'])[1]")).click();
				break;
			case "Services":
				driver.findElement(By.xpath("(//span[text()=' Services'])[1]")).click();
				break;
			case "SMSNotifire":
				driver.findElement(By.xpath("(//span[text()=' SMS Notifier'])[1]")).click();
				break;
			case "Contacts":
				driver.findElement(By.xpath("(//span[text()=' Contacts'])[2]")).click();
				break;
			case "Organizations":
				driver.findElement(By.xpath("(//span[text()=' Organizations'])[2]")).click();
				break;
				}
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//4
		case "Inventory":
			dropdown.get(3).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//5
			case "Support":
			dropdown.get(4).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//6
			case "Projects":
			dropdown.get(5).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//7
			case "Tools":
			dropdown.get(6).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//8
			case "MailManager":
			dropdown.get(7).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//9
			case "Doduments":
			dropdown.get(0).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//10
			case "ExtentionStore":
			dropdown.get(0).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		//11
			case "Settings":
			dropdown.get(0).click();
			System.out.println(options+" & "+subOptions+" is selected");
			break;
		}

	}
}
