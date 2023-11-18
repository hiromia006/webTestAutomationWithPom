package com.parabank.parasoft.pages;

import com.parabank.parasoft.pages.base.BasePage;
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


}
