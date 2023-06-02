package ActionClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.BrowserUtil;

public class SpiceJetGetLinkDetails {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		String url = "https://www.spicejet.com/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		Thread.sleep(10000);
		
		By mainLocator = By.xpath("//div[text()='Add-ons']");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(mainLocator)).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> addOnItems = driver.findElements(By.xpath("(//div[@data-focusable='true'])[2]/following-sibling::div"));
		for(WebElement e: addOnItems)
		{
			System.out.println(e.getText());
		}

	}

}
