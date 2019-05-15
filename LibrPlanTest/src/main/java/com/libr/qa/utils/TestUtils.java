package com.libr.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.libr.qa.base.TestBase;

public class TestUtils extends TestBase {
	
	public static int ImpliciteWait = 10;
	public static int PageLoadTimeout = 20;
	
	public static String TEST_DATASHEET_PATH="C:/Users/Sunil/workspace/LibrPlanTest/src/main"
			+ "/java/com/libr/qa/testdata/TestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTetData(String sheetName)
	{
		FileInputStream fp = null;
		
		try
		{
			fp = new FileInputStream(TEST_DATASHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.getMessage();
		}
		
		try
		{
			book  = WorkbookFactory.create(fp);
			
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		
		System.out.println("********"+sheetName);
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		int l = sheet.getLastRowNum();
		for(int i =0;i< l;i++)
		{
			int k = sheet.getRow(0).getLastCellNum();
			for(int j = 0 ; j < k ; j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString(); 
				System.out.println(data[i][j]);
			}
		}
		
		return data;
	}
	
	public static void mouseHover(WebElement elemenet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemenet).build().perform();;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	String CurrentDiv = System.getProperty("user.dir");
	
	FileUtils.copyFile(scr, new File(CurrentDiv+"\\screenshots\\" +System.currentTimeMillis()+".png"));
	

	}

}
