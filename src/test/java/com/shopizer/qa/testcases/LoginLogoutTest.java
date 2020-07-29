package com.shopizer.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopizer.qa.pages.HomePage;
import com.shopizer.qa.pages.LoginPage;
import com.shopizer.qa.pages.SignupPage;
import com.shopizer.qa.testbase.BaseTest;

public class LoginLogoutTest extends BaseTest{
	
	LoginPage objLoginPage;
	HomePage objHomePage;
	
	public LoginLogoutTest()
	{
		super();
	}
	
	public void InitializePages()
	{
		
		objLoginPage=new LoginPage();
		objHomePage=new HomePage();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		this.InitializePages();
	}

	@Test
	public void verifyLoginUser()
	{
		objHomePage.clickOnSignInLinkFromHomePage();
		objLoginPage.verifySignInPageHeader();
		objLoginPage.setLoginCredentials();
		objHomePage.RegisteredUserNameOnHomePage();
	}
	
	
	@AfterMethod
	public void tearDownEnvironment()
	{
		objLoginPage=null;
		objHomePage=null;
		driver.close();
	}
}
