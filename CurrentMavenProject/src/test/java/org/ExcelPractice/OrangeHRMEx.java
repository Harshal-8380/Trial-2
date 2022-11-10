package org.ExcelPractice;

import java.io.IOException;

import org.Utility.BaseUtility;
import org.Utility.ExcelUtility;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrangeHRMEx extends BaseUtility {
	static String fileLocation = System.getProperty("user.dir") + "./src/main/resources/TestData/TestData.xlsx";
	public static ExcelUtility excel = new ExcelUtility(fileLocation);
	public static void main(String[] args) throws IOException {
		
//		excel.printCellValue(0, 5, 1);
		Cell webPage=excel.selectCell(0,3,1);
		Cell un= excel.selectCell(0,3,2);
		Cell pwd=excel.selectCell(0,3,3);
	
		String url=webPage.getStringCellValue();
		String userName=un.getStringCellValue();
		String password=pwd.getStringCellValue();
		
		WebDriver driver= bUtil.setUp("chrome", url);
		bUtil.typeInput(driver,"name","username",userName).sendKeys(Keys.TAB);
		bUtil.typeInput(driver,"name","password",password).sendKeys(Keys.ENTER);
	}
}
