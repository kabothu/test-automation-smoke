package io.sprintboards.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Properties;

public class OptionsManager {

    public ChromeOptions co;
    public FirefoxOptions fo;
    public SafariOptions sf;
    Properties prop;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        co = new ChromeOptions();
        if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
        if (Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
        return co;
    }

    public FirefoxOptions getFirefoxOptions() {
        fo = new FirefoxOptions();
        if (Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
        if (Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
        return fo;
    }

    public SafariOptions getSafariOptions() {
        sf = new SafariOptions();
        return sf;
    }


}
