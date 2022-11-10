package org.demoQA;

import org.Utility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToFrameEx extends BaseUtility {
	public static SwitchToFrameEx obj = new SwitchToFrameEx();
	static WebDriver driver;

	public static void main(String[] args) {
		driver = BaseUtility.bUtil.setUp("chrome", "https://demoqa.com/");
		bUtil.clickOn(driver, "xpath", "//h5[text()='Alerts, Frame & Windows']");
//		obj.singleFrame();
		obj.nestedFrames();
	}

	public void singleFrame() {
		clickOn(driver, "xpath", "//span[text()='Frames']");
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println("Text : " + driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().defaultContent();
	}

	public void nestedFrames() {
		clickOn(driver, "xpath", "//span[text()='Nested Frames']");
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println("Frame 1 : " + driver.findElement(By.xpath("//body[text()='Parent frame']")).getText());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
		System.out.println("Frame 2 : " + driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());
		driver.switchTo().parentFrame();
		System.out.println("Frame 1 : " + driver.findElement(By.xpath("//body[text()='Parent frame']")).getText());
		driver.switchTo().defaultContent();

	}

}
