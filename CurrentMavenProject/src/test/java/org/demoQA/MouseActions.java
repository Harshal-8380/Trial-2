package org.demoQA;

import org.Utility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions extends BaseUtility {
	static MouseActions obj = new MouseActions();
	WebDriver driver;

	public static void main(String[] args) {
//		obj.toolTip();
//		obj.drag_Drop();
//		obj.drag_Drop2();
		obj.copyPaste();
	}

	public void toolTip() {
		driver = bUtil.setUp("chrome", "https://demoqa.com/tool-tips");
		Actions act = new Actions(driver);// driver in constructor must not be null
		act.moveToElement(driver.findElement(By.id("toolTipTextField"))).perform();
		bUtil.printText(driver.findElement(By.cssSelector(".tooltip-inner")));
		System.out.println("toopTip done");
		driver.close();
	}

	public void drag_Drop() {
		driver = setUp("chrome", "https://demoqa.com/droppable");
		Actions act = new Actions(driver);// driver in constructor must not be null
		WebElement dragIt = driver.findElement(By.id("draggable"));
		WebElement dropHere = driver.findElement(By.id("droppable"));
		act.dragAndDrop(dragIt, dropHere).perform();
		System.out.println("drag_Drop done");
		driver.close();
	}

	public void drag_Drop2() {
		driver = setUp("chrome", "https://demoqa.com/droppable");
		Actions act = new Actions(driver);// driver in constructor must not be null
		WebElement dragIt = driver.findElement(By.id("draggable"));
		WebElement dropHere = driver.findElement(By.id("droppable"));
		act.clickAndHold(dragIt).moveToElement(dropHere).release().build().perform();
		System.out.println("drag_Drop2 done");
		driver.close();
	}
	
	public void copyPaste() {
		driver = setUp("chrome", "https://demoqa.com/text-box");
		Actions act = new Actions(driver);// driver in constructor must not be null
		clickOn(driver,"id","userName").sendKeys("Akshay");
		act.doubleClick(element).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		clickOn(driver,"id","userEmail");
		act.doubleClick(element).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

	}
}
