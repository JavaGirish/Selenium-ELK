package com.fw.pages;

import com.fw.reports.ExtentLogger;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    private By txtEmail = By.id("Email");
    private By txtPassword = By.id("Password");
    private By btnLogin = By.xpath("//button[text()='Log in']");

    private By msgEmailError = By.id("Email-error");
    private By msgLoginUnsuccessful = By.xpath("//div[contains(@class,'summary-errors')]");

    public void enterEmail(String email) {
        sendKeys(txtEmail, email);
        ExtentLogger.pass("Entered user email: " +email);
    }

    public void enterPassword(String password) {
       sendKeys(txtPassword, password);
        ExtentLogger.pass("Entered user password: " +password);
    }

    public void clickLogin() {
        click(btnLogin);
        ExtentLogger.pass("Clicked on login button");
    }

    public String getInvalidLoginMessage() {
        return getText(msgLoginUnsuccessful);
    }

    public String getBlankEmailValidationMessage() {
        return getText(msgEmailError);
    }


}
