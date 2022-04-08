package com.syntax.reviewClass03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class explicitWait {
    public static String url = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement getButton1 = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        getButton1.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement getButton2 = driver.findElement(By.xpath("//button[@id='populate-text']"));
        getButton2.click();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Selenium Webdriver']"))).getText());

        WebElement getButton3 = driver.findElement(By.xpath("//button[@id='display-other-button']"));
        getButton3.click();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#hidden"))).isDisplayed());

        WebElement disableButton = driver.findElement(By.cssSelector("button#disable"));
        WebElement getButton4 = driver.findElement(By.xpath("//button[@id='enable-button']"));
        getButton4.click();
        wait.until(ExpectedConditions.elementToBeClickable(disableButton));
        System.out.println(disableButton.isEnabled());


        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement getButton5 = driver.findElement(By.xpath("//button[@id='checkbox']"));
        getButton5.click();
        wait.until(ExpectedConditions.elementToBeSelected(checkBox));
        System.out.println(checkBox.isSelected());

        driver.quit();
    }
}
