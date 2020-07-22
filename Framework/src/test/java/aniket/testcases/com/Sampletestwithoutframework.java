package aniket.testcases.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sampletestwithoutframework {
	
	WebDriver driver;
	
	@Test
	public void testwithoutframework() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement username=driver.findElement(By.name("email"));
		username.sendKeys("aniket.ghosh2104@icloud.com");
		WebElement pass=driver.findElement(By.name("password"));
		pass.sendKeys("Ani@1992");
		WebElement Loginbutton=driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		Loginbutton.click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
