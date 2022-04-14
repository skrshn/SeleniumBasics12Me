package com.syntax.class10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakingScreentShot {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester", Keys.TAB);

        WebElement password = driver.findElement(By.xpath("//input[contains(@id,'pass')]"));
        password.sendKeys("test", Keys.TAB);

        driver.findElement(By.xpath("//input[contains(@id,'login')]")).click();
        driver.manage().window().maximize();

        TakesScreenshot ts = ((TakesScreenshot) driver);
        File src = ts.getScreenshotAs(OutputType.FILE);
        File path = new File("screenshots/SmartBear/adminLogin111.png");
        try {
            FileUtils.copyFile(src, path);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("/Users/sakirsahin/Documents/sak.pdf"));

        driver.quit();
    }
}

