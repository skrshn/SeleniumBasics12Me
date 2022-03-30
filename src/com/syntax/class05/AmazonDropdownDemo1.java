package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropdownDemo1 {
    static String url3 = "https://amazon.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url3);

        Select categoriesDD = new Select(driver.findElement(By.cssSelector("select[id='searchDropdownBox']")));
        List<WebElement> options = categoriesDD.getOptions();

        for (WebElement option:options
             ) {
            System.out.println(option.getText());
        }

        categoriesDD.selectByValue("search-alias=appliances");

        Thread.sleep(2000);
        driver.quit();
    }
}
