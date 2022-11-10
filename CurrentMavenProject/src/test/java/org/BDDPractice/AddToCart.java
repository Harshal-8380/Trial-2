package org.BDDPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.Utility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart extends BaseUtility {
	WebDriver driver;

	@Given("^user is on google chrome and is on \"([^\"]*)\" home page$")
	public void userIsOnChromeAndAmazonHomePage(String str) {
		driver = bUtil.setUp("chrome", str);
	}

	@When("^user serach for \"([^\"]*)\" and press Enter$")
	public void userSerachForSomethingAndPressEnter(String mobilePhone) {
		typeInput(driver, "name", "field-keywords", mobilePhone).sendKeys(Keys.ENTER);
		;
	}

	@Then("^user should go to samsung m13 page list$")
	public void userShouldGoToSamsungM13PageList() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.in : samsung m13", "Tilte does not match");
	}

	@When("^user click on 2nd visible phone then new window should open$")
	public void userClickOn2ndVisiblePhoneThenNewWindowShouldOpen() {
		clickOn(driver, "xpath", "(//span[@class='a-size-medium a-color-base a-text-normal'])[3]");
		String mainPage = driver.getWindowHandle();
		Set<String> allPages = driver.getWindowHandles();
		allPages.remove(mainPage);
		Iterator<String> itr = allPages.iterator();
		String page2 = itr.next();
		driver.switchTo().window(page2);

	}

	@And("^user click on Add to Cart$")
	public void userClickOnAddToCart() {
		clickOn(driver, "id", "add-to-cart-button");
		clickOn(driver,"id", "attach-close_sideSheet-link");
//		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		clickOn(driver, "id", "nav-cart-count-container");
	}

	@Then("^item should be added to cart$")
	public void itemShouldBeAddedToCart() {
		List<WebElement> cartItemList = driver.findElements(By.xpath("//div/div[2]/ul/li[1]/span/a/span/span/span[1]"));
		for (int i = 0; i < cartItemList.size(); i++) {
			if (cartItemList.get(i).getText().contains("Samsung Galaxy M13 5G (Aqua Green, 4GB, 64GB Storage) "+
														"| 5000mAh Battery | Upto 8GB RAM with RAM Plus")) {
				break;
			}
		}
	}
}
