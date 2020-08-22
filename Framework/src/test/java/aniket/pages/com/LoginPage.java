package aniket.pages.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@CacheLookup
	@FindBy(name="email") public static WebElement username;
	
	@CacheLookup
	@FindBy(name="password") public static WebElement pass;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]") public static WebElement Loginbutton;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[1]/span") public static WebElement HomeButton;
	
	public void logintocrm(String appuname,String passapp)
	{
		try {
			Thread.sleep(4000);
		}
		catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}
		
		username.sendKeys(appuname);
		pass.sendKeys(passapp);
		Loginbutton.click();
				
	}
	
	public String validateLogin()
	{
		HomeButton.click();
		if(driver.getCurrentUrl().equals("https://ui.freecrm.com/home"))
		{
			return "SUCCESS";
		}
		else
		{
			return "FAILURE";
		}
	}
	
}
