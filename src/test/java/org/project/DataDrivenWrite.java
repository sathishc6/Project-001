package org.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWrite {

	
	public static void main (String[] args) throws IOException {
		
		File data = new File("C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\excel\\email and phoneNumber.xlsx");
		FileInputStream input = new FileInputStream(data);
		Workbook book = new  XSSFWorkbook(input);
		
		//book.createSheet("skal").createRow(0).createCell(0).setCellValue("Name");
		book.getSheet("skal").getRow(0).createCell(1).setCellValue("phone number");
		book.getSheet("skal").createRow(1).createCell(0).setCellValue("skal");
		book.getSheet("skal").getRow(1).createCell(1).setCellValue(1234);
		book.getSheet("skal").getRow(0).createCell(2).setCellValue("Email");
		FileOutputStream out = new FileOutputStream(data);
		book.write(out);
		System.out.println("done");
		
		
		
		
		
		
		
		
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
}
