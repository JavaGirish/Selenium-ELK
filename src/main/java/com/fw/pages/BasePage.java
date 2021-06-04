package com.fw.pages;

import com.fw.driver.DriverManager;
import com.fw.enums.WaitStrategy;
import com.fw.utils.WaitUtils;
import org.openqa.selenium.By;

public class BasePage {

    /* Method to click on an element
    @param: locator (By)
    * */
    protected void click(By locator){
        WaitUtils.waitForElement(WaitStrategy.CLICKABLE, locator);
        DriverManager.getDriver().findElement(locator).click();
    }

    /* Method to input text value in an field
    * */
    protected void sendKeys(By locator, String text){
        WaitUtils.waitForElement(WaitStrategy.PRESENCE, locator);
        DriverManager.getDriver().findElement(locator).clear();
        DriverManager.getDriver().findElement(locator).sendKeys(text);
    }


    protected String getText(By locator){
        WaitUtils.waitForElement(WaitStrategy.PRESENCE, locator);
        return DriverManager.getDriver().findElement(locator).getText();
    }




}
