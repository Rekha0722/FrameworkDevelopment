package com.shopizer.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shopizer.qa.allureReportListener.AllureReportListener;
import com.shopizer.qa.pages.HomePage;
import com.shopizer.qa.pages.LoginPage;
import com.shopizer.qa.pages.SignupPage;
import com.shopizer.qa.testbase.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({AllureReportListener.class})
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

	@Test(priority=1,description="Verifying login ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("verify login Page Functionality")
	@Story("Verify login with registered User NAame")
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
