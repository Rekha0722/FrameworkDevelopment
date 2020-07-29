package com.shopizer.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.shopizer.qa.utility.TestUtil;
import com.shopizer.qa.utility.WebEventListener;




public class BaseTest {
	
	public  static WebDriver driver;
	public  static Properties prop ;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	static Logger log=Logger.getLogger(BaseTest.class);
	
	public BaseTest()
	{
		try 
		{
		     prop = new Properties();
	         FileInputStream fis = new FileInputStream("F:\\UdymeSelenium\\FrameworkDevelopment\\src\\main\\java\\com\\shopizer\\qa\\config\\config.properties");
	         prop.load(fis);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static WebDriver initialization()
	{
			String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			Map<String, Object> prefs = new HashMap<String, Object>();

			//add key and value to map as follow to switch off browser notification
			//Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();

			// set ExperimentalOption - prefs 
			options.setExperimentalOption("prefs", prefs);
            log.info("Launching Browser");
			System.setProperty("webdriver.chrome.driver", "F:\\UdymeSelenium\\FrameworkDevelopment\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver(options);
			
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		     driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\IE Driver Server\\IEDriverServer.exe");  
	        driver=new InternetExplorerDriver();  
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		log.info("Maximize  window");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		log.info("******************************loading url**********************************");
		driver.get(prop.getProperty("url"));
		
		log.info(driver.getTitle());
		return driver;
	}
	
	

}
