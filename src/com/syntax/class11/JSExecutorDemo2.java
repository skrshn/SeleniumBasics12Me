package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JSExecutorDemo2 {
    static String url = "http://amazon.com";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollBy(0,-1000)");

//        Object obj =js.executeScript("window.scrollBy(0,1000)");
//        js.executeScript("window.scrollBy("+obj+",-1000)");

        WebElement backToTopButton = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
        js.executeScript("arguments[0].scrollIntoView(true)",backToTopButton);

    }
}
