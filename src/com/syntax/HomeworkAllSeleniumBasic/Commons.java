package com.syntax.HomeworkAllSeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Commons {
    public static WebDriver driver;

    public static void openBrowser(String url) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public static void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }
}
