package org.BDDPractice;

import org.Utility.BaseUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch extends BaseUtility {
	WebDriver driver;

	@Given("^User is in chrome browser and is on google home page$")
	public void userIsOnGoogle() {
		driver = bUtil.setUp("chrome", "https://www.google.com");
	}

	@When("^user search for (.+)$")
	public void userSearchFor(String keywords) {
		bUtil.typeInput(driver,"name","q",keywords);
		bUtil.pressTheKey("Enter");
	}

	@Then("^user should get relevant search results$")
	public void userShouldGetRelevantSearchResults() {
		String title=bUtil.getPageTitle();
		Assert.assertEquals(title, "top 10 richest person in the world - Google Search","Tilte not matching");
	}

}
