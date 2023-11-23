package com.parabank.parasoft.testcasses;

import com.parabank.parasoft.pages.FindTransactionsPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.pages.TransactionResultsPage;
import com.parabank.parasoft.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionResultsTest extends BaseTest {

    @Test
    public void findTransactionsByDateRangShouldSucceed() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        Assert.assertEquals(loginPage.getPageTittle(), ParaBankString.LOGIN_TITTLE);

        OverviewPage overviewPage = loginPage
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();
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
                        .fillUsername(getUsername())
                        .fillPassword(getPassword())
                        .clickLoginBtn()
                        .clickFindTransactionsLink()
                        .fillFromDate("11-20-2023")
                        .fillToDate("11-20-2023")
                        .clickFindTransByDateRage();
        Assert.assertTrue(transactionResultsPage.hasResults());
    }
}
