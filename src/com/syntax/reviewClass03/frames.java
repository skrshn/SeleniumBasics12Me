package com.syntax.reviewClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class frames {
    static String url = "https://chercher.tech/practice/frames";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);

        driver.switchTo().frame(0);
        WebElement webElement =driver.findElement(By.xpath("//b[@id='topic']"));
        System.out.println(webElement.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");
        Select dropDown =new Select(driver.findElement(By.cssSelector("select#animals")));
        dropDown.selectByIndex(2);

        driver.switchTo().defaultContent();

        WebElement frameElement =driver.findElement(By.xpath("//iframe[@id='frame1']"));

        driver.switchTo().frame(frameElement);

        driver.switchTo().frame("frame3");


        WebElement checkbox =driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
    }
}
