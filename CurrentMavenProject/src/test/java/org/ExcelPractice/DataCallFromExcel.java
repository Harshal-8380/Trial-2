package org.ExcelPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataCallFromExcel {
	public static void main(String[] args) throws IOException {
		String fileLocation = System.getProperty("user.dir") + ".\\src\\main\\resources\\TestData\\TestData.xlsx";

		FileInputStream fis = new FileInputStream(fileLocation);

		Workbook workbook = new XSSFWorkbook(fis);
		System.out.println("Number of sheets: " + workbook.getNumberOfSheets());

		Sheet sheet = workbook.getSheet("Sheet1");
		System.out.println("Name of Sheet: "+sheet.getSheetName());
		
		Row row= sheet.getRow(1);
		System.out.println("Number of cells: "+row.getPhysicalNumberOfCells());
		
		Cell cell = row.getCell(3);
		
		System.out.println("cell value: "+cell.getStringCellValue());

	}
}
