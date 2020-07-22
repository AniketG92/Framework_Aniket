package aniket.testcases.com;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import aniket.pages.com.BaseClass;
import aniket.pages.com.LoginPage;

public class LoginCRMTest extends BaseClass {

	
	@Test
	public void validatelogin()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.logintocrm(excel.getStringData("login",0,0), excel.getStringData("login",0,1));
		
	}
}
