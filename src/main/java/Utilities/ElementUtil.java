package Utilities;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil 
{
	private WebDriver driver;
	
	//constructor to initialize the coming WebDriver as a class variable - driver
	public ElementUtil(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//locate the element
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	//click on particular element
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	//send text in a textbox
	public void doSendKeys(By locator, String data)
	{
		if(data==null)
		{
			System.out.println("Data cannot be null");
			throw new SeleniumCustomException("NULLDATAEXCEPTION");
		}
		doClearText(locator);
		getElement(locator).sendKeys(data);
	}

	//clear the text
	public void doClearText(By locator)
	{
		getElement(locator).clear();
	}
	
	//get text
	public String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	
	//is displayed
	public boolean checkElementDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}	
	
	//get attribute
	public String getAttributeValue(By locator, String attribute)
	{
		return getElement(locator).getAttribute(attribute);	
	}
	
	//get elements
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);	
	}
	
	//get attribute values with find elements
	public List<String> getElementsAttribute(By locator, String attributeName)
	{
		List<WebElement> elementList = getElements(locator);
		List<String> attributesList = new ArrayList<String>();
		
		for(WebElement e: elementList)
		{
			attributesList.add(e.getAttribute(attributeName));
		}
		return attributesList;
	}
	
	//get element text with find elements
	public List<String> getElementsText(By locator)
	{
		List<WebElement> elementList = getElements(locator);
		List<String> linksTextList = new ArrayList<String>();
		
		for(WebElement e:elementList)
		{
			linksTextList.add(e.getText());
		}
		return linksTextList;
	}
	
	public void getSearchSuggestions(By searchLocator, String searchKey, By suggestions, String selectSuggestion)
	{
		try
		{
		doSendKeys(searchLocator,searchKey);
		Thread.sleep(3000);
		
		List<WebElement> suggestionList = getElements(suggestions);
		System.out.println("Total suggestions found for " + searchKey+ " = " +suggestionList.size());
		
		if(suggestionList.size() >0)
		{
		for(WebElement e:suggestionList)
		{
			String text = e.getText(); 
			if(text.length() >0)
			{
			if(text.contains(selectSuggestion))
			{
				System.out.println("Required suggestion found");
				e.click();
				break;
			}
			}
			else
			{
				System.out.println("Blank suggestions found for given search criteria" +selectSuggestion);
				break;
			}
		}
		}
		else
		{
			System.out.println("No suggestion found for given search criteria" +selectSuggestion);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public void selectDropdownByIndex(By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void selectDropdownByVisibleText(By locator, String visibleText)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public void selectDropdownByValue(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public List<String> giveDropdownData(By locator)
	{
		Select select = new Select(getElement(locator));
		List<String> ddData = new ArrayList<String>();
		List<WebElement> ddOption = select.getOptions();
		for(WebElement e: ddOption)
		{
			ddData.add(e.getText());	
		}
		return ddData;
	}
	
	public void deselectDropdownByIndex(By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.deselectByIndex(index);
	}
	
	public void deselectDropdownByVisibleText(By locator, String visibleText)
	{
		Select select = new Select(getElement(locator));
		select.deselectByVisibleText(visibleText);
	}
	
	public void deselectDropdownByValue(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.deselectByValue(value);
	}
	
	public void deselectDropdownAll(By locator)
	{
		Select select = new Select(getElement(locator));
		select.deselectAll();
	}	
	
	public List<String> getDropdownOptions(By locator)
	{
		Select select = new Select(getElement(locator));
		List<WebElement> ddElements = select.getOptions();
		List<String> ddOptions = new ArrayList<String>();
		
		if(ddElements==null)
		{
			System.out.println("issue with dropdown");
		}
		else
		{
		for(WebElement e: ddElements)
		{
			ddOptions.add(e.getText());
		}
		}
		return ddOptions;
	}
	
	public void selectDropdownValueWithoutSelectClass(By locator, String valueToBeSelected)
	{
	
		List<WebElement> ddElements = getElements(locator);
		
		if(ddElements==null)
		{
			System.out.println("issue with dropdown");
		}
		else
		{
		for(WebElement e: ddElements)
		{
			if(e.getText().equalsIgnoreCase(valueToBeSelected))
			{
				e.click();
				break;
			}
		}
		}
	}
	
	public void selectMutipleDropdownValues(By locator, String[] valuesToBeSelected)
	{
		Select select = new Select(getElement(locator));
		boolean flag=false;
		
		System.out.println(select.isMultiple());
		if(select.isMultiple())
		{
			for(String s:valuesToBeSelected)
			{
				select.selectByVisibleText(s);
				flag=true;
			}
		}
		if(!flag==true)
		{
			System.out.println("Provided values not available in dropdown");
		}
		
	}
	
		//vararg
		public void selectElementsJQueryDropdown(By locator, String... valuesToBeSelected)
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
	
	
		public void deselectSelectedValues(By locator)
		{
			List<WebElement> selectedElements = getElements(locator);
			boolean flag = false;
			for(WebElement e:selectedElements)
			{
				if(e.isSelected())
				{
					e.click();
					flag = true;
				}
			}
			if(!(flag==true))
			{
				System.out.println("No value was selected in given locator");
			}
		}
		
		
		
		
}
