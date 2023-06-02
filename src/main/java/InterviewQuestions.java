import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewQuestions {

	static WebDriver driver;
	public static void main(String[] args)
	{
		String country = "Germany";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilps\\.cache\\selenium\\chromedriver\\win32\\112.0.5615.49\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		String companyName = getCompanyName(country);
		System.out.println("Company name for country" +country + " is " +companyName);
		
		driver.quit();
	}
	
	public static String getCompanyName(String countryName)
	{
		String company = null;
		List<WebElement> countryList = driver.findElements(By.xpath("//td[text()='"+countryName+"']"));
		if(countryList.size() > 0)
		{
			System.out.println("Mentioned country is found in the table");
			company = driver.findElement(By.xpath("(//td[text()='"+countryName+"']//preceding-sibling::td)[last()-(last()-1)]")).getText();
		}
		else
		{
			System.out.println("Mentioned country is not found in the table");
		}
		
		return company;
		
	}

}
