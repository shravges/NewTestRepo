package XpathPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BrowserUtil;

public class WebTableSelectorsHub 
{
	static WebDriver driver;
	
	public static void main(String[] args) 
	{
		String url = "https://selectorshub.com/xpath-practice-page/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		
		selectEmployee("John.Smith");
		selectEmployee("Kevin.Mathews");
		
		String employee= "Joe.Root";
		System.out.println("Employee" +employee+ " details =" +getEmployeeDetails(employee));
		
		employee = "Jordan.Mathews";
		System.out.println("Employee" +employee+ " details =" +getEmployeeDetails(employee));

	}
	
	public static void selectEmployee(String empName)
	{
		driver.findElement(By.xpath("//a[text()='"+empName+"']/parent::td/preceding-sibling::td/child::input[@type='checkbox']")).click();
	}

	
	public static List<String> getEmployeeDetails(String empName)
	{
		List<String> empDetails=new ArrayList<String>();
		
		for(int i=1;i<=3;i++)
		{
			empDetails.add(driver.findElement(By.xpath("//a[text()='"+empName+"']/parent::td/following-sibling::td["+i+"]")).getText());
		}
		return empDetails;
		
	}
	
	
	
	
	
	
	
}
