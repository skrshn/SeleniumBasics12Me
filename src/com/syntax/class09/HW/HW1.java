package com.syntax.class09.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW1 {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        username.sendKeys("Admin");
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='Submit']"));
        loginButton.click();

        WebElement leaveTab = driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"));
        leaveTab.click();

        WebElement calendarImgFrom = driver.findElement(By.xpath("//input[@id='calFromDate']"));
        calendarImgFrom.click();

        CalenderSelect.calendarMethod(driver,"Jul","2021","4");

        WebElement calendarImgTo = driver.findElement(By.xpath("//input[@id='calToDate']"));
        calendarImgTo.click();
        CalenderSelect.calendarMethod(driver,"Feb","2022","25");


        List<WebElement> checkboxLabels = driver.findElements(By.xpath("//input[@type='checkbox']/preceding-sibling::label"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 0; i < checkboxLabels.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }else if (checkboxLabels.get(i).getText().equals("Cancelled") || checkboxLabels.get(i).getText().equals("Rejected")) {
                checkboxes.get(i).click();
            }
        }

        WebElement subUnitDD = driver.findElement(By.xpath("//select[@id='leaveList_cmbSubunit']"));
        Select selectSubUnitDD = new Select(subUnitDD);
        selectSubUnitDD.selectByVisibleText("IT Support");

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='btnSearch']"));
        searchButton.click();

        driver.quit();
    }
}
