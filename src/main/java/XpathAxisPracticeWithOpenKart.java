import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utilities.BrowserUtil;

public class XpathAxisPracticeWithOpenKart
{
	static WebDriver driver;

	public static void main(String[] args) 
	{
		String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		String expectedEmailText ="E-Mail Address";
		String expectedPasswordText = "Password";
		String expectedLinkText="Forgotten Password";
		
		String actualEmailText = driver.findElement(By.xpath("//input[@name='email']/preceding-sibling::label[@class='control-label']")).getText();
		String actualPasswordText = driver.findElement(By.xpath("//input[@name='password']/preceding-sibling::label[@class='control-label']")).getText();
		String actualLinkText = driver.findElement(By.xpath("//input[@name='password']/following-sibling::a")).getText();
		
//		Assert.assertEquals(expectedEmailText, actualEmailText);
//		Assert.assertEquals(expectedPasswordText, actualPasswordText);
//		Assert.assertEquals(expectedLinkText, actualLinkText);
		
		System.out.println(compareData(expectedEmailText, actualEmailText));
		System.out.println(compareData(expectedPasswordText, actualPasswordText));
		System.out.println(compareData(expectedLinkText, actualLinkText));
	}
	
	
	public static boolean compareData(String expected, String actual)
	{
		if(expected.equalsIgnoreCase(actual))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
