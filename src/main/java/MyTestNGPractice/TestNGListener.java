package MyTestNGPractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener
{
	
	  public void onTestStart(ITestResult result) 
	  {
		   System.out.println("Test execution started for test case = " +result.getName());
	  }

		 
		  public void onTestSuccess(ITestResult result)
		  {
			  System.out.println("Test executed successfully = " +result.getName());
		  }

		 
		  public void onTestFailure(ITestResult result) 
		  {
		    System.out.println("Test failed =" +result.getName());
		  }

		  
		  public void onTestSkipped(ITestResult result) 
		  {
		   
		  }

		 
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  
		  public void onStart(ITestContext context) 
		  {
		 
		  }
	
	
	
	
	
	
}
