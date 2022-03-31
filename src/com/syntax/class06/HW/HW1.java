package com.syntax.class06.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Navigate to https://syntaxprojects.com/bootstrap-iframe.php
//verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
//verify enroll today button is enabled
public class HW1 {
    static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        Thread.sleep(500);

        WebElement headerText = driver.findElement(By.cssSelector("span.gum"));
        //System.out.println(headerText.getText());
        if (headerText.getText().equals("AUTOMATION TESTING PLATFORM BY SYNTAX")) {
            System.out.println("Header is Verified");
        } else {
            System.out.println("Header is NOT Verified");
        }
        Thread.sleep(500);

        driver.switchTo().frame("FrameTwo");
        if (driver.findElement(By.linkText("Enroll today")).isDisplayed()) {
            System.out.println("Enroll Today button is Displayed");
        } else {
            System.out.println("Enroll Today button is NOT Displayed");
        }
        Thread.sleep(500);
        driver.quit();

    }
}
