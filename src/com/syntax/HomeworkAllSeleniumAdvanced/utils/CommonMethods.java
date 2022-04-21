package com.syntax.HomeworkAllSeleniumAdvanced.utils;

import com.syntax.HomeworkAllSeleniumAdvanced.pages.HW5;
import com.syntax.HomeworkAllSeleniumAdvanced.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CommonMethods extends BaseClass {
    /**
     * this method will send text to a given element
     *
     * @param element
     * @param text
     */
    static HW5 hw5 = new HW5();

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrame(String id) {
        try {
            driver.switchTo().frame(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dragAndDrop() {
        action = new Actions(driver);
        action.clickAndHold(hw5.draggable).moveToElement(hw5.droppable).release().build().perform();
    }

    public static void doubleClick() {
        action.doubleClick(hw5.doubleClickButton).perform();
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void navBarTabs(String navBarMenuElement) {
        driver.switchTo().defaultContent();
        for (WebElement nextNavTab : hw5.navBar) {
            if (nextNavTab.getText().equals(navBarMenuElement)) {
                nextNavTab.click();
                break;
            }
        }
    }

    //delete one user from table with pagination
    public static void deleteUserFromTable(String targetName) {

        wait = new WebDriverWait(driver, 20);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        boolean flag = true;
        while (flag) {

            for (WebElement row : hw5.getRows) {
                String rowText = row.getText();
                if (rowText.contains(targetName)) {
                    flag = false;
                    WebElement customEditButton = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[contains(text(),'" + targetName + "')]/following-sibling::td[3]/button[text()='EDIT']"));
                    customEditButton.click();

                    String studentEditURL = driver.getCurrentUrl();
                    String studentID = studentEditURL.substring(studentEditURL.length() - 4);

                    driver.navigate().back();

                    WebElement customDeleteButton = driver.findElement(By.xpath("//button[@onclick=\"location.href='/Students/DELETE/" + studentID + "';return false;\"]"));
                    customDeleteButton.click();

                    hw5.deleteButtonConfirmation.click();
                    break;
                }
            }
            if (flag) {
                hw5.nextButton.click();
            }
        }
    }

    public static void takeScreenShot(String path) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verifyAjaxButtonText() {
        if (hw5.ajaxButtonText.isDisplayed()) {
            System.out.println("Text is displayed");
        } else {
            System.out.println("Text is not displayed");
        }
    }

    public static void verifyUploadText() {
        if (hw5.uploadVerify.getText().contains("File Successfully Uploaded")) {
            System.out.println("The file is uploaded");
        } else {
            System.out.println("The file is not uploaded");
        }
    }

    public static void selectMaritalStatusRadioButtons(String maritalStatus) {
        for (int i = 0; i < hw5.maritalStatusRadioButtons.size(); i++) {
            if (hw5.maritalStatusRadioButtonsLabels.get(i).getText().contains(maritalStatus)) {
                hw5.maritalStatusRadioButtons.get(i).click();
                break;
            }
        }
    }

    public static void selectCountriesDD(String selectCountry) {
        Select selectCountriesDD = new Select(hw5.countriesDD);
        boolean isMultiple = selectCountriesDD.isMultiple();

        if (!isMultiple) {
            List<WebElement> countryOptions = selectCountriesDD.getOptions();
            Iterator<WebElement> countryIterator = countryOptions.iterator();
            while (countryIterator.hasNext()) {
                WebElement next = countryIterator.next();
                String nextText = next.getText();
                if (nextText.contains(selectCountry)) {
                    next.click();
                    break;
                }

            }
        }
    }

    public static void selectCountriesSingleDD(String selectCountry) {
        Select countriesSingleDD = new Select(hw5.countriesSingle);
        boolean isMultiple = countriesSingleDD.isMultiple();

        if (!isMultiple) {
            List<WebElement> countrySingleOptions = countriesSingleDD.getOptions();
            Iterator<WebElement> countrySingleIterator = countrySingleOptions.iterator();
            while (countrySingleIterator.hasNext()) {
                WebElement next = countrySingleIterator.next();
                String nextText = next.getText();
                if (nextText.contains(selectCountry)) {
                    next.click();
                    break;
                }
            }
        }
    }

    public static void selectCountriesMultipleDD(String selectCountry1, String selectCountry2) {
        Select countriesMultipleDD = new Select(hw5.countriesMultiple);

        List<WebElement> countryMultipleOptions = countriesMultipleDD.getOptions();
        Iterator<WebElement> countryMultipleIterator = countryMultipleOptions.iterator();
        while (countryMultipleIterator.hasNext()) {
            WebElement next = countryMultipleIterator.next();
            String nextText = next.getText();
            if (nextText.contains(selectCountry1) || nextText.contains(selectCountry2)) {
                next.click();
            }
        }
    }

    public static void countryDDSelect(String selectCountry1) {
        Iterator<WebElement> countryDropdownIterator = hw5.countryDropDownOptions.iterator();
        while (countryDropdownIterator.hasNext()) {
            WebElement next = countryDropdownIterator.next();
            String nextText = next.getText();
            if (nextText.contains(selectCountry1)) {
                next.click();
                break;
            }
        }
    }

    public static void calendarFieldSelect(int month, int day, int year) {

        String monthString;
        switch (month) {
            case 1:  monthString = "Jan";
                break;
            case 2:  monthString = "Feb";
                break;
            case 3:  monthString = "Mar";
                break;
            case 4:  monthString = "Apr";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "Jun";
                break;
            case 7:  monthString = "Jul";
                break;
            case 8:  monthString = "Aug";
                break;
            case 9:  monthString = "Sep";
                break;
            case 10: monthString = "Oct";
                break;
            case 11: monthString = "Nov";
                break;
            case 12: monthString = "Dec";
                break;
            default: monthString = "Invalid month";
                break;
        }

        new Select(hw5.monthDD).selectByVisibleText(monthString);
        new Select(hw5.yearDD).selectByVisibleText(String.valueOf(year));

        for (WebElement days : hw5.daysDD
        ) {
            String dateText = days.getText();
            if (dateText.equals(String.valueOf(day))) {
                days.click();
                break;
            }
        }
    }

    public static void selectHobbyCheckboxes(String hobby1, String hobby2) {
        for (int i = 0; i < hw5.hobbyCheckboxes.size(); i++) {
            String hobbyCheckboxesLabelText = hw5.hobbyCheckboxesLabels.get(i).getText();
            if (hobbyCheckboxesLabelText.contains(hobby1) || hobbyCheckboxesLabelText.contains(hobby2)) {
                hw5.hobbyCheckboxes.get(i).click();
            }
        }
    }

    public static void selectAndClickANumberOnTable(int number) {
        for (WebElement numberTable : hw5.numbersTable
        ) {
            String text = numberTable.getText();
            if (text.equals(String.valueOf(number))) {
                numberTable.click();
                break;
            }
        }
    }

    public static void switchToWindow(String pageHandle) {
        try {
            driver.switchTo().window(pageHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
