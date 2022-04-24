package com.syntax.utils;

import com.syntax.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CommonMethods extends BaseClass {
    /**
     * this method will send text to a given element
     *
     * @param element
     * @param text
     */
    public void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void switchToFrame(int index) {

        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void takeScreenShot(String path) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    static WebDriver driver = new ChromeDriver();
//
//    public static void openBrowser(String url) {
//        driver.get(url);
//    }
//
//    public static void closeBrowser() {
//        driver.close();
//    }
//
//    public void quitBrowser() {
//        driver.quit();
//    }
}
