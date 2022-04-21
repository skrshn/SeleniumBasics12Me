package com.syntax.HomeworkAllSeleniumAdvanced.test;

import com.syntax.HomeworkAllSeleniumAdvanced.pages.HW2_3_4;
import com.syntax.HomeworkAllSeleniumAdvanced.testbase.BaseClass;
import com.syntax.HomeworkAllSeleniumAdvanced.utils.CommonMethods;
import org.openqa.selenium.JavascriptExecutor;

public class HW4Test {
    public static void main(String[] args) {
        BaseClass.openWithSpecificURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        HW2_3_4 hw234 = new HW2_3_4();
        hw234.username.sendKeys("Admin");
        hw234.password.sendKeys("wrongPassword");
        hw234.loginButton.click();

        if(hw234.wrongPasswordErrorMessageField.isDisplayed()){
            System.out.println("Invalid Credentials error message is verified.");
        }
        else{
            System.out.println("Invalid Credentials error message is NOT verified.");

        }
        BaseClass.js = (JavascriptExecutor) BaseClass.driver;
        BaseClass.js.executeScript("arguments[0].style.backgroundColor='red'", hw234.wrongPasswordErrorMessageField);

        CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW4.png");

        BaseClass.tearDown();
    }
}
