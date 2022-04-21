package com.syntax.HomeworkAllSeleniumAdvanced.pages;

import com.syntax.HomeworkAllSeleniumAdvanced.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HW2_3_4 extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement password;

    @FindBy(xpath="//input[@name='Submit']")
    public WebElement loginButton;

    @FindBy(xpath="//span[text()='Password cannot be empty']")
    public WebElement passwordCannotBeEmptyErrorMessageField;

    @FindBy(xpath="//span[text()='Username cannot be empty']")
    public WebElement usernameCannotBeEmptyErrorMessageField;

    @FindBy(xpath="//span[text()='Invalid credentials']")
    public WebElement wrongPasswordErrorMessageField;

    public HW2_3_4() {
        PageFactory.initElements(driver,this);
    }
}
