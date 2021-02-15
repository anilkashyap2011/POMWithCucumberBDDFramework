package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basepage.BasePage;
import utilities.ExtentReportor;

public class Listeners extends BasePage implements ITestListener{
	
	WebDriver driver = null;
	ExtentReports extentReports = ExtentReportor.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentThreadSafe = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReports.createTest(testName+"Execution started");
		extentThreadSafe.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		extentTest.log(Status.PASS, "Test Passed");
		extentThreadSafe.get().log(Status.PASS, "Test Passed"); 
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		String testName = result.getName();
	//	extentTest.fail(result.getThrowable());
	//	extentThreadSafe.get().fail(result.getThrowable());
	//	extentTest.log(Status.FAIL, result.getThrowable());
		extentThreadSafe.get().log(Status.FAIL, result.getThrowable());
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String screenshotFilePath = takeScreenshots(testName,driver);
			extentThreadSafe.get().addScreenCaptureFromPath(screenshotFilePath, testName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	

}
