import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.BrowserUtil;

public class GoogleSearch 
{
	static WebDriver driver;
	
	public static void getSearchSuggestions(By searchLocator, String searchKey, By suggestions, String selectSuggestion)
	{
		try
		{
		driver.findElement(searchLocator).sendKeys(searchKey);
		
		Thread.sleep(3000);
		
		List<WebElement> suggestionList = driver.findElements(suggestions);
		System.out.println("Total suggestions found for " + searchKey+ " = " +suggestionList.size());
		
		for(WebElement e:suggestionList)
		{
			if(e.getText().contains(selectSuggestion))
			{
				System.out.println("Required suggestion found");
				e.click();
				break;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) 
	{
		String url = "https://www.amazon.in/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		//bUtil.fullScreenBrowserWindow();
		
		//google search locators
//		By searchLocator = By.name("q");
//		String searchKey = "Selenium";
//		By suggestions = By.xpath("//div[contains(@class,'wM6W7d')]/span");
//		String selectSuggestion = "Selenium webdriver";
		
		//amazon search locators
		By searchLocator = By.id("twotabsearchtextbox");
		String searchKey = "women";
		By suggestions = By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']");
		String selectSuggestion = "kurta";
				
		getSearchSuggestions(searchLocator, searchKey, suggestions, selectSuggestion);
		
		
		//trying code with utility
//		ElementUtil eu = new ElementUtil(driver);
//		eu.getSearchSuggestions(searchLocator, searchKey, suggestions, selectSuggestion);
			
	}

}
