package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtil 
{	
	WebDriver driver;
		
	/**
	 * this function initialize the browser
	 * @param driverType  - type of the driver to be initialized
	 * @return driver of the browser
	 */
	public WebDriver initializeDriver(String driverType)
	{
		System.out.println("Checking driver for initialization");
		switch(driverType)
		{
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilps\\.cache\\selenium\\chromedriver\\win32\\112.0.5615.49\\chromedriver.exe");
			//ChromeOptions co = new ChromeOptions();
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\AutomationExes\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			break;
		default:
			System.out.println("Please supply correct browser");		
		
		}
		return driver;
	}
	
	/**
	 * This function launch the given URL
	 * @param url -- URL of the website to be launched
	 */
	public void launchURL(String url)
	{
		if(url==null)
		{
			//System.out.println("Please throw custom error");
			throw new SeleniumCustomException("NULLURLEXCEPTION");
		}
		driver.get(url);
	}
	
	/**
	 * This function gets title of the website
	 * @return - title of the website
	 */
	public String getWebsiteTitle()
	{
		return driver.getTitle();
	}
	
	/**
	 * This function maximizes browser window
	 */
	public void maximizeBrowserWindow()
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This function makes browser screen as full screen
	 */
	public void fullScreenBrowserWindow()
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This function closes the browser
	 */
	public void quitBrowserWindow()
	{
		driver.quit();
	}
		
	
}
