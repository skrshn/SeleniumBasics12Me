package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");


        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");

        Thread.sleep(2000);
        driver.findElement(By.name("ctl00$MainContent$username")).clear();
        driver.findElement(By.name("ctl00$MainContent$password")).clear();
       // driver.findElement(By.name("ctl00$MainContent$login_button")).click();


    }
}
