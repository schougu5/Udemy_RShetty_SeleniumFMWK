package testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {

	public WebDriver driver;
	
	public ExtentTest test;
	public ExtentReports exReport = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> Thre_Test = new ThreadLocal<ExtentTest>(); // thread safe
	
	@Override
	public void onTestStart(ITestResult result) {
			
		test = exReport.createTest(result.getMethod().getMethodName());
		Thre_Test.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//test.log(Status.PASS, "ITestListeners says-Test case is PASSED");
				 
		Thre_Test.get().log(Status.PASS, "ITestListeners says-Test case is PASSED");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//Thre_Test.get().log(Status.FAIL,"ITestListeners says-Test case is FAILED");
		Thre_Test.get().fail(result.getThrowable()); // this shows the list of error messages
		
	
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String ScrshotPath = null;
		
		try {
			ScrshotPath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thre_Test.get().addScreenCaptureFromPath(ScrshotPath, result.getMethod().getMethodName());
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		exReport.flush();
	}
	
	
	

}
