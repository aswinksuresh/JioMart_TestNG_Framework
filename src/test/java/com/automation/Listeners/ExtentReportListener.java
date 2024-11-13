package com.automation.Listeners;

import com.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
   ExtentReports extentReports;
   ExtentSparkReporter sparkReporter;
   ExtentTest extentTest;
   boolean isLoaded= false;
    public void onTestStart(ITestResult result) {
        extentTest=extentReports.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"Test Passed");
        extentTest.log(Status.INFO,"screenshot",
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshotAsBase64()).build());
    }



    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL,"Test Failed");
        extentTest.log(Status.INFO,"screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.takeScreenshotAsFile()).build());
    }


    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,"Test Skipped");
    }







    public void onStart(ITestContext context) {
        if (!isLoaded){
            extentReports=new ExtentReports();
            sparkReporter = new ExtentSparkReporter("Extent-Report/extent-report.html");
            sparkReporter.config().setReportName("TestNg Automation Report");
            extentReports.attachReporter(sparkReporter);
            isLoaded =true;
        }

    }


    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
