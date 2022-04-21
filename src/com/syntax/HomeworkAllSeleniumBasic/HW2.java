package com.syntax.HomeworkAllSeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//        HW:
//        TC 1: HRMS blank password validation
//        Navigate to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
//        Enter valid username and leave password field empty
//        Click on login button
//        Verify error message with text "Password cannot be empty" is displayed
public class HW2 {
    static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("");

        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        WebElement errorMessageField = driver.findElement(By.xpath("//span[text()='Password cannot be empty']"));

        if(errorMessageField.isDisplayed()){
            System.out.println("Error message is verified");
        }
        else{
            System.out.println("Error message is not verified");

        }

        Thread.sleep(5000);
        driver.quit();
    }
}
