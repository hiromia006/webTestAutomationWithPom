package com.parabank.parasoft.pages;

import com.parabank.parasoft.pages.base.BasePage;
import com.parabank.parasoft.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenNewAccountPage selectAccountType(int index) {
        new Select(getWebElement(By.id("type"))).selectByIndex(index);
        return this;
    }

    public OpenNewAccountPage selectAccountType(String text) {
        new Select(getWebElement(By.id("type"))).selectByVisibleText(text);
        return this;
    }

    public OpenNewAccountPage clickOpenAccountBtn() {
        General.waitForDomStable();
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    public boolean hasNewOpenAccountId() {
        return getWebElements(By.id("newAccountId")).size() > 0;
    }
}
