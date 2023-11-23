package com.parabank.parasoft.pages;

import com.parabank.parasoft.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasLogoutLink() {
        return getWebElements(By.linkText("Log Out")).size() > 0;
    }

    public OpenNewAccountPage clickOpenNewAccountLink() {
        getWebElement(By.linkText("Open New Account")).click();
        return getInstance(OpenNewAccountPage.class);

    }

    public FindTransactionsPage clickFindTransactionsLink() {
        getWebElement(By.linkText("Find Transactions")).click();
        return getInstance(FindTransactionsPage.class);
    }
}
