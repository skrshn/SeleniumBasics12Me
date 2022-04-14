package com.syntax.class10;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class WorkingWithKeys {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester", Keys.TAB);

        WebElement password = driver.findElement(By.xpath("//input[contains(@id,'pass')]"));
        password.sendKeys("test",Keys.TAB);
        driver.findElement(By.xpath("//input[contains(@id,'login')]")).click();

    }
}
