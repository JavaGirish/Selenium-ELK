package com.fw.driver;

import com.fw.constants.Constants;
import com.fw.enums.Browsers;
import com.fw.enums.ConfigProperties;
import com.fw.utils.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private  Driver() { }


    /* Method to Initialize Driver
    * */
    public static void initDriver(String browser) {
        if(Objects.isNull(DriverManager.getDriver())) {

            if(browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                DriverManager.setDriver(driver);


            }
            else if(browser.equalsIgnoreCase(Browsers.FIREFOX.name())){
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver();
                DriverManager.setDriver(driver);

            }

        }


        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMinutes(Constants.getPageloadWait()));
        DriverManager.getDriver().get(PropertyFileReader.getValue(ConfigProperties.URL));


    }

    /* Method to close browser instance
    * */
    public static void closeDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.removeDriver();
        }
    }

}
