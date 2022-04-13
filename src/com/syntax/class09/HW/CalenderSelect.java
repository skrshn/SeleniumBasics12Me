package com.syntax.class09.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalenderSelect {
    public static void calendarMethod(WebDriver driver, String month, String year, String day){
        //WebDriver driver = new ChromeDriver();
        WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonthDD = new Select(monthDD);
        selectMonthDD.selectByVisibleText(month);

        WebElement yearDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYearDD = new Select(yearDD);
        selectYearDD.selectByVisibleText(year);

        List<WebElement> daysDD = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement days : daysDD
        ) {
            String dateText = days.getText();
            if (dateText.equals(day)) {
                days.click();
                break;
            }
        }
    }
}
