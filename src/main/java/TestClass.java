import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;


public class TestClass {
	
	public static void main(String[] args) 
	{
		try
		{
		String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
			
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilps\\.cache\\selenium\\chromedriver\\win32\\111.0.5563.64\\chromedriver.exe");
//		ChromeOptions co = new ChromeOptions();
//		WebDriver driver = new ChromeDriver();
//		String path = SeleniumManager.getInstance().getDriverPath(co);
//		System.out.println(path);
		//driver.get("https://naveenautomationlabs.com/opencart/");
//		driver.manage().window().maximize();
//		driver.manage().window().fullscreen();
		
		By lnkRegister = By.linkText("Register");
		By txtbxFname= By.id("input-firstname");
		By txtbxLname = By.id("input-lastname");
		By txtbxEmail = By.id("input-email");
		By txtbxPhone = By.id("input-telephone");
		By txtbxPassword = By.id("input-password");
		By txtbxConfirmPassword = By.id("input-confirm");
		By chkbxConfirm = By.name("agree");
		By btnContinue = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By headerConfirmation = By.tagName("h1");
		
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		bUtil.fullScreenBrowserWindow();
		
		String websitTitle = bUtil.getWebsiteTitle();
		if(websitTitle.equalsIgnoreCase("Account Login"))
		{
			System.out.println("Website launched successfully");
		}
		else
		{
			System.out.println("Website not launched successfully");
		}
		
		//fill registration form
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doClick(lnkRegister);
		
		Thread.sleep(3000);
		
		if(bUtil.getWebsiteTitle().equalsIgnoreCase("Register Account"))
		{
			System.out.println("Register page loaded successfully");
			elementUtil.doSendKeys(txtbxFname, "shilpa");
			elementUtil.doSendKeys(txtbxLname, "s");
			elementUtil.doSendKeys(txtbxEmail, "s4@gmail.com");
			elementUtil.doSendKeys(txtbxPhone, "123");
			elementUtil.doSendKeys(txtbxPassword, "s@123");
			elementUtil.doSendKeys(txtbxConfirmPassword, "s@123");
			
			//get attribute of all the text fields
			System.out.println("Attribute for first name field=" +elementUtil.getAttributeValue(txtbxFname, "placeholder"));
			System.out.println("Attribute for last name field=" +elementUtil.getAttributeValue(txtbxLname, "placeholder"));
			System.out.println("Attribute for email name field=" +elementUtil.getAttributeValue(txtbxEmail, "placeholder"));
			System.out.println("Attribute for phone field=" +elementUtil.getAttributeValue(txtbxPhone, "placeholder"));
			System.out.println("Attribute for password field=" +elementUtil.getAttributeValue(txtbxPassword, "placeholder"));
			System.out.println("Attribute for confirm password field=" +elementUtil.getAttributeValue(txtbxConfirmPassword, "placeholder"));
			
			//get data entered by user in email fields
			System.out.println("Data entered as email by user=" +elementUtil.getAttributeValue(txtbxEmail, "value"));
			
			elementUtil.doClick(chkbxConfirm);
			elementUtil.doClick(btnContinue);
			
			Thread.sleep(2000);
			
			//String confirmationText = elementUtil.doGetText(headerConfirmation);
			//if(confirmationText.equalsIgnoreCase("Your Account Has Been Created!"))	
			if(elementUtil.checkElementDisplayed(headerConfirmation))
			{
				System.out.println("Account created successfully");
			}
			
		}
		else
		{
			System.out.println("Register page not loaded successfully");
		}
	
		bUtil.quitBrowserWindow();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
