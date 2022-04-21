package com.syntax.HomeworkAllSeleniumBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//        HW
//        open new browser
//        open a new tab
//        navigate to a different URL on a new tab
public class HW1 {
    static String url = "http://live.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://yahoo.com');");

        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();

        String mainPageHandle = it.next();
        String childPageHandle = it.next();

        driver.switchTo().window(mainPageHandle);
        driver.switchTo().window(childPageHandle);

        Thread.sleep(5000);
        driver.quit();
    }
}
