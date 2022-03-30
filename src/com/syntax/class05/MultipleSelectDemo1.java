package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultipleSelectDemo1 {
    static String url4 = "https://www.syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url4);


        Select select = new Select(driver.findElement(By.cssSelector("select[name='States']")));
        boolean isMultiple = select.isMultiple();

        if (isMultiple) {
            List<WebElement> options = select.getOptions();
            for (WebElement option:options
                 ) {
                String optionText = option.getText();
                select.selectByVisibleText(optionText);
                Thread.sleep(500);
            }
        }
        select.deselectAll();
    }
}
