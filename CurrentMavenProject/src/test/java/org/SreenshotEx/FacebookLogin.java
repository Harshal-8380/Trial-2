package org.SreenshotEx;

import java.io.File;
import java.io.IOException;

import org.Utility.BaseUtility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FacebookLogin extends BaseUtility{
	public static void main(String[] args) throws IOException {
		WebDriver driver=bUtil.setUp("chrome","https://www.facebook.com");
		
		bUtil.takeScreenshot("Facebook_LoginPage");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(".\\Screenshots\\Demo.jpg"));
	}
}
