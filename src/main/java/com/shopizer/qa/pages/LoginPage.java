package com.shopizer.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopizer.qa.testbase.BaseTest;

import io.qameta.allure.Step;



public class LoginPage extends BaseTest {

	public  LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h3[contains(text(),'Sign In')]")
	WebElement hdrSignIn;
	
	@FindBy(xpath="//input[@id='CC-login-input']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='CC-login-password-input']")
	WebElement txtPass;
	
	@FindBy(xpath="//button[@id='CC-userLoginSubmit']")
	WebElement btnSignIn;
	
	
	
	@Step("Verify SignInPage Header")
	public boolean verifySignInPageHeader()
	{
		return hdrSignIn.isDisplayed();
	}
	
	@Step("Set Email :{0} and Password :{1}")
	public void setLoginCredentials()
	{
		txtEmail.sendKeys(prop.getProperty("email"));
		txtPass.sendKeys(prop.getProperty("password"));
		btnSignIn.click();
	}
	
}
