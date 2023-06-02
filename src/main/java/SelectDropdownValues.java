import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;

public class SelectDropdownValues {

	public static void main(String[] args) 
	{
		String url = "https://demo.1crmcloud.com/login.php";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		By languageDropdown = By.xpath("//select[@id='login_lang']");
		By themeDropdown = By.id("login_theme");
		
		ElementUtil util = new ElementUtil(driver);
		
		//code to get all dd options
		List<String> options = util.getDropdownOptions(languageDropdown);
		System.out.println("Total languages available = " +options.size());
		System.out.println(options);
		
		util.selectDropdownByIndex(languageDropdown, 3);
		
		util.selectDropdownByVisibleText(themeDropdown, "Delight Theme");
		
		util.selectDropdownByValue(themeDropdown, "Spectrum");
		
//		
//		By dropdown = By.xpath("//select[@id='login_lang']");
//		Select select = new Select(driver.findElement(dropdown));
//		
//		List<WebElement> ddData = select.getOptions();
//		System.out.println("Total languages available = " +ddData.size());
//		ArrayList<String> ddOptions = new ArrayList<String>();
//		
//		for(WebElement e:ddData)
//		{
//			String text = e.getText();
//			ddOptions.add(text);
//		}
//		
//		System.out.println(ddOptions);
//		driver.quit();
		
	}

}
