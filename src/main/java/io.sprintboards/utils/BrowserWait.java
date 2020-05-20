package io.sprintboards.utils;

import io.sprintboards.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BrowserWait extends BasePage {


    public static FluentWait getFluentWait() {
        FluentWait fluentWait = new FluentWait(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return fluentWait;
    }

    public static Boolean waitUntilElementIsPresent(By by) {
        try {
            getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static Boolean waitUntilElementIsDisplayed(By by) {
        try {
            getFluentWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static Boolean waitUntilElementClickable(By by) {
        try {
            getFluentWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

}
