package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandle {
    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);
        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        System.out.println(allWindowHandles.size());

        Iterator<String> it = allWindowHandles.iterator();

        mainPageHandle = it.next();
        String childHandle = it.next();
        Thread.sleep(1000);

        driver.switchTo().window(childHandle);

        Thread.sleep(1000);
        driver.close();

        driver.switchTo().window(mainPageHandle);
        Thread.sleep(1000);

        helpLink.click();




    }
}
