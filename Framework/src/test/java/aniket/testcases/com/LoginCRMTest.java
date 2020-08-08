package aniket.testcases.com;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import aniket.pages.com.BaseClass;
import aniket.pages.com.LoginPage;

public class LoginCRMTest extends BaseClass {

	
	@Test(priority=1)
	public void validatelogin()
	{
		logger=report.createTest("Login To CRM");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Start Application");
		
		loginpage.logintocrm(excel.getStringData("login",0,0), excel.getStringData("login",0,1));
		
		logger.pass("Login Success");
		
	}
	
	@Test(priority=2)
	public void validateloginsuccess()
	{
		logger=report.createTest("Landing to CRM Home Page");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Home Page viewable");
		
		if(loginpage.validateLogin().equals("SUCCESS"))
		{
			logger.pass("Home Page Validation Success");
		}
		else if(loginpage.validateLogin().equals("FAILURE"))
		{
			logger.fail("Home Page Validation Failed");
		}
			
	}
}
