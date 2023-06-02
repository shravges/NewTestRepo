package MyTestNGPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(MyTestNGPractice.TestNGListener.class)
public class ListenerPractice
{
	
	@Test
	public void method1_execution()
	{
		Assert.assertEquals("shilpa", "shilpa");
	}
	
	@Test
	public void method2_execution()
	{
		Assert.assertEquals("shilpa", "kittu");
	}
	

}
