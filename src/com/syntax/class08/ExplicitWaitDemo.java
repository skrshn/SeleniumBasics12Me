package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitDemo {
    public static String url = "http://syntaxprojects.com/dynamic-data-loading-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement getNewUserButton= driver.findElement(By.id("save"));
        getNewUserButton.click();

        WebDriverWait wait = new WebDriverWait(driver,20);

        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'First Name')]"))).getText());
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Last Name')]"))).getText());
//
//        WebElement firstName = driver.findElement(By.xpath("//p[contains(text(), 'First Name')]"));
//        System.out.println(firstName.getText());
    }
}
