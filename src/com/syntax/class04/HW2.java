package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//Amazon link count:
//        Open chrome browser
//        Go to "https://www.amazon.com/"
//        Get all links
//        Get number of links that has text
//        Print to console only the links that has text
public class HW2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int countLinksHasText=0;
        for (WebElement link : allLinks
        ) {
            String linkText = link.getText();
            if (!linkText.isEmpty()) {
                countLinksHasText+=1;
                System.out.println(linkText+": "+link.getAttribute("href"));
            }
        }
        System.out.println("Num of Links has text: " + countLinksHasText);

        Thread.sleep(3000);
        driver.quit();
    }
}
