package com.shopizer.qa.testcases;

/***
 * @Author - Rekha Deshmane
 * 
 * 
 * 
 */
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopizer.qa.pages.HomePage;
import com.shopizer.qa.testbase.BaseTest;
import com.shopizer.qa.utility.TestUtil;


public class HomePageTest extends BaseTest{
	
	HomePage objHomePage;
	TestUtil objTestUtil;
	
	
	public HomePageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setUp()
	{
		initialization();
		//objHomePage=new HomePage();
		objTestUtil=new TestUtil();
		objHomePage=new HomePage();
	}
	
	

	@Test(priority=2)
	public void verifyHomePageTitle() throws IOException
	{
		String title=objHomePage.ValidateShopizerPageTitle();
		System.out.println(title);
		objTestUtil.takeScreenshotAtEndOfTest();
		
	}
	
	@AfterMethod
	public void tearDownEnvironment()
	{
		
		objHomePage=null;
		driver.close();
	}

}
