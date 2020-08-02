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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shopizer.qa.allureReportListener.AllureReportListener;
import com.shopizer.qa.pages.HomePage;
import com.shopizer.qa.testbase.BaseTest;
import com.shopizer.qa.utility.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({AllureReportListener.class})
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
	
	

	@Test(priority=1,description="Verifying title from Home page")
	@Severity(SeverityLevel.NORMAL)
	@Description("verify Title from HomePage")
	@Story("Shopizer Page Title verification")
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
