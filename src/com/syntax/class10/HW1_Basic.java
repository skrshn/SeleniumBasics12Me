package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//Go to aa.com/homePage.do
//        select depart date
//        select return date
//        select destination
//        click on search
//        quit the browser

public class HW1_Basic {
    public static String url = "http://aa.com/homePage.do";

    public static void findClickAirport(WebDriver driver,String country, String state, String airportCode){
        WebElement airportElement = driver.findElement(By.cssSelector("select#countryCode"));
        Select airportDD = new Select(airportElement);
        if (!airportDD.isMultiple()) {
            airportDD.selectByVisibleText(country);
        }

        WebElement stateElement = driver.findElement(By.cssSelector("select#stateCode"));
        Select stateDD = new Select(stateElement);
        if (!stateDD.isMultiple()) {
            stateDD.selectByVisibleText(state);
        }

        List<WebElement> Airports = driver.findElements(By.xpath("//table[@id='airportsSection']/tbody/tr/td[@class='airport-code']"));
        for (WebElement Airport:Airports
        ) {
            if(Airport.getText().contains(airportCode)){
                Airport.click();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement departCalender = driver.findElement(By.xpath("//label[@for='aa-leavingOn']/following::button[@class='ui-datepicker-trigger'][1]"));
        departCalender.click();

        // WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-handler='next']")));


        WebElement dMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']/preceding::span[@class='ui-datepicker-month']")));
        String dMonthText = dMonth.getText();

        while (!dMonthText.equals("November")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-handler='next']"))).click();
            dMonthText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']/preceding::span[@class='ui-datepicker-month']"))).getText();
        }

        List<WebElement> departDates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));

        for (WebElement departDate : departDates
        ) {
            if (departDate.getText().equals("28")) {
                departDate.click();
                break;
            }
        }

        WebElement returnCalender = driver.findElement(By.xpath("//label[@for='aa-leavingOn']/following::button[@class='ui-datepicker-trigger'][2]"));
        returnCalender.click();

        WebElement rMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']/following::span[@class='ui-datepicker-month']")));
        String rMonthText = rMonth.getText();

        while (!rMonthText.equals("January")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-handler='next']"))).click();
            rMonthText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']/following::span[@class='ui-datepicker-month']"))).getText();
        }

        List<WebElement> returnDates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/table/tbody/tr/td"));

        for (WebElement returnDate : returnDates
        ) {
            if (returnDate.getText().equals("30")) {
                returnDate.click();
                break;
            }
        }
        WebElement searchFromLocationButton = driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.originAirport']"));
        searchFromLocationButton.click();

        findClickAirport(driver,"United States","Hawaii","KOA");

        WebElement searchToLocationButton = driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.destinationAirport']"));
        searchToLocationButton.click();

        findClickAirport(driver,"United States","Hawaii","HNL");

        //extra code, I'm selecting 3 passengers.
        WebElement howManyPassenger = driver.findElement(By.xpath("//select[@name='adultOrSeniorPassengerCount']"));
        Select passengerDD = new Select(howManyPassenger);
        if (!passengerDD.isMultiple()) {
            passengerDD.selectByVisibleText("3");
        }

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
        searchButton.click();

    }
}
