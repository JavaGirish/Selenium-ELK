package com.fw.base;

import com.fw.driver.Driver;
import com.fw.enums.ConfigProperties;
import com.fw.utils.PropertyFileReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

@BeforeMethod
protected void setUp() {
    Driver.initDriver(PropertyFileReader.getValue(ConfigProperties.BROWSER));
}

@AfterMethod
protected void tearDown() {
    Driver.closeDriver();
}



}
