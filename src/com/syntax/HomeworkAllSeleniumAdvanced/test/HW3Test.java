package com.syntax.HomeworkAllSeleniumAdvanced.test;

import com.syntax.HomeworkAllSeleniumAdvanced.pages.HW2_3_4;
import com.syntax.HomeworkAllSeleniumAdvanced.testbase.BaseClass;
import com.syntax.HomeworkAllSeleniumAdvanced.utils.CommonMethods;
import org.openqa.selenium.JavascriptExecutor;

public class HW3Test {
    public static void main(String[] args) {
        BaseClass.openWithSpecificURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        HW2_3_4 hw234 = new HW2_3_4();
        hw234.username.sendKeys("");
        hw234.password.sendKeys("");
        hw234.loginButton.click();

        if(hw234.usernameCannotBeEmptyErrorMessageField.isDisplayed()){
            System.out.println("Username cannot be empty error message is verified.");
        }
        else{
            System.out.println("Username cannot be empty error message is NOT verified.");

        }
        BaseClass.js = (JavascriptExecutor) BaseClass.driver;
        BaseClass.js.executeScript("arguments[0].style.backgroundColor='red'", hw234.usernameCannotBeEmptyErrorMessageField);

        CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW3.png");

        BaseClass.tearDown();
    }
}
