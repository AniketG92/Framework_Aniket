package aniket.utilities.com;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	
	Properties pro;
	public Configuration()
	{
		File src=new File(".\\Config\\Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e)
		{
			System.out.println("Configuration File is not available or corrupted >" + e.getMessage());
		}
	}
	
	public String getStagingUrl()
	{
		return pro.getProperty("URL");
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}

}
