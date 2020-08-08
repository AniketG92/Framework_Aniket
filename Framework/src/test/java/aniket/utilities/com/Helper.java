package aniket.utilities.com;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Helper {
	
		
	public static String CaptureScreenshot(WebDriver driver,String Screenshotname)
	{
		
		TakesScreenshot scrnsht=((TakesScreenshot)driver);
		File src=scrnsht.getScreenshotAs(OutputType.FILE);
		
		String screenshotpath;
		
		screenshotpath=System.getProperty("user.dir")+"./Screenshots/"+Screenshotname+"_"+getCurrentDateTime()+".png";
		
		File dest=new File("./Screenshots/"+Screenshotname+"_"+getCurrentDateTime()+".png");
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return screenshotpath;
	}
	
	 public static String getCurrentDateTime()
	 {
		 DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		 Date currentdate=new Date();
		 return customformat.format(currentdate);
	 }

}
