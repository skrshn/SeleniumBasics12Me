package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        Actions action= new Actions(driver);
        action.moveToElement(account).perform();

        //hover the mouse over Menu
        WebElement element = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-newCust']"));

        //validate the menu is popped up
        if(element.getText().contains("Start")){
            System.out.println("Menu displayed");
        }else{
            System.out.println("Menu did NOT display");
        }

        //how to right-click on an element
        action.contextClick(element).perform();

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //search for movies
        action.moveToElement(searchBox).click().sendKeys("Movies").perform();
        searchBox.submit();

        Thread.sleep(5000);

        driver.quit();
    }
}
