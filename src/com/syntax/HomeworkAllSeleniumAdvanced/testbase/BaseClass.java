package com.syntax.HomeworkAllSeleniumAdvanced.testbase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Actions action;
    public static Alert alert;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    /**
     *
     * @param url
     */

    public static void openWithSpecificURL(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void openSpecificURLWithAdBlocker(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=/Users/sakirsahin/Library/Application Support/Google/Chrome/Default/Extensions/gighmmpiobklfepjocnamgkkbiglidom/4.44.0_0");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //close Ad Blocker Tab and switch to main page handle
        Set<String> allWindowHandles = driver.getWindowHandles(); // store all the handles in a set
        Iterator<String> it = allWindowHandles.iterator(); // have an iterator in order to
        String mainPageHandle = it.next(); // take the first step and assign the main handle
        String childHandle = it.next(); // take the second step and have a child handle
        driver.switchTo().window(childHandle).close();
        driver.switchTo().window(mainPageHandle);
    }

    public static void navigateToSpecificURL(String url) {
       driver.navigate().to(url);
    }

    public static void openNewTabWithSpecificURL(String url) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('"+url+"')");
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void closeDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
