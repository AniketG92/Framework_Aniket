package aniket.pages.com;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import aniket.utilities.com.BrowserFactory;
import aniket.utilities.com.Configuration;
import aniket.utilities.com.ExcelDataProvider;

public class BaseClass {
	
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public Configuration config;
	
	@BeforeSuite
	public void SetUpSuite()
	{
		excel=new ExcelDataProvider();
		config=new Configuration();
	}
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startapplication(driver, config.getBrowser(), config.getStagingUrl());
		try {
			
			Thread.sleep(2000);
		} 
		catch (Exception e)
		{
			System.out.println("Unable to access the page due to " + e.getMessage());
		}
	}
	
	@AfterClass
	public void teardown()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserFactory.quitapp(driver);
	}
}
