package org.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Prac_dataDriven {
	
	public static void main(String[] args) throws IOException {
		
		singleMulti();
	}

	
	  public static void singleMulti() throws IOException {
		  
		  File data = new File ("C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\excel\\email and phoneNumber.xlsx");
		  FileInputStream input = new FileInputStream(data);
		  Workbook book = new XSSFWorkbook(input);
		  Sheet sheet = book.getSheetAt(0);
		  
		  int tottalrow = sheet.getPhysicalNumberOfRows();
		  for(int i =1;i<tottalrow;i++) {
			  Row row = sheet.getRow(i);
			  
			  int tottalcells = row.getPhysicalNumberOfCells();
			  for(int j =0;j<tottalcells;j++) {
				  Cell cell = row.getCell(j);
				  CellType cellType = cell.getCellType();
				  
				  if(cellType.equals(CellType.STRING)) {
					  String alpha = cell.getStringCellValue();
					  System.out.println(alpha);
				  }
				  else if (cellType.equals(CellType.NUMERIC)) {
					  double numericCellValue = cell.getNumericCellValue();
					  int INT = (int)numericCellValue;
					  System.out.println(INT+""+'\n');
				  }
			  }
		  }
	 
//			book.createSheet("Email and PhoneNumbers").createRow(0).createCell(0).setCellValue("Name");
//			book.getSheet("Email and PhoneNumbers").getRow(0).createCell(1).setCellValue("phone number");
			book.getSheet("Email and PhoneNumbers").createRow(1).createCell(0).setCellValue("skal");
			book.getSheet("Email and PhoneNumbers").getRow(1).createCell(1).setCellValue(1234);
//			book.getSheet("Email and PhoneNumbers").getRow(0).createCell(2).setCellValue("Email");
			FileOutputStream out = new FileOutputStream(data);
			book.write(out);
			System.out.println("done");
	  
	  
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
