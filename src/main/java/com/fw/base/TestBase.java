package com.fw.base;

import com.fw.driver.Driver;

public class TestBase {

protected void setUp() {
    Driver.initDriver();
}


protected void tearDown() {
    Driver.closeDriver();
}



}
