package com.fw.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.fw.base.TestBase;
import com.fw.constants.Constants;
import com.fw.driver.DriverManager;
import com.fw.pages.LoginPage;


public final class LoginTest extends TestBase {

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
