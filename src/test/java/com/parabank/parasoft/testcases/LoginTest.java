package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.DashBoardPage;
import com.parabank.parasoft.pages.LoginPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginShouldFailWithoutPassword() {
        LoginPage login = page.getInstance(LoginPage.class)
                .fillUsername(LoremIpsum.getInstance().getName())
                .clickLonginLinkBtn();
        Assert.assertTrue(login.hasError());
    }

    @Test
    public void loginShouldFailWithoutUsername() {
        LoginPage login = page.getInstance(LoginPage.class)
                .fillPassword(LoremIpsum.getInstance().getName())
                .clickLonginLinkBtn();
        Assert.assertTrue(login.hasError());
    }

    @Test(groups = "smoke")
    public void loginShouldSucceed() {
        DashBoardPage dashBoard = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLonginBtn();
        Assert.assertTrue(dashBoard.hasLogOutLinkText());
    }
}
