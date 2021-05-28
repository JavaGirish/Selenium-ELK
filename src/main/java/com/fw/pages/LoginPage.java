package com.fw.pages;

import com.fw.driver.DriverManager;
import org.openqa.selenium.By;

public class LoginPage {

    private By txtEmail = By.id("Email");
    private By txtPassword = By.id("Password");
    private By btnLogin = By.xpath("//button[text()='Log in']");

    public void enterEmail(String email) {
        DriverManager.getDriver().findElement(txtEmail).clear();
        DriverManager.getDriver().findElement(txtEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        DriverManager.getDriver().findElement(txtPassword).clear();
        DriverManager.getDriver().findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        DriverManager.getDriver().findElement(btnLogin).click();
    }


}
