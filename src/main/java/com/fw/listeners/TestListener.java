package com.fw.listeners;

import com.fw.reports.ExtentLogger;
import com.fw.reports.ExtentReport;
import com.fw.utils.ElkResultUtils;

import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
    ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
     ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " has passed");
        ElkResultUtils.postDetailsToElk(result.getMethod().getMethodName(), "pass");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " has failed");
        ElkResultUtils.postDetailsToElk(result.getMethod().getMethodName(), "fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " has skipped");
        ElkResultUtils.postDetailsToElk(result.getMethod().getMethodName(), "skip");
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
