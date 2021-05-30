package com.fw.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public class ExtentReport {

private static ExtentReports extent;

    /* Method to initialize extent reports
    * */
    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Run Report");
            spark.config().setReportName("Heroku Suite");
        }

    }

    /* Method to flush extent reports
    * */
    public static  void flushReports() {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unloadTest();
    }


    public static void createTest(String testcasename) {

        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }

}
