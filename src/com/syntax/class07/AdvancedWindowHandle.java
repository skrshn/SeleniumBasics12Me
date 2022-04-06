package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AdvancedWindowHandle {
    public static String url = "https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);
        WebElement button1Click = driver.findElement(By.linkText("Follow On Instagram"));
        button1Click.click();
        WebElement button2Click = driver.findElement(By.linkText("Like us On Facebook"));
        button2Click.click();
        WebElement button3Click = driver.findElement(By.linkText("Follow Instagram & Facebook"));
        button3Click.click();


        Set<String> allWindowHandles = driver.getWindowHandles();

        System.out.println(allWindowHandles);
        System.out.println(allWindowHandles.size());

        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) {
            String nextWindow = it.next();
            if (!mainPageHandle.equals(nextWindow)) {
                driver.switchTo().window(nextWindow);
                String title = driver.getTitle();
                System.out.println(title);
                driver.close();
            }
        }
        driver.switchTo().window(mainPageHandle);
        button1Click.click();

        driver.quit();
    }
}
