package ScrollPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.BrowserUtil;

public class MyScrollPractice {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.amazon.in";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		Thread.sleep(5000);
		
		//scroll by pixels
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)", "");
		
		//scroll till visibility of element located
		WebElement requiredFooter = driver.findElement(By.xpath("//h2[contains(text(),'Today’s Deals')]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView();", requiredFooter);
		
		if(requiredFooter.isDisplayed())
		{
			System.out.println("Scroll to particular element done");
		}
		else
		{
			System.out.println("Scroll unsuccessful");
		}
		
		driver.quit();
		
		
		
		
	}

}
