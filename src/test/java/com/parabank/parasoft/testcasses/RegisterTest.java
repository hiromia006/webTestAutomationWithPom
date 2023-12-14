package com.parabank.parasoft.testcasses;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.pages.RegisterPage;
import com.parabank.parasoft.util.General;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
//    @Test
//    public void registerShouldSucceed() {
//        OverviewPage homePage = page.getInstance(LoginPage.class)
//                .clickRegistrationLink()
//                .doRegistration();
//        Assert.assertTrue(homePage.hasLogoutLink());
//
//    }

    @Test
    public void registerWithOutRequiredShouldFail() {
        RegisterPage registerPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .clickRegisterLink();
        Assert.assertTrue(registerPage.hasError());
    }

    @Test
    public void registerWithOnlyNameShouldFail() {
        RegisterPage registerPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .clickRegisterLink();
        Assert.assertTrue(registerPage.hasError());
    }

    @Test
    public void registerWithOnlyLastNameShouldFail() {
        RegisterPage registerPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .fillLastName(LoremIpsum.getInstance().getFirstName())
                .clickRegisterLink();
        Assert.assertTrue(registerPage.hasError());
    }

    @Test(dataProvider = "getRegistrationData")
    public void registerShouldSucceed(String firstName, String lastName, String address, String city, String state) {
        OverviewPage overviewPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(Integer.valueOf(LoremIpsum.getInstance().getZipCode()))
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn("522-83-1308")
                .fillUsername(firstName)
                .fillPassword(firstName)
                .fillConfirmPassword(firstName)
                .clickRegisterBtn();
        Assert.assertTrue(overviewPage.hasLogoutLink());

    }


    @DataProvider
    public static Object[][] getRegistrationData() {
        return General.getTestData("Sheet1");
    }

}
