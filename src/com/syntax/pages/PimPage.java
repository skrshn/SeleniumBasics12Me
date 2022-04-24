package com.syntax.pages;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimPage extends CommonMethods {
    @FindBy (xpath = "//*[@id='resultTable']/tbody/tr")
    public static List<WebElement> employeeListTableRowList;

    @FindBy (xpath = "//*[@id='resultTable']/tbody/tr/td[1]")
    public static List<WebElement> employeeListTableCheckBoxList;

    @FindBy (xpath = "//a[text()='Next']")
    public static WebElement nextButton;


    public PimPage(){
        PageFactory.initElements(driver,this);
    }
}
