package com.syntax.reviewClass04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class WebTableExample {
    public static String url = "https://www.syntaxprojects.com/table-search-filter-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        List<WebElement> rowData =driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
        System.out.println(rowData.size());
        Iterator<WebElement> it= rowData.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getText());
        }

        List<WebElement> colsData =driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
        System.out.println(colsData.size());
        for (WebElement colData:colsData
        ) {
            System.out.println(colData.getText());
        }
    }
}
