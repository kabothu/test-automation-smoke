package io.sprintboards.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;



@Slf4j
public class BrowserActions extends BrowserWait {


    public static void clickElementBy(By by) {
        tryFindElement(by).click();
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public static void clearAndfillInFieldWith(By by, String text) {
        tryFindElement(by).clear();
        tryFindElement(by).sendKeys(text);
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public static WebElement tryFindElement(By by) {
        WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public static String getPageTitle() {
        return getDriver().getTitle();
    }

    public static String getTextFromElement(By by) {
        return tryFindElement(by).getText();
    }

    public static Integer getNumberFromElement(By by) {
        String text = getTextFromElement(by);
        Integer number = Integer.valueOf(text.replaceAll("[^0-9]", ""));
        return number;
    }

    public static WebElement tryFindElementByLinkText(String linkText) {
        WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
        return element;
    }

    public static WebElement tryFindElementByPartialLinkText(String linkText) {
        WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(linkText)));
        return element;
    }

    public static void clickElementByLinkText(String linktext) {
        tryFindElementByLinkText(linktext).click();
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public static void clickElementByPartialLinkText(String partialLinkText) {
        tryFindElementByPartialLinkText(partialLinkText).click();
        ngWebDriver.waitForAngularRequestsToFinish();
    }


    /**
     * Accepts an alert
     */
    public static void accept() {
        log.info("Start accepting alert");
        Alert alert = (Alert) getFluentWait()
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
        ngWebDriver.waitForAngularRequestsToFinish();
        log.info("Accepted alert");
    }

    /**
     * dissmisses alert
     */
    public static void dissmiss() {
        log.info("Start dismissing alert");
        Alert alert = (Alert) getFluentWait()
                .until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        log.info("Dismissed alert");
    }

    public static boolean alertExists() {
        log.info("check if alert is there");
        try {
            getFluentWait()
                    .until(ExpectedConditions.alertIsPresent());
            log.info("Alert found");
            return true;
        } catch (NoAlertPresentException e) {
            log.info("Alert not found");
            return false;
        }

    }


    public static void selectFromDropDownByVisibleText(By by, String text) {
        Select select = new Select(getDriver().findElement(by));
        select.selectByVisibleText(text);
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public static void enterTextAndSelectFirstFromSuggestedList(By by, String text) {
        clearAndfillInFieldWith(by, text);
        List<WebElement> optionsToSelect = getDriver().findElements(By.xpath("//a[@tabindex='-1']"));
        for (WebElement option : optionsToSelect) {
            if (option.getText().contains(text.toUpperCase())) {
                option.click();
                ngWebDriver.waitForAngularRequestsToFinish();
                break;
            }
        }
    }

    public static boolean checkIfElementContainsText(By by, String text) {
        String expectedText = text.toLowerCase();
        String actualText = tryFindElement(by).getText().toLowerCase();
        return actualText.contains(expectedText);
    }

    public static void checkAndAcceptFromConfirmationDialogue(By by) {
        tryFindElement(by).click();
        pageRefresh();
    }

    public static void checkAndDismissAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 6);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            alert.dismiss();
            ngWebDriver.waitForAngularRequestsToFinish();
        } catch (Exception ignored) {
            //exception handling
        }
    }

    public static void pageRefresh() {
        getDriver().navigate().refresh();
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public static String getSelectedValueFromDropDown(By by) {
        Select select = new Select(tryFindElement(by));
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        return defaultItem;
    }

    //to be used only for getting values from input tag and other method is not working
    public static String getTextFromElementUsingAttributeValue(By by) {
        return tryFindElement(by).getAttribute("value");
    }

    public static boolean isElementPresent(By by) {
        return getDriver().findElements(by).size() > 0;
    }

    public static String getPageURL() {
        return getDriver().getCurrentUrl();
    }

    public static String getPageHeader() {
        return getTextFromElement(By.tagName("h1"));
    }


    public static String getTableHeaderWithH4Tag() {
        return getTextFromElement(By.tagName("h4"));
    }

}
