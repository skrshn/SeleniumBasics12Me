package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxDemo1 {
    static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        List<WebElement> a = driver.findElements(By.cssSelector("input[class='cb1-element']"));
        System.out.println("Num of Checkboxes: " + a.size());

        for (WebElement b : a
        ) {
            String text = b.getAttribute("value");
            //System.out.println(text);
            if (text.equals("Option-2")) {
                b.click();
                break;
            }
        }


        //all except Option-3
//        for (WebElement option:a){
//            String checkBoxValue = option.getAttribute("value");
//            option.click();
//            if (checkBoxValue.equals("Option-3")){
//                option.click();
//            }
//        }


    }
}
