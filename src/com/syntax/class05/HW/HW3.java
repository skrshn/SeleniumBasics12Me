package com.syntax.class05.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//Go to ebay.com
//        get all the categories and print them in the console
//        select Computers/Tables & Networking
//        click on search
//        verify the header
public class HW3 {
    static String url = "https://www.ebay.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);


        Select categoriesDD = new Select(driver.findElement(By.cssSelector("select[id='gh-cat']")));
        List<WebElement> options = categoriesDD.getOptions();

        for (WebElement option:options
        ) {
            System.out.println(option.getText());
        }


        categoriesDD.selectByValue("58058");
        Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));
        searchButton.click();
        Thread.sleep(1000);

        //System.out.println(driver.getTitle());

        if(driver.getTitle().equals("Computers, Laptops, Tablets & Network Hardware for Sale - eBay"))
        {
            System.out.println("Title is verified.");
        }else{
            System.out.println("Title is NOT verified.");
        }

        Thread.sleep(1000);
        driver.quit();
    }
}
