package com.syntax.class06.HW;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Go to https://syntaxprojects.com/javascript-alert-box-demo.php
//click on each button and handle the alert accordingly
public class HW2 {
    static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        Thread.sleep(500);

        WebElement alertButton = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
        alertButton.click();
        Thread.sleep(500);
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        Thread.sleep(500);

        WebElement confirmButton = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
        confirmButton.click();
        Thread.sleep(500);
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();
        Thread.sleep(500);

        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
        promptButton.click();
        Thread.sleep(500);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Sakir Sahin");
        Thread.sleep(500);
        promptAlert.accept();

        //website has a bug that does not show entered text by automation but shows after accept button.
        //it works by manually.
        Thread.sleep(3000);
        driver.quit();

    }
}
