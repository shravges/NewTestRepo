import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFirefoxDriver {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\AutomationExes\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	}

}
