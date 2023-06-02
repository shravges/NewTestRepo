package WebTablePagination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.BrowserUtil;

public class NextButtonPaginationPractice 
{

	public static void main(String[] args) throws InterruptedException
	{
		String url = "https://www.lambdatest.com/selenium-playground/table-data-download-demo";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		String name = "Shilpa Shravge";
		
//		if(driver.findElement(By.xpath("//table[@id='example']")).isDisplayed())
//		{
//			int i =1;
//			System.out.println("Table displayed");
//			while(true)
//			{
//			
//			if(driver.findElements(By.xpath("//td[contains(text(),'"+name+"')]")).size() > 0)
//			{
//				System.out.println("Given name shown in web table on page no: " + i);
//				break;
//			}
//			else
//			{
//				//System.out.println("Given name not shown in current web table view. Clicking next button");
//				if(!(driver.findElements(By.cssSelector("a[id='example_next'][class$='disabled']")).size() > 0))
//				{
//				driver.findElement(By.xpath("//a[@id='example_next']")).click();
//				Thread.sleep(1000);
//				}
//				else
//				{
//					System.out.println("Given name not found in web table");
//					break;
//				}
//			}
//			i++;
//			}
//		}
//		else
//		{
//			System.out.println("Table not displayed");
//		}
//
//		driver.quit();
		
		
		//navigation with page numbers
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		int i=1;
		while(i<=totalPages)
		{
			if(driver.findElements(By.xpath("//td[contains(text(),'"+name+"')]")).size() > 0)
				{
					System.out.println("Given name shown in web table on page no: " + i);
					break;
				}
				else
				{
					//System.out.println("Given name not shown in current web table view. Clicking next button");
					if(!(driver.findElements(By.cssSelector("a[id='example_next'][class$='disabled']")).size() > 0))
					{
					driver.findElement(By.xpath("(//div[@id='example_paginate']/span/a)["+ (i+1) +"]")).click();
					Thread.sleep(1000);
					}
					else
					{
						System.out.println("Given name not found in web table");
						break;
					}
				}
				i++;
				}
		}
	
}
