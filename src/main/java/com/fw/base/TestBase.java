package com.fw.base;

import com.fw.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

@BeforeMethod
protected void setUp() {
    Driver.initDriver();
}

@AfterMethod
protected void tearDown() {
    Driver.closeDriver();
}



}
