package com.parabank.parasoft.pages;

import com.aventstack.extentreports.Status;
import com.parabank.parasoft.report.ReportTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By selector) {
        addInfo("We are looking " + selector + " in DOM");
        WebElement element = null;
        try {
            element = driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(selector.toString() + " No such selector found and sorry for that");
            addInfo(selector + " No such selector found and sorry for that");
        }
        addInfo( selector + " found in DOM");
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        addInfo("We are looking " + selector + " in DOM");
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(selector);
        } catch (Exception e) {
            System.out.println(selector.toString() + " Selector not found and sorry for that");
            addInfo(selector + " No such selector found and sorry for that");
        }
        addInfo("" + selector + " found in DOM");
        return elements;
    }

    @Override
    public void waitForElement(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));

    }

    @Override
    public void clickElement(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(selector))).click();
    }

    @Override
    public String getElementText(By selector) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector)).getText().trim();
    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }
}
