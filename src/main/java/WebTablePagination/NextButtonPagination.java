package WebTablePagination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.BrowserUtil;

public class NextButtonPagination {

	public static void main(String[] args) throws InterruptedException 
	{
		
		String url = "https://selectorshub.com/xpath-practice-page/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		WebElement requiredElement = driver.findElement(By.xpath("(//h2[contains(text(),'System Distribution Details')])[last()]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", requiredElement);
		
		Thread.sleep(4000);
		
		String countryToBeSearched = "Ukraine";
		
		while(true)
		{
			if(driver.findElements(By.xpath("//td[contains(text(),'"+countryToBeSearched+"')]")).size() > 0)
			{
				driver.findElement(By.xpath("//td[contains(text(),'"+countryToBeSearched+"')]/preceding-sibling::td/input[@type='checkbox']")).click();
				System.out.println("Mentioned country has found in the table and clicked too");
				break;
			}
			else
			{
				if(!(driver.findElements(By.cssSelector("a[class$=disabled][id$='next']")).size() > 0))
				{
					driver.findElement(By.xpath("//a[(text()='Next')]")).click();
					Thread.sleep(1000);
					
				}
				else
				{
					System.out.println("Mentioned country not found in the table");
					break;
				}
			
			}
		}
		
		//driver.quit();
		
		}

	
	
	
	
	
	
}
