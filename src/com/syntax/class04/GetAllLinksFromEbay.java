package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class GetAllLinksFromEbay {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://ebay.com");
        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println("Num of Links: " + a.size());
        //System.out.println("Num of Links: "+a.get(0));
        for (WebElement b : a
        ) {
            String linkText = b.getText();
            if (!linkText.isEmpty()) {
                System.out.println(linkText+": "+b.getAttribute("href"));
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
