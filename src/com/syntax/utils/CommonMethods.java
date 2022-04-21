package com.syntax.utils;

import com.syntax.testbase.BaseClass;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
