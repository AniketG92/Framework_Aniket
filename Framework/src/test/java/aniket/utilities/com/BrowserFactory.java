package aniket.utilities.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	

	public static WebDriver startapplication(WebDriver driver, String Browser, String Url)
	{
		
		if(Browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(Browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", ".\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We don't support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitapp(WebDriver driver)
	{
		driver.close();
	}
	

}
