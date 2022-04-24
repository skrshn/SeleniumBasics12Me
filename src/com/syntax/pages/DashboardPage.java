package com.syntax.pages;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonMethods {
    @FindBy(id = "welcome")
    public static WebElement welcomeAdmin;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    public static WebElement pimTabButton;




    public DashboardPage() {
        PageFactory.initElements(driver,this);
    }
}
