import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;

public class DropdownWithoutSelectClass 
{

	public static void main(String[] args) 
	{
		String url = "https://demo.guru99.com/test/newtours/register.php";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		By countryDropdown = By.xpath("//select[@name='country']/option");
		
		ElementUtil util = new ElementUtil(driver);
		util.selectDropdownValueWithoutSelectClass(countryDropdown, "ANTARCTICA");		

	}

}
