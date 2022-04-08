package com.syntax.reviewClass03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {
    static String url = "https://www.syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);

        WebElement alertButton = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
        alertButton.click();

        Alert alert =driver.switchTo().alert();
        alert.accept();

        WebElement promptButton = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        promptButton.click();
        driver.switchTo().alert();


        promptButton.sendKeys("SakirSahin");
        alert.accept();

        Thread.sleep(5000);
        driver.quit();

    }
}
