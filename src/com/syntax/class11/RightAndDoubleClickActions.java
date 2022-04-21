package com.syntax.class11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class RightAndDoubleClickActions {
    public static String url = "https://demo.guru99.com/test/simple_context_menu.html";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();

//        WebDriverWait wait = new WebDriverWait(driver,20);
//        WebElement contextMenuElements =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));

        WebElement contextMenuElements = driver.findElement(By.xpath("//span[text()='Edit']"));
        //contextMenuElements.click();
        actions.click(contextMenuElements).perform();


       Alert alert = driver.switchTo().alert();
       alert.dismiss();
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double-')]"));
        actions.doubleClick(doubleClickButton).perform();
        System.out.println(alert.getText());
        alert.accept();

        Thread.sleep(5000);
        driver.quit();

    }
}