package com.syntax.class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert01 {
    //static String url = "https://the-internet.herokuapp.com/basic_auth";
    //admin:admin@    is the username and password
    static String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
    }
}
