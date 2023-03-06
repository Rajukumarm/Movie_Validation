package com.GenricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;

public class ExcelUtility {


	public void writeDataForImdbExcelFile(String date,String country) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPth);

		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("valid").getRow(1).getCell(0).setCellValue(date);
		wb.getSheet("valid").getRow(1).getCell(1).setCellValue(country);
		FileOutputStream fos= new FileOutputStream(IpathConstants.ExcelPth);
		wb.write(fos);
	}

	public void  writeDataForWikiExcelFile(String date,String origin) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPth);

		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("valid").getRow(1).getCell(2).setCellValue(date);
		wb.getSheet("valid").getRow(1).getCell(3).setCellValue(origin);
		FileOutputStream fos= new FileOutputStream(IpathConstants.ExcelPth);
		wb.write(fos);
		wb.close();
	}


	public String readDataFromExcel(String sheetName, int rowNum,int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPth);

		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
}
