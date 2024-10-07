package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.DashBoardPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.TransferFundsPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {

    @Test
    public void fundTransferShouldSucceed() {
        DashBoardPage boardPage = page.getInstance(LoginPage.class)
                .doLogin("sqa", "sqa");
        Assert.assertTrue(boardPage.hasLogOutLinkText());

        int amount = 2000;
        TransferFundsPage fundsPage = boardPage
                .clickFundTransfer()
                .fillAmount(amount)
                .clickTransferBtn();
        Assert.assertTrue(fundsPage.hasTransferAmount(amount));
    }

    @Test
    public void fundTransferShouldSucceed2() {
        DashBoardPage boardPage = page.getInstance(LoginPage.class)
                .clickRegister()
                .doRegistration(LoremIpsum.getInstance().getFirstName());
        Assert.assertTrue(boardPage.hasLogOutLinkText());

        int amount = 2000;
        TransferFundsPage fundsPage = boardPage
                .clickFundTransfer()
                .fillAmount(amount)
                .clickTransferBtn();
        Assert.assertTrue(fundsPage.hasTransferAmount(amount));


    }
}
