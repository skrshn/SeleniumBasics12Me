package com.syntax.class02.HomeworkWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//        navigate to fb.com
//        click on create new account
//        fill up all the textboxes
//        click on sign up button
//        close the pop up
//        close the browser
public class HW2 extends HW1{

    void HW2() {
        driver.navigate().to("https://fb.com");
        driver.findElement(By.partialLinkText("new account")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.name("firstname")).sendKeys("Michael");
        driver.findElement(By.name("lastname")).sendKeys("Newman");
        driver.findElement(By.name("reg_email__")).sendKeys("opyt6754mnj123@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("opyt6754mnj123@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("asdasd");
        driver.findElement(By.name("birthday_month")).sendKeys("Jul");
        driver.findElement(By.name("birthday_day")).sendKeys("18");
        driver.findElement(By.name("birthday_year")).sendKeys("1979");

        driver.findElement(By.cssSelector("input[value='2']")).click();

        driver.findElement(By.name("websubmit")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//img[@ src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']")).click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
