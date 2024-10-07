package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.DashBoardPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.RegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test(groups = "smoke")
    public void registerShouldSucceed() {
        String username = LoremIpsum.getInstance().getFirstName();
        DashBoardPage boardPage = page.getInstance(LoginPage.class)
                .clickRegister()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getTitle(5))
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateFull())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getPhone())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterBtn();

        Assert.assertTrue(boardPage.hasLogOutLinkText());

    }

    @Test
    public void registrationShouldWithOnlyUsername() {
        RegisterPage register = page.getInstance(LoginPage.class)
                .clickRegister()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .clickRegisterLinkBtn();
        Assert.assertTrue(register.hasError());
    }

    @Test
    public void registrationShouldWithOnlyUsername2() {
        RegisterPage register = page.getInstance(LoginPage.class)
                .clickRegister()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .clickRegisterLinkBtn();
        Assert.assertTrue(register.hasError());
    }
}
