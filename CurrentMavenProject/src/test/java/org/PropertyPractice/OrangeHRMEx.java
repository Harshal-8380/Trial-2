package org.PropertyPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.Utility.BaseUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrangeHRMEx extends BaseUtility{
	public static void main(String[] args) throws IOException {
		String fileLocation= System.getProperty("user.dir")+"./src/main/resources/TestData/OrangeHRM.properties";
		FileInputStream fis = new FileInputStream(fileLocation);
		Properties prop = new Properties();
		prop.load(fis);
		WebDriver driver = bUtil.setUp("chrome",prop.getProperty("url"));
		
		bUtil.typeInput(driver,"name","username",prop.getProperty("userName")).sendKeys(Keys.TAB);
		bUtil.typeInput(driver,"name","password",prop.getProperty("password")).sendKeys(Keys.ENTER);
		System.out.println(bUtil.getPageTitle());
		bUtil.verifyTitle(prop.getProperty("defaultPageTitle"));
		System.out.println(bUtil.getPageUrl());
		bUtil.verifyUrl(prop.getProperty("defaultPageUrl"));
	}
}
