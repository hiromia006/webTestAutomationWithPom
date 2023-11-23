package com.parabank.parasoft.testcasses;

import com.parabank.parasoft.pages.FindTransactionsPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.pages.TransactionResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionResultsTest extends BaseTest {

    @Test
    public void findTransactionsByDateRangShouldSucceed() {
        OverviewPage overviewPage = page.getInstance(LoginPage.class)
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(overviewPage.hasLogoutLink());

        FindTransactionsPage findTransactionsPage = overviewPage
                .clickFindTransactionsLink()
                .fillFromDate("11-20-2023")
                .fillToDate("11-20-2023");

        TransactionResultsPage transactionResultsPage = findTransactionsPage
                .clickFindTransByDateRage();
        Assert.assertTrue(transactionResultsPage.hasResults());
    }

    @Test(enabled = false)
    public void findTransactionsByDateRangShouldSucceed_2() {
        TransactionResultsPage transactionResultsPage =
                page.getInstance(LoginPage.class)
                        .doLogin(getUsername(), getPassword())
                        .clickFindTransactionsLink()
                        .fillFromDate("11-20-2023")
                        .fillToDate("11-20-2023")
                        .clickFindTransByDateRage();
        Assert.assertTrue(transactionResultsPage.hasResults());
    }
}
