package com.syntax.class08.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//go to https://the-internet.herokuapp.com/dynamic_controls
//        click on checkbox and click on remove
//        verify the text
//        click on enable verify the textbox is enabled
//        enter text and click disable
//        verify the textbox is disabled
public class HW1 {
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,20);

        driver.findElement(By.xpath("//input[@label='blah']")).click();
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        WebElement elementCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));
        if(elementCheckBox.getText().equalsIgnoreCase("It's gone!")){
            System.out.println("Checkbox Text is Verified, full text is: ("+elementCheckBox.getText()+")");
        }else{
            System.out.println("Checkbox Text is NOT Verified");
        }

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebElement enableButtonText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'enabled!')]")));
        if(textBox.isEnabled()){
            System.out.println("After clicking Enable Button, Textbox is Enabled, full text is: ("+enableButtonText.getText()+")");
            textBox.sendKeys("Hello World!");
        }else{
            System.out.println("After clicking Enable Button, Textbox is NOT Enabled");
        }

        driver.findElement(By.xpath("//button[text()='Disable']")).click();
        WebElement disableButtonText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'disabled!')]")));
        if(!textBox.isEnabled()){
            System.out.println("After clicking Disable Button, Textbox is Disabled, full text is: ("+disableButtonText.getText()+")");
        }else{
            System.out.println("After clicking Disable Button, Textbox is NOT Disabled");
        }

        driver.quit();
    }
}
