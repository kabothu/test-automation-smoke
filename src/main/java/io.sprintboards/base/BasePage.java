package io.sprintboards.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.sprintboards.utils.OptionsManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

@Slf4j
public class BasePage {

    public Properties prop;
    OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    String browser;


    /**
     * This method is used to init the driver on the basis on given browser/environment
     *
     * @param "browser"
     * @return driver
     */

    public WebDriver initializeDriver() {
        String browser1 = System.getProperty("browser");
        if (browser1 != null) {
            browser = browser1;
        } else {
            browser = prop.getProperty("browser");
        }

        log.info("browser name is : " + browser);

        optionsManager = new OptionsManager(prop);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.silentOutput", "true");
            tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.getInstance(SafariDriver.class).setup();
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println(browser + " is not found, please pass the correct browserName");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * this method is used to init/load the properties from config file
     *
     * @return prop
     */

    public Properties initializeProperties() {
        prop = new Properties();
        String path = null;
        String env;
        try {
            env = System.getProperty("env");
            if (env == null) {
                log.info("No environment selected, running on default environment :QA");
                path = "./src/main/java/io.sprintboards/config/config.properties";
            } else {
                switch (env) {
                    case "qa":
                        log.info("Tests are being run on QA environment");
                        path = "./src/main/java/io.sprintboards/config/qa.config.properties";
                        break;
                    case "dev":
                        log.info("Tests are being run on DEV environment");
                        path = "./src/main/java/io.sprintboards/config/dev.config.properties";
                        break;
                    case "prod":
                        log.info("Tests are being run on PROD environment");
                        path = "./src/main/java/io.sprintboards/config/prod.config.properties";
                        break;
                    default:
                        System.out.println("Please pass the correct env value...");
                        break;
                }
            }

            FileInputStream ip = new FileInputStream(path);
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


}