import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.BrowserUtil;

public class ActionsClassMyPractice {

	public static void main(String[] args) throws InterruptedException 
	{
		String url = "https://www.google.com/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"))).
//				build().perform();
		
//		Thread.sleep(3000);
		
//		WebElement lnkVisaServices = driver.findElement(By.xpath("//div[contains(text(),'Travel Assistance Services')]"));
//		lnkVisaServices.click();
		
//		if(lnkVisaServices.isDisplayed())
//		{
//			System.out.println("Visa services are available");
//		}
//		else
//		{
//			System.out.println("Visa services are not available");
//		}
		
		//right click
		action.contextClick().build().perform();
		
	}

}
