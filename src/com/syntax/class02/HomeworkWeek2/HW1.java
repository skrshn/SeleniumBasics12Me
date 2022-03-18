package com.syntax.class02.HomeworkWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//        navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
//        fill out the form
//        click on register
//        close the browser

public class HW1 {
    WebDriver driver = new ChromeDriver();

    void HW1() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");

        WebElement firstName = driver.findElement(By.name("customer.firstName"));
        firstName.sendKeys("Michael");
        WebElement lastName = driver.findElement(By.name("customer.lastName"));
        lastName.sendKeys("Newman");
        WebElement address = driver.findElement(By.name("customer.address.street"));
        address.sendKeys("111 Avenue");
        WebElement city = driver.findElement(By.name("customer.address.city"));
        city.sendKeys("Bronx");
        WebElement state = driver.findElement(By.name("customer.address.state"));
        state.sendKeys("New York");
        WebElement zipCode = driver.findElement(By.name("customer.address.zipCode"));
        zipCode.sendKeys("12345");
        WebElement phoneNumber = driver.findElement(By.name("customer.phoneNumber"));
        phoneNumber.sendKeys("987-654-3367");
        WebElement SSN = driver.findElement(By.name("customer.ssn"));
        SSN.sendKeys("1234-56-7890");
        WebElement username = driver.findElement(By.name("customer.username"));
        username.sendKeys("sako2");
        WebElement password = driver.findElement(By.name("customer.password"));
        password.sendKeys("123");
        WebElement repeatedPassword = driver.findElement(By.name("repeatedPassword"));
        repeatedPassword.sendKeys("123");

        driver.findElement(By.className("button")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
