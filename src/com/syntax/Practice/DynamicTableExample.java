package com.syntax.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DynamicTableExample {
    public static String url = "https://chercher.tech/practice/dynamic-table";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

//        WebElement banana = driver.findElement(By.cssSelector("button[name='banana']"));
//        WebElement bananaText = driver.findElement(By.cssSelector("h1#output"));
//        banana.click();
//        if (bananaText.getText().equalsIgnoreCase(banana.getText())) {
//            System.out.println("Banana Button is verified");
//        } else {
//            System.out.println("Banana Button is NOT verified");
//
//        }
//
//        List<WebElement> dynamicTableList = driver.findElements(By.xpath("//table/tbody"));
//        Iterator<WebElement> it = dynamicTableList.iterator();
//        if (it.hasNext()) {
//            System.out.println(it.next().getText());
//
//        }
//        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table/tbody/tr/td/input"));
//
//        for (int i = 0; i < checkBoxList.size(); i++) {
//            checkBoxList.get(i).click();
//        }
//
//        List<WebElement> websiteList = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
//        for (int i = 0; i < websiteList.size(); i++) {
//            if (websiteList.get(i).getText().contains("google")) {
//                System.out.println(websiteList.get(i).getText());
//            } else {
//                System.out.println("NONE");
//            }
//        }


        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (int i = 2; i <= rows.size(); i++) {
            for (int j = 2; j < rows.size()-1; j++) {
                if(driver.findElement(By.xpath("//table/tbody/tr/th["+j+"]")).getText().equalsIgnoreCase("Field")) {
                    String sColumnValue = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                    System.out.println(sColumnValue);
                }
            }
        }


    }
}
