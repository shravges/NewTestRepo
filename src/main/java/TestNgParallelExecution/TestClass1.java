package TestNgParallelExecution;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.BrowserUtil;

public class TestClass1 
{
	@Test(groups= {"regression"})
	public void loadAmazon()
	{
		String url = "https://www.amazon.in/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		System.out.println(Thread.currentThread().getName());
		System.out.println("Launched successfully" +url);
		bUtil.maximizeBrowserWindow();
	    bUtil.quitBrowserWindow();
	}
	
	@Test(groups= {"sanity"})
	public void loadGoogle()
	{
		String url = "https://www.google.com/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		System.out.println(Thread.currentThread().getName());
		System.out.println("Launched successfully" +url);
		bUtil.maximizeBrowserWindow();
		bUtil.quitBrowserWindow();
		
	}
	
	
	
	
	
}
