package org.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	
	public static void main(String[] args) throws IOException {
		
		File data =  new File("C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\excel\\email and phoneNumber.xlsx");
		FileInputStream write = new FileInputStream(data);
		Workbook book = new XSSFWorkbook(write);
		Sheet sheetAt = book.getSheet("Email and PhoneNumbers");
		Row row = sheetAt.getRow(5);
		Cell cell = row.getCell(2);
		CellType datatype = cell.getCellType();
//		for (int i = 1; i <= 1; i++) {
//			for (int j = 0; j < args.length; j++) {
//				String string = args[j];
//				
//			}
//		}
		if(datatype.equals(CellType.STRING)) {
			
			String stringValue = cell.getStringCellValue();
			System.out.println("String Value: "+stringValue);
		}
		
		else if(datatype.equals(CellType.NUMERIC)) {
			
			double numericValue = cell.getNumericCellValue();
			int num = (int) numericValue;
			System.out.println("numeric Value: "+num);
			
		}
}
}
