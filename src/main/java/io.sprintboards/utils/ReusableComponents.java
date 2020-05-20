package io.sprintboards.utils;


import org.openqa.selenium.By;


public class ReusableComponents extends BrowserWait {

    public static String getPageURL() {
        return getDriver().getCurrentUrl();
    }


}
