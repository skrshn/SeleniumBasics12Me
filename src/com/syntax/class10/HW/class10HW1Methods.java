package com.syntax.class10.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class class10HW1Methods {
    public static void findClickAirport(WebDriver driver, String country, String state, String airportCode) {

        WebElement airportElement = driver.findElement(By.cssSelector("select#countryCode"));
        Select airportDD = new Select(airportElement);
        if (!airportDD.isMultiple()) {
            airportDD.selectByVisibleText(country);
        }

        if (country.equals("United States") || country.equals("Canada")) {
            WebElement stateElement = driver.findElement(By.cssSelector("select#stateCode"));
            Select stateDD = new Select(stateElement);
            if (!stateDD.isMultiple()) {
                stateDD.selectByVisibleText(state);
            }
        }

        List<WebElement> Airports = driver.findElements(By.xpath("//table[@id='airportsSection']/tbody/tr/td[@class='airport-code']/a/span[1]"));
        for (WebElement Airport : Airports
        ) {
            if (Airport.getText().equals(airportCode)) {
                Airport.click();
                break;
            }
        }
    }

    public static void departReturnDateSelector(WebDriver driver, String departOrReturn, String month, int day) {
        String tableLocator = "";
        int departOrReturnCalenderLocator = 0;

        if (departOrReturn.equals("depart")) {
            departOrReturnCalenderLocator = 1;
            departOrReturn = "preceding";
            tableLocator = "first";
        } else if (departOrReturn.equals("return")) {
            departOrReturnCalenderLocator = 2;
            departOrReturn = "following";
            tableLocator = "last";
        }

        WebElement departOrReturnCalender = driver.findElement(By.xpath("//label[@for='aa-leavingOn']/following::button[@class='ui-datepicker-trigger'][" + departOrReturnCalenderLocator + "]"));
        departOrReturnCalender.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement drMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']/" + departOrReturn + "::span[@class='ui-datepicker-month']")));
        String dRMonthText = drMonth.getText();

        while (!dRMonthText.equals(month)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-handler='next']"))).click();
            dRMonthText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']/" + departOrReturn + "::span[@class='ui-datepicker-month']"))).getText();
        }

        List<WebElement> departOrReturnDates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-" + tableLocator + "']/table/tbody/tr/td"));

        for (WebElement departOrReturnDate : departOrReturnDates
        ) {
            if (departOrReturnDate.getText().equals(String.valueOf(day))) {
                departOrReturnDate.click();
                break;
            }
        }
    }

    //extra code
    public static void howManyPassengers(WebDriver driver, int passenger) {
        WebElement howManyPassenger = driver.findElement(By.xpath("//select[@name='adultOrSeniorPassengerCount']"));
        Select passengerDD = new Select(howManyPassenger);
        if (!passengerDD.isMultiple()) {
            passengerDD.selectByVisibleText(String.valueOf(passenger));
        }
    }

}
