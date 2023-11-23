package com.parabank.parasoft.pages;

import com.parabank.parasoft.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionResultsPage extends BasePage {
    public TransactionResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasResults() {
        return getWebElements(By.cssSelector("#transactionTable tbody tr")).size() > 0;
    }
}
