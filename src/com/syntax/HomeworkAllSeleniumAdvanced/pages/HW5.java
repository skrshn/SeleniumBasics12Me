package com.syntax.HomeworkAllSeleniumAdvanced.pages;

import com.syntax.HomeworkAllSeleniumAdvanced.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW5 extends CommonMethods {
    @FindBy(id = "draggable")
    public WebElement draggable;

    @FindBy(id = "droppable")
    public WebElement droppable;

    @FindBy(id = "name")
    public WebElement inputField;

    @FindBy(xpath = "//button[@name='dblClick']")
    public WebElement doubleClickButton;

    @FindBy(xpath = "//table[@class='table']/tbody/tr")
    public List<WebElement> getRows;

    @FindBy(xpath = "//input[@value='Delete']")
    public WebElement deleteButtonConfirmation;

    @FindBy(xpath = "//a[@rel='next']")
    public WebElement nextButton;

    @FindBy(xpath = "//ul/li[@style='font-size:20px']/a")
    public List<WebElement> navBar;

    @FindBy(partialLinkText = "Ajax link")
    public WebElement ajaxButton;

    @FindBy(xpath = "//p[contains(text(),'Selenium is a portable')]")
    public WebElement ajaxButtonText;

    @FindBy(css = "input#firstname")
    public WebElement firstName;

    @FindBy(css = "input#lastname")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='optradio']/parent::label")
    public List<WebElement> maritalStatusRadioButtonsLabels;

    @FindBy(xpath = "//input[@name='optradio']")
    public List<WebElement> maritalStatusRadioButtons;

    @FindBy(xpath = "//input[@type='checkbox']/parent::label")
    public List<WebElement> hobbyCheckboxesLabels;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> hobbyCheckboxes;

    @FindBy(id = "sel1")
    public WebElement countriesDD;

    @FindBy(xpath = "//input[@id='datepicker']")
    public WebElement calendarField;

    @FindBy(className = "ui-datepicker-month")
    public WebElement monthDD;

    @FindBy(className = "ui-datepicker-year")
    public WebElement yearDD;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> daysDD;

    @FindBy(css = "input#phonenumber")
    public WebElement phoneNumber;

    @FindBy(css = "input#username")
    public WebElement username;

    @FindBy(css = "input#email")
    public WebElement email;

    @FindBy(css = "textarea#comment")
    public WebElement comment;

    @FindBy(css = "input#pwd")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(id = "image_file")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@value='Upload']")
    public WebElement uploadButton;

    @FindBy(xpath = "//p[contains(text(),'File Successfully Uploaded')]")
    public WebElement uploadVerify;

    @FindBy(xpath = "//button[@name='click']")
    public WebElement singleClick;

    @FindBy(xpath = "//button[@name='dblClick']")
    public WebElement doubleClick;

    @FindBy(id = "div2")
    public WebElement hoverColor;

    @FindBy(xpath = "//ol[@id='selectable']/li")
    public List<WebElement> numbersTable;

    @FindBy(css = "button#alert")
    public WebElement alertButton;

    @FindBy(css = "button#confirm")
    public WebElement confirmButton;

    @FindBy(css = "button#prompt")
    public WebElement promptButton;

    @FindBy(css = "button[data-target='#myModal']")
    public WebElement modalButton;

    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement clickOkModal;

    @FindBy(css = "input#name")
    public WebElement frameFill;

    @FindBy(css = "select#countriesSingle")
    public WebElement countriesSingle;

    @FindBy(css = "select#countriesMultiple")
    public WebElement countriesMultiple;

    @FindBy(css = "button#dropdownMenu1")
    public WebElement countryDropDownButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a")
    public List<WebElement> countryDropDownOptions;


    public HW5() {
        PageFactory.initElements(driver,this);
    }

}
