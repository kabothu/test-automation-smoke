package io.sprintboards.utils;




import io.sprintboards.base.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.time.LocalDateTime;

public class TakeScreenshot extends BasePage {


    public static String captureScreenshot(String testName) {

        String screenshotPath = "";

        System.out.println("Capturing screenshot");
        String workingDir = System.getProperty("user.dir");

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            screenshotPath = workingDir + "\\src\\test\\Screenshots\\" + testName + "_" + LocalDateTime.now() + ".png";
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            screenshotPath = workingDir + "/src/test/Screenshots/" + testName + "_" + LocalDateTime.now() + ".png";
        }

        File scrfile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrfile, new File(screenshotPath));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());

        }
        return screenshotPath;

    }
}
