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

public class DataDrivenMulti {

	
	public static void multi() throws IOException {
		
		File data = new File("C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\excel\\email and phoneNumber.xlsx");
		FileInputStream input = new FileInputStream(data);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheetAt(0);
		
		int NumberOfRows = sheet.getPhysicalNumberOfRows();
	for(int i =1;i<NumberOfRows;i++) {
		Row row = sheet.getRow(i);
		
		int NumberOfcells = row.getPhysicalNumberOfCells();
		for(int j =0;j<NumberOfcells;j++) {
			Cell cell = row.getCell(j);
			CellType cellType = cell.getCellType();
			
			if(cellType.equals(CellType.STRING)) {
				String stringValue = cell.getStringCellValue();
				System.out.println(stringValue);
			}
			else if(cellType.equals(CellType.NUMERIC)) {
				double number = cell.getNumericCellValue();
				System.out.println(number+""+'\n');
			}
		}
	}
}
	public static void main(String[] args) throws IOException
	{
		multi();
	}
}
