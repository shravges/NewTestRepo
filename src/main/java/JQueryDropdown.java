import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;

public class JQueryDropdown {

	static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException
	{
		String url = "https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		By ddButton = By.xpath("(//button[starts-with(@id,'comboTree') and @class='comboTreeArrowBtn'])[1]");
		By ddSection = By.xpath("(//div[contains(@id,'DropDownContainer') and @class='comboTreeDropDownContainer'])[1]//span");
		By checkboxInDD = By.xpath("(//div[contains(@id,'DropDownContainer') and @class='comboTreeDropDownContainer'])[1]//span//input[@type='checkbox']");
		
		driver.findElement(ddButton).click();
		Thread.sleep(2000);
		
		//selectElementsJQueryDropdown(ddSection, "all");	
		
		//calling function from element util
		ElementUtil util = new ElementUtil(driver);
		util.selectElementsJQueryDropdown(ddSection, "all");
		
		//uncheck all the values
		util.deselectSelectedValues(checkboxInDD);
		
	}

	//vararg
	public static void selectElementsJQueryDropdown(By locator, String... valuesToBeSelected)
	{
		List<WebElement> ddOptions = getElements(locator);
		
		if(!(valuesToBeSelected[0]=="all"))
		{
		for(WebElement e:ddOptions)
		{
			for(int i=0;i<valuesToBeSelected.length;i++)
			{
				if((!(e.getText()=="−")))
				{
				if(e.getText().equals(valuesToBeSelected[i]))
				{
					e.click();
				}
				}
			}
		}
		}
		else
		{
			for(WebElement e:ddOptions)
			{
				System.out.println(e.getText());
				if(!(e.getText().equals("−")))
				{
				e.click();
				}
			}
			
		}
		
	}
	
	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	
	
	
	
}
