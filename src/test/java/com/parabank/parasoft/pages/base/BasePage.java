package com.parabank.parasoft.pages.base;

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
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement webElement = null;
        try {
            waitForWebElement(selector);
            webElement = driver.findElement(selector);

        } catch (Exception e) {
            System.out.println(selector.toString() + " Select or Locator Not Found");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> webElements = null;
        try {
            waitForWebElement(selector);
            webElements = driver.findElements(selector);
        } catch (Exception e) {
            System.out.println(selector.toString() + " Select or Locator Not Found");
        }
        return webElements;
    }

    @Override
    public void waitForWebElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(locator.toString() + " Select or Locator Not Found");
        }

    }
}
