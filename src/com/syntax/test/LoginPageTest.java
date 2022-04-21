package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.testbase.BaseClass;

public class LoginPageTest {
    public static void main(String[] args) {
        BaseClass.openWithSpecificURL("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("Tester");
        loginPage.password.sendKeys("test");
        loginPage.loginButton.click();

        BaseClass.tearDown();
    }
}
