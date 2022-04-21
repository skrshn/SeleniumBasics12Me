package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JSExecutorDemo3 {
    static String url = "http://google.com";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://amazon.com');");
        String mainPageHandle = driver.getWindowHandle();
        driver.get(url);

        WebElement searchBar = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBar.sendKeys("asdasd");

        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();

        mainPageHandle = it.next();
        String childHandle = it.next();
        //driver.switchTo().window(childHandle);
        driver.switchTo().window(mainPageHandle);


//        Set<String> allWindowHandles = driver.getWindowHandles();
//        System.out.println(allWindowHandles.size());
//        Iterator<String> it = allWindowHandles.iterator();
//        while (it.hasNext()) { //start iterating through the handles
//            String handle = it.next(); // get the next handle
//            driver.switchTo().window(handle); // switch to a window which is not equal to main page handle
//            //driver.manage().window().maximize();
//            String title = driver.getTitle();
//            System.out.println(title);
//            driver.close();
//        }
    }
}

