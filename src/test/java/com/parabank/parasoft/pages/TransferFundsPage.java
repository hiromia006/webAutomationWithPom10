package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends BasePage {
    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public TransferFundsPage fillAmount(int amount) {
        getWebElement(By.id("amount")).sendKeys(String.valueOf(amount));
        return this;
    }

    public TransferFundsPage clickTransferBtn() {
        clickElement(By.cssSelector("input.button"));
        return this;
    }

    public boolean hasTransferAmount(int amount) {
        GeneralUtil.waitForSee();
        return getElementText(By.id("amountResult")).contains(String.valueOf(amount));
    }
}
