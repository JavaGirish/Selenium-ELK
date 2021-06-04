package com.fw.listeners;

import com.fw.enums.ConfigProperties;
import com.fw.utils.PropertyFileReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 2;

    public boolean retry(ITestResult result) {

        if (PropertyFileReader.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("Yes")

                && counter < retryLimit) {
            counter++;
            return true;
        }


        return false;
    }


}
