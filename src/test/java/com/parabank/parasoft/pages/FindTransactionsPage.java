package com.parabank.parasoft.pages;

import com.parabank.parasoft.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindTransactionsPage extends BasePage {
    public FindTransactionsPage(WebDriver driver) {
        super(driver);
    }

    public FindTransactionsPage fillFromDate(String fromDate) {
        getWebElement(By.id("criteria.fromDate")).sendKeys(fromDate);
        return this;
    }

    public FindTransactionsPage fillToDate(String toDate) {
        getWebElement(By.id("criteria.toDate")).sendKeys(toDate);
        return this;
    }

    public TransactionResultsPage clickFindTransByDateRage() {
        getWebElement(By.cssSelector("[ng-click*='DATE_RANGE']")).click();
        return getInstance(TransactionResultsPage.class);
    }

}
