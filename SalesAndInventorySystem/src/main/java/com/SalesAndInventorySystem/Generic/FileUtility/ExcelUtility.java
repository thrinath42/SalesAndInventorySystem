package com.SalesAndInventorySystem.Generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int row,int cell) throws Exception {
		FileInputStream fis=new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	public int getNumericDataFromExcel(String sheetName,int row,int cell) throws Exception {
		FileInputStream fis=new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int data=(int) wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet(sheetName).getLastRowNum();
		return count;
		
	}
	
	public void addDatatoExcel(String sheetName,int row,int cell,String Data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(Data);
		
		FileOutputStream fos=new FileOutputStream("./TestData/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
	}

}
