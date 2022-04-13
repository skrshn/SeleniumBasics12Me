package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesDemo01 {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        username.sendKeys("Admin");
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='Submit']"));
        loginButton.click();

        WebElement pimTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        pimTab.click();

        WebElement addEmployeeButton = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        addEmployeeButton.click();


        WebElement addEmployeeFirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        addEmployeeFirstName.sendKeys("JohnA");

        WebElement addEmployeeMiddleName = driver.findElement(By.xpath("//input[@id='middleName']"));
        addEmployeeMiddleName.sendKeys("Michael");

        WebElement addEmployeeLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        addEmployeeLastName.sendKeys("ADoe");

        WebElement addEmployeeID = driver.findElement(By.xpath("//input[@id='employeeId']"));
        String employeeID = addEmployeeID.getAttribute("value");

        WebElement saveButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
        saveButton.click();

        WebElement employeeListButton = driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
        employeeListButton.click();


        boolean flag = true;
        while (flag) {
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i =0; i<rows.size();i++) {
                String rowText = rows.get(i).getText();
                //System.out.println(rowText);
                if(rowText.contains(employeeID)){
                    flag=false;
                    //List<WebElement> checkBox = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[1]"));
                    WebElement checkbox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]"));
                    checkbox.click();
                    WebElement deleteButton = driver.findElement(By.xpath("//input[@id='btnDelete']"));
                    deleteButton.click();
                    WebElement dialogDeleteBtn = driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']"));
                    dialogDeleteBtn.click();
                    break;
                }
            }
            WebElement nextButton = driver.findElement(By.linkText("Next"));
            if(flag) {
                nextButton.click();
            }

        }

    }
}
