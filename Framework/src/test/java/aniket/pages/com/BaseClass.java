package aniket.pages.com;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import aniket.utilities.com.BrowserFactory;
import aniket.utilities.com.Configuration;
import aniket.utilities.com.ExcelDataProvider;
import aniket.utilities.com.Helper;

public class BaseClass {
	
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public Configuration config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void SetUpSuite()
	{
		excel=new ExcelDataProvider();
		config=new Configuration();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		
		report=new ExtentReports();
		report.attachReporter(extent);
		
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
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
				
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver, "LoginPage_PASS")).build());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.CaptureScreenshot(driver, "LoginPage_FAILURE");
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver, "LoginPage_FAIL")).build());
		}
		
		report.flush();
	}
}
