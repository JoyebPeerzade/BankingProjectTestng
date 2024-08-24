package com.framework.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	//will have common method to read data from Excel files 
	public static String[][] readData(String workbookname,String sheetName) {
		 String[][] data = null;
		
		 try {
			FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+"\\TestData\\"+workbookname); // read Excel file
			XSSFWorkbook wb = new XSSFWorkbook(fis); // pass file to workbook class
			XSSFSheet sh = wb.getSheet(sheetName); // read specific sheet from the workbook 
			int totalRows = sh.getPhysicalNumberOfRows();// get total rows having data
			int totalColums = sh.getRow(0).getPhysicalNumberOfCells(); // get total columns in each rows (row-1)
			 data = new String [totalRows-1] [totalColums]; // initiating the array with size as total rows -1 because 1 row having columns names
			 for(int r=1; r<totalRows; r++) {
				 for (int c=0; c<totalColums; c++) {
					 data [r-1][c] = sh.getRow(r).getCell(c).getStringCellValue(); // get the data from specific sheet, specific row, specific columns and covert is as String
				 }
			 }
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}

}
