package com.shopizer.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.shopizer.qa.testbase.BaseTest;

public class TestUtil extends BaseTest {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH = "F:\\UdymeSelenium\\FrameworkDevelopment\\src\\main\\java\\com\\shopizer\\qa\\testdata\\RPA.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	/*
	 * 
	NOTE : If you want future date : Pass  No of Future day 's value as positive int   i.e. 5  
	If you want Back date : Pass  No of Future day 's value as Negative . i.e. -5

	 *  @Method		: getFutureDateInSpecifiedFormat
	 * @Description	: This method takes parameter of your required DateFormat Type Like: dd-mm-YYYY OR DD.MM.YYYY
	 * 					and in return it will give you Future date in specified date format
	 * @param1		: dateFormat like : dd-MM-YYYY
	 * @param2		: No Of Future Day from now
	 * @author		: Pranay
	 * 
	 * i.e. : if you call getFutureDateInSpecifiedFormat("DD-MM-YYYY",5)
	 *  then it will return future date (current date + next 5 days)
	 *  
		NOTE : If you want future date : Pass  No of Future day 's value as positive int   i.e. 5  
		If you want Back date : Pass  No of Future day 's value as Negative . i.e. -5
 
	 */
	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param :
	 *            timeUnitSeconds - wait time seconds
	 */
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param :
	 *            timeUnitSeconds - wait time seconds
	 */
	public boolean waitFor(String timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(Integer.parseInt(timeUnitSeconds), TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	public String getFutureOrBackDateInSpecifiedFormat(String dateFormat, int NoOfFutureDay) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, NoOfFutureDay);
		String futureDate = new SimpleDateFormat(dateFormat).format(c.getTime()).toString();
		return futureDate;
	}
	/**
	 * @Method : switchToFrameUsingNameOrId
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :
	 *            frameName - Name/Id of frame you want to switch
	 * @author : Automation Tester
	 */
	public boolean switchToFrameUsingNameOrId(String frameName) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(frameName);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @Method : switchToFrameUsingIndex
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :
	 *            index - Index on page
	 * @author : Automation Tester
	 */
	public boolean switchToFrameUsingIndex(int index) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(index);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @Method : switchToDefaultContent
	 * @Description : This method will switch you to the default Window
	 * @author : Automation Tester
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
					for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			
				
					
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				
				
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
