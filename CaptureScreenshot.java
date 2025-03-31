package com.nixonex.utils; // Declare the package

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {

    // Method to capture screenshot
    public void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // Capture the screenshot as a file
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Copy the screenshot to the specified path
        FileUtils.copyFile(screenshotFile, new File("screenshots/" + screenshotName + ".png"));
    }
}
