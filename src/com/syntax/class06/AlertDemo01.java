package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo01 {
    static String url = "http://uitestpractice.com/Students/Switchto";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        WebElement alertButton = driver.findElement(By.cssSelector("button#alert"));
        alertButton.click();
        Thread.sleep(500);

        driver.switchTo().alert();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(500);
        WebElement confirmButton = driver.findElement(By.cssSelector("button#confirm"));
        confirmButton.click();
        Thread.sleep(500);

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        Thread.sleep(500);

        driver.findElement(By.cssSelector("button#prompt")).click();
        driver.switchTo().alert().sendKeys("Sakir");
        driver.switchTo().alert().accept();

        WebElement modalButton = driver.findElement(By.cssSelector("button[data-target='#myModal']"));
        modalButton.click();
        Thread.sleep(1500);
        WebElement clickOkModal = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        clickOkModal.click();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);

        driver.switchTo().frame("iframe_a");
        WebElement frameFill = driver.findElement(By.cssSelector("input#name"));
        frameFill.click();
        frameFill.sendKeys("Sakir111");















    }
}
