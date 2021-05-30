package com.fw.tests;

import com.fw.base.TestBase;
import com.fw.driver.Driver;
import com.fw.enums.ConfigProperties;
import com.fw.listeners.TestListener;
import com.fw.pages.LoginPage;
import com.fw.utils.PropertyFileReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SampleTest extends TestBase {

    @Test
    public void sample() {
        LoginPage lp = new LoginPage();
        lp.enterEmail(PropertyFileReader.getValue(ConfigProperties.EMAIL));
        lp.enterPassword(PropertyFileReader.getValue(ConfigProperties.PASSWORD));

        }


}
