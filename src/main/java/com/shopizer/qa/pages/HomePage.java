package com.shopizer.qa.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopizer.qa.testbase.BaseTest;



public class HomePage extends BaseTest{

	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement lnkSignUp;
	
	@FindBy(xpath="//a[@id='CC-loginHeader-login']")
	WebElement lnkSignIn;
	
	@FindBy(xpath="//span//a[@id='CC-track-order-text']")
	WebElement lnkTrackYourOrder;
	
	@FindBy(xpath="//span//a[@id='CC-track-order-text']")
	WebElement txtSearch;
	
	@FindBy(xpath="//span//a[@id='CC-track-order-text']")
	WebElement logoShopizer;
	
	@FindBy(xpath="//a[@class='customer_points_container']//span")
	WebElement  lnkRegisteredUnamePoint;
	
	@FindBy(xpath="//a[@id='CC-loginHeader-logout']")
	WebElement lnkSignout;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateShopizerPageTitle()
	{
		/*Alert alert=driver.switchTo().alert();
		alert.dismiss();*/
		return driver.getTitle();
		
		
	}
	
	public boolean validateDecathlonLogoFromHomePage()
	{
		return logoShopizer.isDisplayed();
	}
	

	public void clickOnSignUpLinkFromHomePage()
	{
		lnkSignUp.click();
			
	}
	
	public void clickOnSignInLinkFromHomePage()
	{
		lnkSignIn.click();
			
	}
	
	public void clickOnSignOutLinkFromHomePage()
	{
		lnkSignout.click();
			
	}
	
	public String RegisteredUserNameOnHomePage()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='customer_points_container']//span")));
	String Str=lnkRegisteredUnamePoint.getText();
	System.out.println("Registered user is " +Str);
	return Str;
	}
}
