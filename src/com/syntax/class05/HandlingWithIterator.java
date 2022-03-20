package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class HandlingWithIterator {
    static String url5 = "https://www.amazon.com";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url5);

        Select departmentsDD = new Select(driver.findElement(By.id("searchDropdownBox")));
        boolean isMultiple = departmentsDD.isMultiple();
        System.out.println(isMultiple);

        if (!isMultiple) {
            List<WebElement> options = departmentsDD.getOptions();
            Iterator<WebElement> it=options.iterator();
            while(it.hasNext()){
                System.out.println(it.next().getText());

            }
        }
    }
}
