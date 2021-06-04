package com.fw.tests;

import com.fw.base.TestBase;
import com.fw.constants.Constants;
import com.fw.driver.DriverManager;
import com.fw.enums.ConfigProperties;
import com.fw.listeners.TestListener;
import com.fw.pages.LoginPage;
import com.fw.utils.DataUtils;
import com.fw.utils.PropertyFileReader;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

@Listeners(TestListener.class)
public class LoginTest extends TestBase {

    @Test
    public void loginTestUsingValidData(Map<String,String> data) {
        LoginPage lp = new LoginPage();
        lp.enterEmail(data.get("email"));
        lp.enterPassword(data.get("password"));
        lp.clickLogin();
        Assertions.assertThat(DriverManager.getDriver().getTitle())
                .contains("Dashboard");

        }

    @Test
    public void loginTestUsingBlankEmail(Map<String,String> data) {
        LoginPage lp = new LoginPage();
        lp.enterEmail(data.get("email"));
        lp.enterPassword(data.get("password"));
        lp.clickLogin();
        Assertions.assertThat(lp.getBlankEmailValidationMessage())
                .contains(Constants.getBlankEmailMsg());

    }

    @Test
    public void loginTestUsingInvalidPassword(Map<String,String> data) {
        LoginPage lp = new LoginPage();
        lp.enterEmail(data.get("email"));
        lp.enterPassword(data.get("password"));
        lp.clickLogin();
        Assertions.assertThat(lp.getInvalidLoginMessage())
                .contains(Constants.getInvalidLoginMsg());

    }








}
