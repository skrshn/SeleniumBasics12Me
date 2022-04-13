package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalenderHandling {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        username.sendKeys("Admin");
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='Submit']"));
        loginButton.click();

        WebElement leaveTab = driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"));
        leaveTab.click();

        WebElement calendarImg = driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
        calendarImg.click();

        WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select select = new Select(monthDD);
        select.selectByVisibleText("Jul");

        WebElement yearDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select select2 = new Select(yearDD);
        select2.selectByVisibleText("2021");

        List<WebElement> daysDD = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement days : daysDD
        ) {
            String dateText = days.getText();
            if (dateText.equals("4")) {
                days.click();
                break;
            }
        }
    }
}
