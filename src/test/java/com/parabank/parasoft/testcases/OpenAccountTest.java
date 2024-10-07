package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.DashBoardPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OpenAccountPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseTest {
    @Test(groups = "smoke")
    public void openAccountShouldSucceed() {
        DashBoardPage boardPage = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLonginBtn();
        Assert.assertTrue(boardPage.hasLogOutLinkText());

        OpenAccountPage accountPage = boardPage
                .clickOpenAccountLink()
                .selectAccountType("1")
                .clickOpenAccountBtn();
        Assert.assertTrue(accountPage.hasNewAccountId());
    }

    @Test
    public void openAccountShouldSucceed3() {
        DashBoardPage boardPage = page.getInstance(LoginPage.class)
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(boardPage.hasLogOutLinkText());

        OpenAccountPage accountPage = boardPage
                .clickOpenAccountLink()
                .selectAccountType("1")
                .clickOpenAccountBtn();
        Assert.assertTrue(accountPage.hasNewAccountId());
    }

    @Test
    public void openAccountShouldSucceed4() {
        DashBoardPage boardPage = page.getInstance(LoginPage.class)
                .clickRegister()
                .doRegistration(LoremIpsum.getInstance().getFirstName());

        Assert.assertTrue(boardPage.hasLogOutLinkText());

        OpenAccountPage accountPage = boardPage
                .clickOpenAccountLink()
                .selectAccountType("1")
                .clickOpenAccountBtn();
        Assert.assertTrue(accountPage.hasNewAccountId());
    }

    @Test(enabled = false)
    public void openAccountShouldSucceed2() {
        OpenAccountPage accountPage = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLonginBtn()
                .clickOpenAccountLink()
                .selectAccountType("1")
                .clickOpenAccountBtn();
        Assert.assertTrue(accountPage.hasNewAccountId());
    }
}
