import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetLinksFromPageSection 
{
	static WebDriver driver;
	
	public static void main(String[] args) 
	{
		String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilps\\.cache\\selenium\\chromedriver\\win32\\111.0.5563.64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(url);
		
		//1. check if 13 elements are there on web page
		By links = By.xpath("//a[@class='list-group-item']");
		List<WebElement> linksList = getElements(links);
		if(linksList.size()==13)
		{
			System.out.println("Total 13 links present. PASS");
		}
		else
		{
			System.out.println("Issue with links. FAIL");
		}
	
		//utility to get attribute name of with find elements
		List<String> attributeValueList = getElementsAttribute(links, "href");
		System.out.println(attributeValueList);
		
		//utility to get text from all the links
		List<String> linksTextList = getElementsText(links);
		if(linksTextList.contains("My Account"))
		{
			System.out.println("Required link present on UI");
		}
		
		//get all the links mentioned in footer
		By footerLinks = By.xpath("//footer//a");
		List<String> footerLinksList = getElementsText(footerLinks);
		System.out.println(footerLinksList);
		
		
	}

	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);	
	}
	
	public static List<String> getElementsAttribute(By locator, String attributeName)
	{
		List<WebElement> elementList = getElements(locator);
		List<String> attributesList = new ArrayList<String>();
		
		for(WebElement e: elementList)
		{
			attributesList.add(e.getAttribute(attributeName));
		}
		return attributesList;
	}
	
	public static List<String> getElementsText(By locator)
	{
		List<WebElement> elementList = getElements(locator);
		List<String> linksTextList = new ArrayList<String>();
		
		for(WebElement e:elementList)
		{
			linksTextList.add(e.getText());
		}
		return linksTextList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
