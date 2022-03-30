package com.syntax.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class browserDropdownEtc {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("https://www.amazon.com");
        //driver.manage().window().maximize();
        String title = driver.getTitle();

        if (title.equalsIgnoreCase("Amazon.com")) {
            System.out.println("Title matches");
        } else {
            System.out.println(title);
        }
        Thread.sleep(1000);
        String tagName = " ";
        tagName = driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).getText();
        System.out.println(tagName);

        WebElement category = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        Thread.sleep(1000);

        WebElement goods = driver.findElement(By.xpath("//*[@id='nav-al-wishlist']/a[1]/span"));
        action.moveToElement(goods);
        action.click();
        action.perform();

        Thread.sleep(1000);


        driver.findElement(By.linkText("Your Idea Lists")).click();
        driver.navigate().back();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#nav-hamburger-menu")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("a[data-ref-tag ^= 'nav_em_1_1_1_10'")).click();

        //driver.findElement(By.xpath("//a[text() = 'Shop all Fire TV devices']")).click();

        Thread.sleep(1000);
        WebElement myElement = driver.findElement(By.id("twotabsearchtextbox"));
        myElement.sendKeys("John Grisham");
        Thread.sleep(1000);

        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("img[data-image-index='3']")).click();
        Thread.sleep(1000);

        java.util.Set<String> handles = driver.getWindowHandles();
        String macHandle1 = driver.getWindowHandle();
        handles.remove(macHandle1);
        String macHandle= handles.iterator().next();

        String macHandle2=" ";
        if(macHandle!=macHandle1) {
            macHandle2 = macHandle;
            driver.switchTo().window(macHandle2);
            System.out.println(macHandle2);

        }
        Thread.sleep(1000);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        Thread.sleep(1000);

        driver.quit();
    }
}
