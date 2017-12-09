package Generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	
	BaseTest bt=new BaseTest();

	@Override
	public void onTestStart(ITestResult result) {	}

	@Override
	public void onTestSuccess(ITestResult result) {	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getName();
				bt.takeScreenshots(testMethodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
				
	}

	@Override
	public void onStart(ITestContext context) {
			
	}

	@Override
	public void onFinish(ITestContext context) {
			
	}
	

}
