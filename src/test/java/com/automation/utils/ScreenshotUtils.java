package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    public static String takeScreenshotAsFile(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        String  folderName="Extent-Report/";
        String fileName ="ScreenShot.png";
        try {
            FileUtils.copyFile(screenshot,new File(folderName+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }
    public static String takeScreenshotAsBase64() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        String screenshot = ts.getScreenshotAs(OutputType.BASE64);
        return screenshot;

    }
}
