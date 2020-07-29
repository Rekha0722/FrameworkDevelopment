package com.shopizer.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopizer.qa.testbase.BaseTest;



public class SignupPage extends BaseTest {

	public  SignupPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Sign Up')]")
	WebElement hdrSignUp;
	
	
	@FindBy(xpath="//input[@id='CC-userRegistration-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='CC-userRegistration-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='CC-userRegistration-signupPhoneNum']")
	WebElement txtMobileNo;
	
	@FindBy(xpath="//input[@id='CC-userRegistration-emailAddress']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='CC-userRegistration-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='CC-userRegistration-confirmPassword']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//button[@id='CC-userRegistrationSubmit']")
	WebElement btnSubmit;
	
	
	
	
	public boolean verifyHeaderFromSignUpPage()
	{
		return hdrSignUp.isDisplayed();
	}
	
	public void createRegistrationFromSignUpPage(String fname,String lname,String mobileNo,String email,String pwd,String confirmPwd)
	{
		txtFirstName.sendKeys(fname);
		txtLastName.sendKeys(lname);
		txtMobileNo.sendKeys(mobileNo);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pwd);
		txtConfirmPassword.sendKeys(confirmPwd);
		btnSubmit.click();
		
	}
	
	
	
}
