package com.syntax.reviewClass05.HW;

import com.syntax.pages.DashboardPage;
import com.syntax.pages.LoginPageWithPageFactory;
import com.syntax.pages.PimPage;
import com.syntax.testbase.BaseClass;
import com.syntax.utils.CommonMethods;
import org.openqa.selenium.By;
//goto syntax hrms application
//        In the table in PIM/EmployeeList
//        just pick one random username and check it,
//        no need to delete it , just make sure it is checked.
//        share the screenshot  of the webpage in channel (edited)
public class HW {
    public static void main(String[] args) {
        BaseClass.openWithSpecificURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        LoginPageWithPageFactory loginPageWithPageFactory = new LoginPageWithPageFactory();
        loginPageWithPageFactory.username.sendKeys("Admin");
        loginPageWithPageFactory.password.sendKeys("Hum@nhrm123");
        loginPageWithPageFactory.loginButton.click();
        DashboardPage dashboardPage = new DashboardPage();
        BaseClass baseClass = new BaseClass();
        dashboardPage.pimTabButton.click();

        PimPage pimPage = new PimPage();
        boolean flag = true;
        while (flag) {
            pimPage.employeeListTableRowList = baseClass.driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
            pimPage.employeeListTableCheckBoxList = baseClass.driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[1]"));
            for (int i = 0; i < pimPage.employeeListTableRowList.size(); i++) {
                pimPage.employeeListTableRowList = baseClass.driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
                String rowText = pimPage.employeeListTableRowList.get(i).getText();

                if (rowText.contains("rojano9090")) {
                    if (!pimPage.employeeListTableCheckBoxList.get(i).isSelected()) {
                        pimPage.employeeListTableCheckBoxList.get(i).click();
                        flag = false;
                    }
                }
            }
            if (flag) {
                pimPage.nextButton = baseClass.driver.findElement(By.xpath("//a[text()='Next']"));
                pimPage.nextButton.click();
            }
        }

        CommonMethods.takeScreenShot("screenshots/ReviewClass06/HW.png");

        BaseClass.tearDown();
    }
}
