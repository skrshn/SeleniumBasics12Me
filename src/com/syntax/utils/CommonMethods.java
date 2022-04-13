package com.syntax.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {
    static WebDriver driver = new ChromeDriver();

    public static void openBrowser(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }
}
