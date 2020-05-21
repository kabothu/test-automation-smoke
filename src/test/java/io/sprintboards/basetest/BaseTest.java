package io.sprintboards.basetest;


import io.sprintboards.base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static io.sprintboards.base.BasePage.getDriver;


@Slf4j
public class BaseTest {

    public BasePage basePage;
    public WebDriver driver;
    public Properties prop;

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() {
        log.info("Starting Browser");
        basePage = new BasePage();
        prop = basePage.initializeProperties();
        driver = basePage.initializeDriver();
        driver.get(prop.getProperty("url"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing Browser");
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}





