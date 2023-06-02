package MyTestNGPractice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass 
{
	
	@Test(retryAnalyzer=MyTestNGPractice.RetryListener.class)
	public void method1()
	{
		Assert.assertEquals("shilpa", "kittu");
	}

}
