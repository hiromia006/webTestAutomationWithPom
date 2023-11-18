package com.parabank.parasoft.testcasses;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginPageTittle() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        Assert.assertEquals(loginPage.getPageTittle(), ParaBankString.LOGIN_TITTLE);
    }

    @Test
    public void loginShouldSucceed() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        Assert.assertEquals(loginPage.getPageTittle(), ParaBankString.LOGIN_TITTLE);

        loginPage = loginPage
                .fillUsername(getUsername())
                .fillPassword(getPassword());

        OverviewPage overviewPage = loginPage
                .clickLoginBtn();
        Assert.assertTrue(overviewPage.hasLogoutLink());

    }

    @Test
    public void loginShouldSucceed_2() {
        OverviewPage overviewPage = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(overviewPage.hasLogoutLink());

    }
}
