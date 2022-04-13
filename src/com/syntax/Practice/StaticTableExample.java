package com.syntax.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class StaticTableExample {
    public static String url = "https://chercher.tech/practice/table";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='webtable']/tbody/tr"));
        System.out.println(rows.size());
        Iterator<WebElement> it=rows.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getText());
        }

        List<WebElement> cols =driver.findElements(By.xpath("//table[@id='webtable']/tbody/tr/th"));
        System.out.println(cols.size());
        Iterator<WebElement> it2=cols.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next().getText());
        }



    }
}
