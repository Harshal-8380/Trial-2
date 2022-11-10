package org.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	String fileLocation;
	FileInputStream fis;

	public ExcelUtility(String fileLocation) {
		this.fileLocation = fileLocation;
		try {
			fis = new FileInputStream(this.fileLocation);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cell selectCell(int sheetNumber, int rowNumber, int cellnumber) {
		cell = workbook.getSheetAt(sheetNumber).getRow(rowNumber).getCell(cellnumber);
		return cell;
	}

	public void printCellValue(int sheetNumber, int rowNumber, int cellNumber) {

		cell = workbook.getSheetAt(sheetNumber).getRow(rowNumber).getCell(cellNumber);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			System.out.println(cell.getStringCellValue());
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				sdf.format(cell);
			} else {
				System.out.println((int) cell.getNumericCellValue());
			}
			break;
		case BOOLEAN:
			System.out.println(cell.getBooleanCellValue());
			break;
		case FORMULA:
			System.out.println(cell.getCellFormula());
			break;
		case BLANK:
			System.out.println("cell is blank");
			break;
		case ERROR:
			System.out.println("cell contains error");
			break;
		case _NONE:
			System.out.println("cell not available");
			break;
		default:
			System.out.println("invalid cell type");
		}
	}

	public void printCellValue(String sheetName, int rowNumber, int cellNumber) {

		cell = workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			System.out.println(cell.getStringCellValue());
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				sdf.format(cell);
			} else {
				System.out.println((int) cell.getNumericCellValue());
			}
			break;
		case BOOLEAN:
			System.out.println(cell.getBooleanCellValue());
			break;
		case FORMULA:
			System.out.println(cell.getCellFormula());
			break;
		case BLANK:
			System.out.println("cell is blank");
			break;
		case ERROR:
			System.out.println("cell contains error");
			break;
		case _NONE:
			System.out.println("cell not available");
			break;
		default:
			System.out.println("invalid cell type");
			break;
		}
	}

	public void setValueToCell(Cell cell, String text) {
		try {
			cell.setCellValue(text);
			FileOutputStream fos = new FileOutputStream(fileLocation);
			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueToCell(Cell cell, double value) {
		try {
			cell.setCellValue(value);
			FileOutputStream fos = new FileOutputStream(fileLocation);
			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueToCell(Cell cell, Date date) {
		try {
			cell.setCellValue(date);
			FileOutputStream fos = new FileOutputStream(fileLocation);
			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueToCell(Cell cell, Calendar value) {
		try {
			cell.setCellValue(value);
			;
			FileOutputStream fos = new FileOutputStream(fileLocation);
			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueToCell(Cell cell, int value) {
		try {
			cell.setCellValue(value);
			;
			FileOutputStream fos = new FileOutputStream(fileLocation);
			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueToCell(Cell cell, long value) {
		try {
			cell.setCellValue(value);
			;
			FileOutputStream fos = new FileOutputStream(fileLocation);
			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
