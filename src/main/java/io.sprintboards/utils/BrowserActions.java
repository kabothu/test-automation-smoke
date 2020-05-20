package io.sprintboards.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class BrowserActions extends BrowserWait {


    public static void clickElementBy(By by) {
        tryFindElement(by).click();
    }

    public static void clearAndfillInFieldWith(By by, String text) {
        tryFindElement(by).clear();
        tryFindElement(by).sendKeys(text);
    }

    public static WebElement tryFindElement(By by) {
        WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public static String getTextFromElement(By by) {
        return tryFindElement(by).getText();
    }

    public static Integer getNumberFromElement(By by) {
        String text = getTextFromElement(by);
        Integer number = Integer.valueOf(text.replaceAll("[^0-9]", ""));
        return number;
    }

    public static void selectFromDropDownByVisibleText(By by, String text) {
        Select select = new Select(getDriver().findElement(by));
        select.selectByVisibleText(text);
    }

    public static boolean isElementPresent(By by) {
        return getDriver().findElements(by).size() > 0;
    }

    public static String getPageURL() {
        return getDriver().getCurrentUrl();
    }

    public static boolean checkIfUrlContainsSpecificText(String text) {
        return (Boolean) getFluentWait().until(ExpectedConditions.urlContains(text));
    }
}
