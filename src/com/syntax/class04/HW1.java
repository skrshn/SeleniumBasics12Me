package com.syntax.class04;
//Open chrome browser
//        Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
//        Enter valid username and password (username - Admin, password - Hum@nhrm123)
//        Click on login button
//        Then verify Syntax Logo is displayed.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        WebElement username = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        username.sendKeys("Admin");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'btnLogin']"));
        loginButton.click();

        if(driver.findElement(By.xpath("//img[starts-with(@src, '/human')]")).isDisplayed()){
            System.out.println("True, the logo is displayed");
        }else{
            System.out.println("False, the logo is NOT displayed");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
