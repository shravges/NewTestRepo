import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.BrowserUtil;

public class DragAndDropWithActionClass {

	public static void main(String[] args) 
	{
	
		String url = "https://jqueryui.com/droppable/";
		//getting driver from browser util class
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initializeDriver("chrome");
		bUtil.launchURL(url);
		bUtil.maximizeBrowserWindow();
		driver.switchTo().frame(0);
		
		WebElement fromElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement toElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions action = new Actions(driver);
		action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		

	}

}
