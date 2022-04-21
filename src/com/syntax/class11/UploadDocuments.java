package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UploadDocuments {
    public static String url = "https://the-internet.herokuapp.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement fileLinkUpload = driver.findElement(By.linkText("File Upload"));
        fileLinkUpload.click();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String path = "/Users/sakirsahin/Documents/WritingExcelPractice.xlsx";
        chooseFile.sendKeys(path);


        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
    }
}