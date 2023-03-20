package org.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datapracticedriven {

	public static void singleData() throws InvalidFormatException, IOException {

		File data = new File("C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\excel\\email and phoneNumber.xlsx");
		FileInputStream input = new FileInputStream(data);
		Workbook book = new XSSFWorkbook(data);
		Sheet sheetAt = book.getSheetAt(0);
		Row row = sheetAt.getRow(0);
		Cell cell = row.getCell(0);
		CellType value = cell.getCellType();

		if(value.equals(CellType.STRING)) {
			String stringValue = cell.getStringCellValue();
			System.out.println("string Value: "+stringValue);
		}
		else if(value.equals(CellType.NUMERIC)) {
			double numericValue = cell.getNumericCellValue();
			System.out.println("numeric Value: "+numericValue);


		}


	}


	public static void multipleData() throws IOException {

		File data = new File("C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\excel\\email and phoneNumber.xlsx");
		FileInputStream input = new FileInputStream(data);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheetAt = book.getSheetAt(0);

		int totalrows = sheetAt.getPhysicalNumberOfRows();
		for(int i =1;i < totalrows;i++ ) {
			Row row=sheetAt.getRow(i);

			int totalcol = row.getPhysicalNumberOfCells();
			for(int j =0;j< totalcol;j++) {
				Cell cell = row.getCell(j);

				CellType ctype = cell.getCellType();

				if(ctype.equals(CellType.STRING)) {
					String stringvalue = cell.getStringCellValue();
					System.out.println("stringValues :"+stringvalue);
				}

				else if (ctype.equals(CellType.NUMERIC)) {
					double numericvalues = cell.getNumericCellValue();
					System.out.println("numericValue :"+numericvalues+'\n');

				}
			}

		}
	}

	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		multipleData();
		
	}
	
	
	
}
