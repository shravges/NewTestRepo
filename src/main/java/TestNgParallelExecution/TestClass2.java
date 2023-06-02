package TestNgParallelExecution;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.BrowserUtil;

public class TestClass2 
{
	@Test(groups= {"regression"})
	public void loadLokmat()
	{
		String url = "https://www.lokmat.com/";
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
