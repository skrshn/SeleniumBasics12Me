package com.syntax.class05.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//Go to facebook sign up page
//        Fill out the whole form
//        Click signup
public class HW2 {
    static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);

        driver.findElement(By.partialLinkText("new account")).click();
        Thread.sleep(1000);

        driver.findElement(By.name("firstname")).sendKeys("Michael");
        driver.findElement(By.name("lastname")).sendKeys("Newman");
        driver.findElement(By.name("reg_email__")).sendKeys("opyt6754mnj123@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("opyt6754mnj123@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("asdasd");


        WebElement month = driver.findElement(By.cssSelector("select[id='month']"));
        Select monthDD = new Select(month);
        if (!monthDD.isMultiple()) {
            monthDD.selectByVisibleText("Jul");
        }
        Thread.sleep(1000);

        WebElement day = driver.findElement(By.cssSelector("select[id='day']"));
        Select dayDD = new Select(day);
        if (!dayDD.isMultiple()) {
            dayDD.selectByIndex(10);
        }
        Thread.sleep(1000);

        WebElement year = driver.findElement(By.cssSelector("select[id='year']"));
        Select yearDD = new Select(year);

        if (!dayDD.isMultiple()) {
            yearDD.selectByValue("1990");
        }
        Thread.sleep(1000);

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='radio']"));

        for (WebElement checkBox : checkBoxes
        ) {
            String text = checkBox.getAttribute("value");
            //System.out.println(text);
            if (text.equals("2")) {
                checkBox.click();
                break;
            }
        }

        Thread.sleep(1000);

        driver.findElement(By.name("websubmit")).click();

        Thread.sleep(1000);

        driver.quit();

    }
}
