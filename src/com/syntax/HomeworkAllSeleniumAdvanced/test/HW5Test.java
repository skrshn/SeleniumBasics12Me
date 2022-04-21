package com.syntax.HomeworkAllSeleniumAdvanced.test;

import com.syntax.HomeworkAllSeleniumAdvanced.pages.HW5;
import com.syntax.HomeworkAllSeleniumAdvanced.testbase.BaseClass;
import com.syntax.HomeworkAllSeleniumAdvanced.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class HW5Test {
    public static void main(String[] args) throws InterruptedException {
        BaseClass.openSpecificURLWithAdBlocker("http://www.uitestpractice.com");

        boolean screenShotFlag = true;
        int screenShotNo=1;
        while(screenShotFlag) {
            //drag & drop
            CommonMethods.dragAndDrop();

            //double click button
            CommonMethods.doubleClick();

            //iframe
            CommonMethods.switchToFrame(0);

            HW5 hw5 = new HW5();
            hw5.inputField.sendKeys("John Doe");

            //take a screenshot of the first part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");

            //go to home page
            CommonMethods.navBarTabs("Home");

            //delete one user from table with pagination
            CommonMethods.deleteUserFromTable("Carol");

            //take a screenshot of the second part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");

            //click on the ajaxCall tab and wait for the text
            CommonMethods.navBarTabs("AjaxCall");
            hw5.ajaxButton.click();

            //verify that the text is displayed after clicking ajaxButton
            CommonMethods.verifyAjaxButtonText();

            //take a screenshot of the third part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");

            //go to Form
            CommonMethods.navBarTabs("Form");

            //fill out the Form
            hw5.firstName.sendKeys("John");
            hw5.lastName.sendKeys("Doe");

            CommonMethods.selectMaritalStatusRadioButtons("Single");
            CommonMethods.selectHobbyCheckboxes("Reading", "Cricket");

            CommonMethods.selectCountriesDD("Denmark");

            hw5.calendarField.click();

            CommonMethods.calendarFieldSelect(10, 29, 1990);

            hw5.phoneNumber.sendKeys("+12134567889");
            hw5.username.sendKeys("johndoe");
            hw5.email.sendKeys("johndoe@gmail.com");
            hw5.comment.sendKeys("Everything is going to be alright");
            hw5.password.sendKeys("johndoe123");

            //take a screenshot of the fourth part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");

            hw5.submitButton.click();

            //go to widgets
            CommonMethods.navBarTabs("Widgets");

            //upload any file and verify it is uploaded
            String path = "/Users/sakirsahin/Documents/WritingExcelPractice.xlsx";
            hw5.chooseFile.sendKeys(path);
            hw5.uploadButton.click();
            CommonMethods.verifyUploadText();

            //take a screenshot of the fifth part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");

            //go to actions
            CommonMethods.navBarTabs("Actions");

            //perform all the necessary actions
            hw5.singleClick.click();
            BaseClass.driver.switchTo().alert().accept();

            CommonMethods.doubleClick();

            CommonMethods.dragAndDrop();

            BaseClass.action.moveToElement(hw5.hoverColor).perform();

            CommonMethods.selectAndClickANumberOnTable(10);

            //take a screenshot of the sixth part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");

            //go to SwitchTo
            CommonMethods.navBarTabs("Switch to");

            //work with alerts and frames
            hw5.alertButton.click();
            BaseClass.driver.switchTo().alert().accept();

            hw5.confirmButton.click();
            BaseClass.driver.switchTo().alert().dismiss();

            hw5.promptButton.click();
            BaseClass.driver.switchTo().alert().sendKeys("John");
            BaseClass.driver.switchTo().alert().accept();

            hw5.modalButton.click();

            hw5.clickOkModal.click();

            CommonMethods.switchToFrame("iframe_a");
            hw5.frameFill.click();
            hw5.frameFill.sendKeys("John Doe");

            BaseClass.driver.switchTo().defaultContent();

            //take a screenshot of the seventh part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");

            //go to select
            CommonMethods.navBarTabs("Select");

            //perform actions on all dropdowns
            CommonMethods.selectCountriesSingleDD("China");
            CommonMethods.selectCountriesMultipleDD("England", "China");

            hw5.countryDropDownButton.click();
            CommonMethods.countryDDSelect("England");

            //take a screenshot of the eighth part of the hw
            CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW5_"+ screenShotNo++ +".png");
            screenShotFlag=false;
        }
        //quit the browser
        CommonMethods.tearDown();

    }
}
