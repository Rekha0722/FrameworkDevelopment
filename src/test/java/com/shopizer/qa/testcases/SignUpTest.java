package com.shopizer.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.shopizer.qa.pages.HomePage;
import com.shopizer.qa.pages.SignupPage;
import com.shopizer.qa.testbase.BaseTest;
import com.shopizer.qa.utility.TestUtil;

public class SignUpTest extends BaseTest {
	
	String sheetName="Sheet1";
	HomePage objHomePage;
	SignupPage objSignUpPage;
	TestUtil objTestUtil;
	
	//Super class constructor
	public SignUpTest()
	{
		super();
	}
	
	//Initialization
	public void initializeViewsAndPages()
	{
		objHomePage=new HomePage();
		objTestUtil=new TestUtil();
		objSignUpPage=new SignupPage();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		this.initializeViewsAndPages();
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void verifyRegistration(String fname,String lname,String mobileNo,String email,String pwd,String confirmPwd)
	{
			objHomePage.clickOnSignUpLinkFromHomePage();
			objSignUpPage.verifyHeaderFromSignUpPage();
			objSignUpPage.createRegistrationFromSignUpPage(fname, lname, mobileNo, email, pwd, confirmPwd);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDownEnvironment()
	{
		objSignUpPage=null;
		objHomePage=null;
		objTestUtil=null;
		driver.close();
	}

}
