package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Utilities.BrowserUtil;

public class MouseHoverPractice {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		String url = "https://www.bigbasket.com/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		By mainCategoryLink = By.xpath("//a[@qa='categoryDD']");
		
		moveToElementInMultipleLevels(mainCategoryLink,"Beauty & Hygiene","Hair Care", "Hair Oil & Serum");
		
	}
	
	public static void moveToElementInMultipleLevels(By mainCategory, String category1, String category2, String category3) throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(mainCategory)).build().perform();
		Thread.sleep(1000);
		
		action.moveToElement(driver.findElement(By.linkText(category1))).build().perform();
		Thread.sleep(1000);
		
		action.moveToElement(driver.findElement(By.linkText(category2))).build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText(category3)).click();
		Thread.sleep(1000);
		
	}

}
