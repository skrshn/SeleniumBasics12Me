package com.syntax.reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class reviewClass02Test {
    static String url = "https://www.syntaxprojects.com/basic-radiobutton-demo.php";
    static String url2 = "https://www.syntaxprojects.com/basic-checkbox-demo.php";
    static String url3 = "https://fb.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        Thread.sleep(500);

        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));

        System.out.println(femaleRadioButton.isEnabled());
        System.out.println(femaleRadioButton.isDisplayed());
        System.out.println(femaleRadioButton.isSelected());

        if (!femaleRadioButton.isSelected()) {
            femaleRadioButton.click();
        }
        System.out.println("-----------------------------------------------------------");

        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println("Num of Links: " + a.size());
        //System.out.println("Num of Links: "+a.get(0));
        for (WebElement b : a
        ) {
            String linkText = b.getText();
            if (!linkText.isEmpty()) {
                System.out.println(linkText + ": " + b.getAttribute("href"));
            }
        }
        System.out.println("-----------------------------------------------------------");

        driver.navigate().to(url2);

        List<WebElement> optionCheckBoxes = driver.findElements(By.cssSelector("input[class='cb1-element']"));

        System.out.println("Num of Checkboxes: " + optionCheckBoxes.size());

        for (WebElement option:optionCheckBoxes){
            String checkBoxValue = option.getAttribute("value");
            option.click();
            if (checkBoxValue.equals("Option-3")){
                option.click();
            }
        }

        Thread.sleep(500);
        driver.findElement(By.cssSelector("input#check1")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input#check1")).click();

        System.out.println("-----------------------------------------------------------");
        driver.navigate().to(url3);

        WebElement regBut = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        regBut.click();
        Thread.sleep(2000);

        Select objSelect = new Select(driver.findElement(By.cssSelector("select#day")));
        List<WebElement> list = objSelect.getOptions();
        System.out.println("Num of Options: " + list.size());
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getText());
            //list.get(i).click();
            objSelect.selectByIndex(i);
        }

        Thread.sleep(10000);
        driver.quit();

    }
}

