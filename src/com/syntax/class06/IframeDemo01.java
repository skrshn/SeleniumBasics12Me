package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeDemo01 {
    static String url = "http://uitestpractice.com/Students/Switchto";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        Thread.sleep(1000);


        //approach iframes with index
//        driver.switchTo().frame(0);
//        WebElement frameFill = driver.findElement(By.cssSelector("input#name"));
//        frameFill.sendKeys("Sakir111");

        //switch from iframe to main page again, we have to do everytime when we dealing with iframes
//        driver.switchTo().defaultContent();
//
//        Thread.sleep(500);
//        WebElement alertButton = driver.findElement(By.cssSelector("button#alert"));
//        alertButton.click();


        //approach iframes with name or ID
//        driver.switchTo().frame("iframe_a");
//        WebElement frameFill = driver.findElement(By.cssSelector("input#name"));
//        frameFill.sendKeys("Sakir111");




        //approach iframes with WebElement
        WebElement frameElement =driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
        driver.switchTo().frame(frameElement);
        WebElement frameFill =driver.findElement(By.cssSelector("input#name"));
        frameFill.sendKeys("Sakir111");







    }
}
