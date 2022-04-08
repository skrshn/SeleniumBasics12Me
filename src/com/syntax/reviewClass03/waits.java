package com.syntax.reviewClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class waits {
    public static String url = "https://chercher.tech/practice/implicit-wait-example";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();


        // Thread.sleep(35000);
//        List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
//
//        Iterator<WebElement> it = checkBox.iterator();
//        while (it.hasNext()) {
//            it.next().click();
//        }

    }
}
