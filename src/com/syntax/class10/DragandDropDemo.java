package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropDemo {
    public static String url = "http://www.jqueryui.com/droppable/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement frameElement =driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameElement);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        //action.dragAndDrop(draggable, droppable).perform();
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        driver.navigate().refresh();
    }
}
