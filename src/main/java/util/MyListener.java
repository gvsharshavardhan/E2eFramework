package util;

import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ISuiteListener, ITestListener {

    @Override
    public void onStart(ISuite suite) {
        //on suite start
        //create report
        ReportManager.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        //flush report
        ReportManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.getExtentTest().pass("Testcase passed! :: "+ result.getMethod().getMethodName());
        String screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ReportManager.getExtentTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReportManager.getExtentTest().fail("Testcase failed! :: "+ result.getMethod().getMethodName());
        String screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ReportManager.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportManager.getExtentTest().skip("Testcase skipped! :: "+ result.getMethod().getMethodName());
    }
}
