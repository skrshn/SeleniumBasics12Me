package com.syntax.groupProject17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Task5Selenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        //Safari does not need WebDriver to download. You have too Allow Remote Driver on Develop tab on Safari Browser.

        RemoteWebDriver1[] driver = {new ChromeDriver1(),new FirefoxDriver1(),new SafariDriver1()};

        for (RemoteWebDriver1 d:driver) {
            d.open();
            Thread.sleep(2000);
            d.navigate();
            Thread.sleep(2000);
            System.out.println(d.getTitle());
            Thread.sleep(2000);
            d.close();
        }
    }
}
interface WebDriver1{
    void open();
    void close();
    String getTitle();
}
interface RemoteWebDriver1 extends WebDriver1{
    void navigate();
}
interface TakesScreenshot1 extends RemoteWebDriver{
    void getScreenshot();
}
class ChromeDriver1 implements RemoteWebDriver1{
    WebDriver driver1 = new ChromeDriver();

    @Override
    public void open() {
    }

    @Override
    public void close() {
        driver1.quit(); // will quit the whole browser
    }

    @Override
    public String getTitle() {
        return driver1.getTitle();
    }

    @Override
    public void navigate(){
        driver1.navigate().to("http://fb.com");
    }
}
class FirefoxDriver1 implements RemoteWebDriver1{
    WebDriver driver2 = new FirefoxDriver();

    @Override
    public void open() {
    }

    @Override
    public void close() {
        driver2.quit(); // will quit the whole browser
    }

    @Override
    public String getTitle() {
        return driver2.getTitle();
    }

    @Override
    public void navigate(){
        driver2.navigate().to("http://fb.com");
    }
}
class SafariDriver1 implements RemoteWebDriver1{
    WebDriver driver3 = new SafariDriver();

    @Override
    public void open() {
    }

    @Override
    public void close() {
        driver3.quit(); // will quit the whole browser
    }

    @Override
    public String getTitle() {
        return driver3.getTitle();
    }

    @Override
    public void navigate(){
        driver3.navigate().to("http://fb.com");
    }
}