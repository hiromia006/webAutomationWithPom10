package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends BasePage {
    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenAccountPage selectAccountType(String value) {
        new Select(getWebElement(By.cssSelector("select#type"))).selectByValue(value);
        return this;
    }

    public OpenAccountPage selectAccountType(int index) {
        new Select(getWebElement(By.cssSelector("select#type"))).selectByIndex(index);
        return this;
    }

    public OpenAccountPage clickOpenAccountBtn() {
        clickElement(By.cssSelector("input.button"));
        return this;
    }

    public boolean hasNewAccountId() {
        GeneralUtil.waitForSee();
        return getWebElements(By.id("newAccountId")).size() > 0;
    }
}
