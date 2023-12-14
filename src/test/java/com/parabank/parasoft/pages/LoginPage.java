package com.parabank.parasoft.pages;

import com.parabank.parasoft.pages.base.BasePage;
import com.parabank.parasoft.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(String username) {
        getWebElement(By.name("username")).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        getWebElement(By.name("password")).sendKeys(password);
        return this;
    }

    public OverviewPage clickLoginBtn() {
        getWebElement(By.xpath("//input[@class='button']")).click();
        return getInstance(OverviewPage.class);
    }

    public LoginPage clickLoginButton() {
        getWebElement(By.xpath("//input[@class='button']")).click();
        return this;
    }

    public OverviewPage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

    public LoginPage doLogin() {
        return clickLoginButton();
    }

    public LoginPage doLogin(String username) {
        return fillUsername(username)
                .clickLoginButton();
    }

    public boolean hasError() {
        return getWebElements(By.className("error")).size() > 0;
    }

    public RegisterPage clickRegistrationLink(){
        General.waitForDomStable();
        getWebElement(By.linkText("Register")).click();
        return getInstance(RegisterPage.class);
    }


}
