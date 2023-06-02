import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.BrowserUtil;

public class AmazonTitleTest 
{
	
	static WebDriver driver;

	public static void main(String[] args) 
	{
		String url = "https://www.amazon.in/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		String[] column = {"Get to Know Us","Connect with Us","Make Money with Us","Let Us Help You"};
		List<String> getLinks = null;
		
		for(String s: column)
		{
			getLinks = getFooterLinkForColumns(s);
			System.out.println("Total links present for" + s + "are " +getLinks.size());
			System.out.println("Links are " + s +getLinks);
			getLinks.clear();
		}

	}
	
	public static List<String> getFooterLinkForColumns(String columnName)
	{
		List<WebElement> linksList = driver.findElements(By.xpath("//div[text()='"+columnName+"']/following-sibling::ul/child::li"));
		List<String> links = new ArrayList<String>();
		for(WebElement e: linksList)
		{
			links.add(e.getText());
		}
		return links;
	}
	
	

}
