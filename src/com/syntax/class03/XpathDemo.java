package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        //input[contains(@id,'ctl00_MainContent_usern')]
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");

        //input[contains(@id,'ctl00_MainContent_passw')]
        driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("test");
        driver.findElement(By.xpath("//input[contains(@id,'login')]")).click();

    }
}
