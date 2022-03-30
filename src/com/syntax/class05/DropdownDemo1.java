package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownDemo1 {
    static String url2 = "https://www.syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url2);


        Select objSelect = new Select(driver.findElement(By.cssSelector("select[id='select-demo']")));
//        objSelect.selectByVisibleText("Tuesday");
//        Thread.sleep(1000);
//
//        objSelect.selectByValue("Wednesday");
//        Thread.sleep(1000);
//        objSelect.selectByIndex(6);
//        Thread.sleep(1000);

        List<WebElement> list = objSelect.getOptions();
        System.out.println("Num of Checkboxes: " + list.size());

//        for (WebElement l:list
//             ) {
//            String valueText = l.getAttribute("value");
//
//            if(valueText.equals("Monday")) {
//                l.click();
//                break;
//            }
//
//        }

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getText());
            //list.get(i).click();
            objSelect.selectByIndex(i);
        }

       // list.get(1).click();


        Thread.sleep(2000);
        driver.quit();


    }
}
