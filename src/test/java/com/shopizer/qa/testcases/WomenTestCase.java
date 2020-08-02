package com.shopizer.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shopizer.qa.allureReportListener.AllureReportListener;
import com.shopizer.qa.pages.HomePage;
import com.shopizer.qa.testbase.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({AllureReportListener.class})
public class WomenTestCase extends BaseTest{
	
	HomePage objHomePage;
	LoginLogoutTest objLoginLogoutTest;
	public WomenTestCase() {
		// TODO Auto-generated constructor stub
		
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		//objLoginLogoutTest.verifyLoginUser();
		this.initializeViewsAndPages();
	}
	
	public void initializeViewsAndPages()
	{
		objHomePage=new HomePage();
		objLoginLogoutTest=new LoginLogoutTest();
	}
	
	@Test(priority=1,description="Clicking onWomen dropdown from Home Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Check Women dropdown is clicked or not")
	@Story("To check  women dropdown is clicked or not")
	public void clickOnWomenDropdown()
	{
		objHomePage.clickOnWomenDropdownFromHomwPage();
	}
	
	@Test(priority=2,description="verifying onWomen dropdown from Home Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("verifying Women dropdown")
	@Story("To check  women text verification")
	public void verifyWomenDropDown()
	{
		objHomePage.getWomenDropdownFromHomwPage();
	}
	
	@AfterMethod
	public void tearDownEnvironment()
	{
		objHomePage=null;
		driver.close();
	}

}
