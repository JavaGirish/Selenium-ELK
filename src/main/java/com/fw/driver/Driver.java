package com.fw.driver;

import com.fw.constants.Constants;
import com.fw.enums.Browsers;
import com.fw.enums.ConfigProperties;
import com.fw.utils.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public final class Driver {

	private Driver() {
	}

	/*
	 * Method to Initialize Driver
	 */
	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {

			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				
				if (PropertyFileReader.getValue(ConfigProperties.RUNONGRID).equalsIgnoreCase("Yes")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.CHROME);
					cap.setPlatform(Platform.LINUX);
					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://13.233.136.251:4444/wd/hub"), cap));
					}

					catch (MalformedURLException e) {

						e.printStackTrace();
					}

				}

				else {
					DriverManager.setDriver(new ChromeDriver());
				}

			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {

				if (PropertyFileReader.getValue(ConfigProperties.RUNONGRID).equalsIgnoreCase("Yes")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.FIREFOX);
					cap.setPlatform(Platform.LINUX);
					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://13.233.136.251:4444/wd/hub"), cap));
					}

					catch (MalformedURLException e) {

						e.printStackTrace();
					}

				}

				else {
					DriverManager.setDriver(new FirefoxDriver());
				}

			}

		}

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMinutes(Constants.getPageloadWait()));
		DriverManager.getDriver().get(PropertyFileReader.getValue(ConfigProperties.URL));

	}

	/*
	 * Method to close browser instance
	 */
	public static void closeDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.removeDriver();
		}
	}

}
