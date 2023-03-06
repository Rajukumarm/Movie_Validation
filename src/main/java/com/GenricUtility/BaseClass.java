package com.GenricUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseClass{
	public WebDriver driver=null;
	public WebdriverUtility wbLib=new WebdriverUtility();
	public FileUtility fLib=new FileUtility();
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		driver=wbLib.browser("Chrome");
		System.out.println("Browser is open");
		wbLib.maximizeWindow(driver);
		
	}
	@BeforeMethod
	public void openApplication() throws Throwable
	{
		String Url = fLib.readDataFromPropertyFile("url");
	driver.get(Url);	
	}
	@AfterMethod
	public void closeApplication()
	{
		System.out.println("Browser closed");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}