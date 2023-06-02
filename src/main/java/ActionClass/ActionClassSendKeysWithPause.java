package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.BrowserUtil;

public class ActionClassSendKeysWithPause {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		WebElement txtbxSearch = driver.findElement(By.xpath("//input[@name='search']"));
		
		Actions action = new Actions(driver);
		action.sendKeys(txtbxSearch, "macbookair").pause(1000).build().perform();
		
		

	}

}
