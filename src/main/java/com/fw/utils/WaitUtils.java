package com.fw.utils;

import com.fw.constants.Constants;
import com.fw.driver.DriverManager;
import com.fw.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WaitUtils() {
    }

    public static void waitForElement(WaitStrategy wait, By locator) {
        if (wait == WaitStrategy.CLICKABLE) {
            new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitWait())
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if (wait == WaitStrategy.PRESENCE) {
            new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitWait())
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    }


}
