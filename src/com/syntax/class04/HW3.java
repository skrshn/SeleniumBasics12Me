package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//HRMS Application Negative Login:
//        Open chrome browser
//        Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
//        Enter valid username
//        Leave password field empty
//        Click on login button
//        Verify error message with text "Password cannot be empty" is displayed.
public class HW3 {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.cssSelector("input#txtUsername"));
        username.sendKeys("Admin");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
        password.clear();
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
        loginButton.click();
        if ((driver.findElement(By.cssSelector("span[id ^= 'spanM']"))).getText().equals("Password cannot be empty")){
            System.out.println("Error message is Verified");
        }else{
            System.out.println("Error message is NOT Verified");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
