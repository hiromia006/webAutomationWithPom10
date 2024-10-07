package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(String username) {
        getWebElement(By.name("username")).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        getWebElement(By.name("password")).sendKeys(password);
        return this;
    }

    public DashBoardPage clickLonginBtn() {
        clickElement(By.cssSelector("form .button"));
        return getInstance(DashBoardPage.class);
    }

    public LoginPage clickLonginLinkBtn() {
        clickElement(By.cssSelector("form .button"));
        return this;
    }

    public boolean hasError() {
        GeneralUtil.waitForSee();
        return getWebElements(By.className("error")).size() > 0;
    }

    public DashBoardPage doLogin(String username, String password) {
        return
                fillUsername(username)
                        .fillPassword(password)
                        .clickLonginBtn();
    }

    public RegisterPage clickRegister() {
        clickElement(By.linkText("Register"));
        return getInstance(RegisterPage.class);
    }

}
