package com.syntax.class10.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class HW1 {

    //Go to aa.com/homePage.do
//        select depart date
//        select return date
//        select destination
//        click on search
//        quit the browser

    public static String url = "http://aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        class10HW1Methods.departReturnDateSelector(driver, "depart", "November", 28); //selecting depart date
        class10HW1Methods.departReturnDateSelector(driver, "return", "December", 31); //selecting return date

        WebElement searchFromLocationButton = driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.originAirport']"));
        searchFromLocationButton.click();

        class10HW1Methods.findClickAirport(driver, "United States", "Hawaii", "KOA");

        WebElement searchToLocationButton = driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.destinationAirport']"));
        searchToLocationButton.click();

        class10HW1Methods.findClickAirport(driver, "United States", "Hawaii", "HNL");

        //extra code
        class10HW1Methods.howManyPassengers(driver, 3);

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
        searchButton.click();

        Thread.sleep(10000);
        driver.quit();
    }
}
