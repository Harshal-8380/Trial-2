package org.Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {
	public static BaseUtility bUtil = new BaseUtility();
	public WebDriver driver;
	public static WebDriverWait wait;
	public Select select;
	public WebElement element;
	public List<WebElement> list;

	public WebDriver setUp(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser name");
		}
		driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(450,600));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return driver;
	}

	public void maxWin() {
		driver.manage().window().maximize();
	}

	public WebElement typeInput(WebDriver driver, String finderType, String locator, String keyword) {
		if (finderType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locator));
		} else if (finderType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locator));
		} else if (finderType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locator));
		} else if (finderType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locator));
		} else if (finderType.equalsIgnoreCase("className")) {
			element = driver.findElement(By.className(locator));
		} else if (finderType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locator));
		} else if (finderType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locator));
		} else if (finderType.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locator));
		} else {
			System.out.println("Invalid Selection");
		}
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(keyword);
		return element;
	}

	public WebElement clickOn(WebDriver driver, String finderType, String locator) {
		if (finderType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locator));
		} else if (finderType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locator));
		} else if (finderType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locator));
		} else if (finderType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locator));
		} else if (finderType.equalsIgnoreCase("className")) {
			element = driver.findElement(By.className(locator));
		} else if (finderType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locator));
		} else if (finderType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locator));
		} else if (finderType.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locator));
		} else {
			System.out.println("Invalid Selection");
		}
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		return element;
	}

	public void printPageSource() {
		String pageSource = driver.getPageSource();
		System.out.println("Page Source : " + pageSource);
	}

	public void selectDropdown(WebElement element) {
		this.element = element;
		select = new Select(element);
	}

	public void getAllOptions(WebElement element) {
		list = select.getOptions();
	}

	public void printAllFromSelectDropdown(WebElement element) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
	}

	public void selectByName(String name) {
		select.selectByValue(name);
	}

	public void selectByIndex(int i) {
		select.selectByIndex(i);
	}

	public void gotoStartOfPage() {
		element = driver.findElement(By.cssSelector("html>body"));
		element.sendKeys(Keys.HOME);
	}

	public void pageDownBy(int times) {
		element = driver.findElement(By.cssSelector("html>body"));
		for (int i = 0; i < times; i++) {
			element.sendKeys(Keys.PAGE_DOWN);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pageUpBy(int times) {
		element = driver.findElement(By.cssSelector("html>body"));
		for (int i = 0; i < times; i++) {
			element.sendKeys(Keys.PAGE_UP);
		}
	}

	public void gotoEndOfPage() {
		element = driver.findElement(By.cssSelector("html>body"));
		element.sendKeys(Keys.END);
	}

	public void tearDown() {
		driver.close();
	}

	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void printText(WebElement element) {
		System.out.println(element.getText());
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void verifyTitle(String pageTitle) {
		String ActualPageTitle = bUtil.getPageTitle();
		if (ActualPageTitle.contains(pageTitle)) {
			System.out.println("Page title matches");
		} else {
			System.out.println("Page title does not match");
		}
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void verifyUrl(String pageUrl) {
		String ActualPageUrl = bUtil.getPageUrl();
		if (ActualPageUrl.contains(pageUrl)) {
			System.out.println("Url matches");
		} else {
			System.out.println("Url does not match");
		}
	}

	public void takeScreenshot(String fileName) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(".\\Screenshots\\" + fileName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pressTheKey(String key) {
		switch (key) {
		case "Enter":
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);
			break;
		case "Tab":
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
			break;
		default:
			System.out.println("Invalid Key");
			break;
		}
	}
}
