package ActionClass;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Utilities.BrowserUtil;

public class RightClickPractice {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		String url = "http://swisnl.github.io/jQuery-contextMenu/demo.html";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		driver.navigate().to(url);
	
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> listOfActions = driver.findElements(By.xpath("//ul[contains(@class,'context-menu-list ')]/li[contains(@class,'context-menu-icon')]"));
		System.out.println(listOfActions.size());
		for(WebElement e: listOfActions)
		{
			String elementText = e.getText();
			action.moveToElement(e).build().perform();
			System.out.println("Link clicked = " +elementText);
			e.click();
			Thread.sleep(7000);
			driver.switchTo().alert().accept();
			
			
//			String alertText =alert.getText();
//			System.out.println(alertText);
//			if(alertText.contains(elementText))
//			{
//				System.out.println("Alert text contains performed action =" +elementText);
//			}
		}
		
	}

}
