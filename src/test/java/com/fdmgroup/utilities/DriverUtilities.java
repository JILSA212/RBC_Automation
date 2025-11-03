package com.fdmgroup.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fdmgroup.data.DataFile;

public class DriverUtilities {
	protected static DriverUtilities driverUtilities;
	public static WebDriver driver;
	
	protected DriverUtilities() {
		super();
	}
	
	public static DriverUtilities getInstance() {
		if(driverUtilities == null)
			driverUtilities = new DriverUtilities();
		
		return driverUtilities;
	}
	
	public WebDriver getDriver() {
		if(driver == null)
			createDriver();
		
		return driver;
	}
	
	public void createDriver() {
		String driverName = DataFile.browser;
		
		switch(driverName)
		{
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "msedge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid Driver Specified");
		}
	}
}
