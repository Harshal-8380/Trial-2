package org.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	WebDriver driver;

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='Create a New List']")
	private WebElement createList;

	@FindBy(xpath = "//input[@name='viewname']")
	private WebElement inputName;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement save;

	public void listCreation() throws InterruptedException {
		createList.click();
		inputName.sendKeys("September, 2022");
		Thread.sleep(4000);
		save.click();
	}

	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement addingLead;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveLead;

	public void leadCreation() {
		addingLead.click();
		firstName.sendKeys("Akshay");
		lastName.sendKeys("Kumar");
		saveLead.click();
	}

	@FindBy(xpath= "//div[@class='btn-group']/button[5]")
	private WebElement moreOptions;
	
	@FindBy(xpath= "//a[text()='Delete Lead']")
	private WebElement directDeleteLead;
	
	@FindBy(xpath= "//button[text()='Yes']")
	private WebElement confirmation;
	
	public void directLeadDeletion() {
		moreOptions.click();
		directDeleteLead.click();
		confirmation.click();
	}
	
	@FindBy(xpath= "//tr[td[span[span[a[text()='Akshay']]]]]/td[1]//input")
	private WebElement checkBox;
	
	@FindBy(id= "Leads_listView_massAction_LBL_DELETE")
	private WebElement deleteLead; 
	
	public void leadDeletion() {
		checkBox.click();
		deleteLead.click();
		confirmation.click();
	}
	
	
}