package com.parabank.parasoft.testcasses;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OpenNewAccountPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void openCheckingAccountShouldSucceed() {
        OverviewPage overviewPage = page.getInstance(LoginPage.class)
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(overviewPage.hasLogoutLink());

        OpenNewAccountPage openNewAccountPage = overviewPage
                .clickOpenNewAccountLink()
                .clickOpenAccountBtn();
        Assert.assertTrue(openNewAccountPage.hasNewOpenAccountId());
    }

    @Test
    public void openSavingAccountShouldSucceed() {
        OverviewPage overviewPage = page.getInstance(LoginPage.class)
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(overviewPage.hasLogoutLink());

        Assert.assertTrue(overviewPage.hasLogoutLink());

        OpenNewAccountPage openNewAccountPage = overviewPage
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenAccountBtn();
        Assert.assertTrue(openNewAccountPage.hasNewOpenAccountId());
    }


    @Test(enabled = false)
    public void openSavingAccountShouldSucceed_2() {
        OpenNewAccountPage openNewAccountPage = page.getInstance(LoginPage.class)
                .doLogin(getUsername(), getPassword())
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenAccountBtn();
        Assert.assertTrue(openNewAccountPage.hasNewOpenAccountId());
    }
}
