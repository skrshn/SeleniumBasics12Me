package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://fb.com");
//        driver.findElement(By.id("email")).sendKeys("syntax@adfadf.com");
//        driver.findElement(By.id("pass")).sendKeys("whatever");
//        driver.findElement(By.name("login")).click();
//        Thread.sleep(2000);
//        //driver.findElement(By.linkText("Forgot password?")).click();
//        driver.findElement(By.partialLinkText("Forgot")).click();
//        driver.quit();

        driver.findElement(By.partialLinkText("new account")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("Mehmet");
        driver.findElement(By.name("lastname")).sendKeys("Hanefi");
        driver.findElement(By.name("reg_email__")).sendKeys("asd");
        driver.findElement(By.name("reg_passwd__")).sendKeys("asd");
        driver.findElement(By.name("birthday_month")).sendKeys("Jul");


        Thread.sleep(5000);

        driver.quit();

    }
}
