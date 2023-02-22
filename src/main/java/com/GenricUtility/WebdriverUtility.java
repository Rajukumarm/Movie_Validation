package com.GenricUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	static WebDriver driver;
	public WebDriver browser(String browserTag) {
		if(browserTag.equalsIgnoreCase("Chrome"))
		{
			driver =new ChromeDriver();
		}
		else if (browserTag.equalsIgnoreCase("FireFox"))
		{

			driver=new FirefoxDriver();
		}
		else {
			System.out.println("No such driver");
		}
		return driver;
	}
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,800);");
	}
	public void imPlicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void scrollingBar(WebDriver driver,int y) {
		JavascriptExecutor jLib=(JavascriptExecutor)driver;
		jLib.executeScript("window.scrollBy(0,"+y+")");
	}
	
	public void getOption(WebElement element) {
		Select s=new Select(element);
		List<WebElement> allOption = s.getOptions();
		for(WebElement option:allOption) {
			String text=option.getText();
			System.out.println(text);
		}
	}
}
