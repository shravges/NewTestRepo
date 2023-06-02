import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;

public class MultiSelect {

	public static void main(String[] args) 
	{
		String url = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		By multiSelectDD = By.xpath("//select[@name='States' and @id='multi-select']");
		String[] states = {"California","Texas","Washington"};
		
		ElementUtil util = new ElementUtil(driver);
		util.selectMutipleDropdownValues(multiSelectDD, states);
		
		
//		Select select = new Select(driver.findElement(multiSelectDD));
//		boolean flag=false;
//		
//		System.out.println(select.isMultiple());
//		if(select.isMultiple())
//		{
//			for(String s:states)
//			{
//				select.selectByVisibleText(s);
//				flag=true;
//			}
//		}
//		if(!flag==true)
//		{
//			System.out.println("Provided values not available in dropdown");
//		}
		

	}

}
