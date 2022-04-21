package com.syntax.HomeworkAllSeleniumBasic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//Go to http://www.uitestpractice.com/
//        interact with drag and drop, iframe, double click
//        click on home
//        delete one user from the table
//        go to the next link
//        click on the ajax link and wait for the text
//        verify that the text is displayed
//        go to Form
//        and fill out everything
//        go to widgets
//        upload any file and verify it is uploaded
//        go to actions and perform all the necessary actions
//        go to SwitchTo
//        work with alerts and frames
//        go to select
//        perform actions on all dropdowns
public class HW5 {
    static String url = "http://www.uitestpractice.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        //WebDriver driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=/Users/sakirsahin/Library/Application Support/Google/Chrome/Default/Extensions/gighmmpiobklfepjocnamgkkbiglidom/4.44.0_0");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Set<String> allWindowHandles = driver.getWindowHandles(); // store all the handles in a set
        Iterator<String> it = allWindowHandles.iterator(); // have an iterator in order to
        String mainPageHandle = it.next(); // take the first step and assign the main handle
        String childHandle = it.next(); // take the second step and have a child handle
        driver.switchTo().window(childHandle).close();
        driver.switchTo().window(mainPageHandle);


        //drag & drop
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

        //double click button
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@name='dblClick']"));
        action.doubleClick(doubleClickButton).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //iframe
        driver.switchTo().frame(0);
        WebElement inputField = driver.findElement(By.id("name"));
        inputField.sendKeys("sakir");

        //going to home page
        driver.switchTo().defaultContent();
        List<WebElement> navBar = driver.findElements(By.xpath("//ul/li[@style='font-size:20px']/a"));
        for (WebElement nextNavTab : navBar) {
            if (nextNavTab.getText().equals("Home")) {
                nextNavTab.click();
                break;
            }
        }


        //delete one user from table with pagination

        WebDriverWait wait = new WebDriverWait(driver, 20);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        String targetName = "automation";
        boolean flag = true;
        while (flag) {
            List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
            for (WebElement row : rows) {
                String rowText = row.getText();
                if (rowText.contains(targetName)) {
                    flag = false;
                    WebElement editButton = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[contains(text(),'" + targetName + "')]/following-sibling::td[3]/button[text()='EDIT']"));
                    editButton.click();

                    String studentEditURL = driver.getCurrentUrl();
                    String studentID = studentEditURL.substring(studentEditURL.length() - 4);

                    driver.navigate().back();

                    WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick=\"location.href='/Students/DELETE/"+studentID+"';return false;\"]"));
                    deleteButton.click();

                    WebElement deleteButtonConfirmation = driver.findElement(By.xpath("//input[@value='Delete']"));
                    deleteButtonConfirmation.click();
                    break;
                }
            }
            if (flag) {
                WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@rel='next']")));
                nextButton.click();
            }
        }

        //click on the ajax link and wait for the text

        navBar = driver.findElements(By.xpath("//ul/li[@style='font-size:20px']/a"));
        for (WebElement nextNavTab : navBar) {
            if (nextNavTab.getText().equals("AjaxCall")) {
                nextNavTab.click();
                break;
            }
        }

        driver.manage().window().maximize();
        WebElement ajaxButton = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Ajax link")));
        ajaxButton.click();

        //verify that the text is displayed
        WebElement ajaxButtonText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Selenium is a portable')]")));
        if(ajaxButtonText.isDisplayed()){
            System.out.println("Text is displayed");
        }else{
            System.out.println("Text is not displayed");
        }

        //go to Form
        navBar = driver.findElements(By.xpath("//ul/li[@style='font-size:20px']/a"));
        for (WebElement nextNavTab : navBar) {
            if (nextNavTab.getText().equals("Form")) {
                nextNavTab.click();
                break;
            }
        }

        //and fill out everything
        WebElement firstName = driver.findElement(By.cssSelector("input#firstname"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.cssSelector("input#lastname"));
        lastName.sendKeys("Doe");

        List<WebElement> maritalStatusRadioButtonsLabels = driver.findElements(By.xpath("//input[@name='optradio']/parent::label"));
        List<WebElement> maritalStatusRadioButtons = driver.findElements(By.xpath("//input[@name='optradio']"));
        for (int i = 0; i < maritalStatusRadioButtons.size(); i++) {
            if (maritalStatusRadioButtonsLabels.get(i).getText().contains("Divorced")) {
                maritalStatusRadioButtons.get(i).click();
                break;
            }
        }

        List<WebElement> hobbyCheckboxesLabels = driver.findElements(By.xpath("//input[@type='checkbox']/parent::label"));
        List<WebElement> hobbyCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 0; i < hobbyCheckboxes.size(); i++) {
            String hobbyCheckboxesLabelText = hobbyCheckboxesLabels.get(i).getText();
            if (hobbyCheckboxesLabelText.contains("Reading") || hobbyCheckboxesLabelText.contains("Cricket")) {
                hobbyCheckboxes.get(i).click();
            }
        }

        Select countriesDD = new Select(driver.findElement(By.id("sel1")));
        boolean isMultiple = countriesDD.isMultiple();

        if (!isMultiple) {
            List<WebElement> countryOptions = countriesDD.getOptions();
            Iterator<WebElement> countryIterator=countryOptions.iterator();
            while(countryIterator.hasNext()){
                WebElement next= countryIterator.next();
                String nextText = next.getText();
                if(nextText.contains("Denmark")){
                    next.click();
                    break;
                }
            }
        }

        WebElement calendarField = driver.findElement(By.xpath("//input[@id='datepicker']"));
        calendarField.click();

        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select selectMonthDD = new Select(monthDD);
        selectMonthDD.selectByVisibleText("Nov");

        WebElement yearDD = driver.findElement(By.className("ui-datepicker-year"));
        Select selectYearDD = new Select(yearDD);
        selectYearDD.selectByVisibleText("1990");

        List<WebElement> daysDD = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement days : daysDD
        ) {
            String dateText = days.getText();
            if (dateText.equals("29")) {
                days.click();
                break;
            }
        }

        WebElement phoneNumber = driver.findElement(By.cssSelector("input#phonenumber"));
        phoneNumber.sendKeys("+12134567889");
        WebElement username = driver.findElement(By.cssSelector("input#username"));
        username.sendKeys("johndoe");
        WebElement email = driver.findElement(By.cssSelector("input#email"));
        email.sendKeys("johndoe@gmail.com");
        WebElement comment = driver.findElement(By.cssSelector("textarea#comment"));
        comment.sendKeys("Everything is going to be alright");
        WebElement password = driver.findElement(By.cssSelector("input#pwd"));
        password.sendKeys("johndoe123");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        //go to widgets
        navBar = driver.findElements(By.xpath("//ul/li[@style='font-size:20px']/a"));
        for (WebElement nextNavTab : navBar) {
            if (nextNavTab.getText().equals("Widgets")) {
                nextNavTab.click();
                break;
            }
        }

        //upload any file and verify it is uploaded
        WebElement chooseFile = driver.findElement(By.id("image_file"));
        String path = "/Users/sakirsahin/Documents/WritingExcelPractice.xlsx";
        chooseFile.sendKeys(path);

        WebElement uploadButton = driver.findElement(By.xpath("//input[@value='Upload']"));
        uploadButton.click();

        WebElement uploadVerify = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'File Successfully Uploaded')]")));
        if(uploadVerify.getText().contains("File Successfully Uploaded")){
            System.out.println("The file is uploaded");
        }else{
            System.out.println("The file is not uploaded");
        }

        //go to actions and perform all the necessary actions
        navBar = driver.findElements(By.xpath("//ul/li[@style='font-size:20px']/a"));
        for (WebElement nextNavTab : navBar) {
            if (nextNavTab.getText().equals("Actions")) {
                nextNavTab.click();
                break;
            }
        }
        WebElement singleClick = driver.findElement(By.xpath("//button[@name='click']"));
        singleClick.click();

        alert = driver.switchTo().alert();
        alert.accept();

        WebElement doubleClick = driver.findElement(By.xpath("//button[@name='dblClick']"));
        action.doubleClick(doubleClick).perform();
        alert.accept();

        WebElement draggable2 = driver.findElement(By.id("draggable"));
        WebElement droppable2 = driver.findElement(By.id("droppable"));

        action.clickAndHold(draggable2).moveToElement(droppable2).release().build().perform();

        WebElement hoverColor = driver.findElement(By.id("div2"));
        action.moveToElement(hoverColor).perform();


        List<WebElement> numbersTable = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
        for (WebElement numberTable : numbersTable
        ) {
            String text = numberTable.getText();
            if (text.equals("10")) {
                numberTable.click();
                break;
            }
        }

        //go to SwitchTo
        navBar = driver.findElements(By.xpath("//ul/li[@style='font-size:20px']/a"));
        for (WebElement nextNavTab : navBar) {
            if (nextNavTab.getText().equals("Switch to")) {
                nextNavTab.click();
                break;
            }
        }

        //work with alerts and frames
        WebElement alertButton = driver.findElement(By.cssSelector("button#alert"));
        alertButton.click();
        driver.switchTo().alert();
        driver.switchTo().alert().accept();

        WebElement confirmButton = driver.findElement(By.cssSelector("button#confirm"));
        confirmButton.click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.cssSelector("button#prompt")).click();
        driver.switchTo().alert().sendKeys("John");
        driver.switchTo().alert().accept();

        WebElement modalButton = driver.findElement(By.cssSelector("button[data-target='#myModal']"));
        modalButton.click();

        WebElement clickOkModal = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        clickOkModal.click();

        driver.switchTo().frame("iframe_a");
        WebElement frameFill = driver.findElement(By.cssSelector("input#name"));
        frameFill.click();
        frameFill.sendKeys("John Doe");

        driver.switchTo().defaultContent();
        //go to select
        navBar = driver.findElements(By.xpath("//ul/li[@style='font-size:20px']/a"));
        for (WebElement nextNavTab : navBar) {
            if (nextNavTab.getText().equals("Select")) {
                nextNavTab.click();
                break;
            }
        }

        //perform actions on all dropdowns
        Select countriesSingleDD = new Select(driver.findElement(By.cssSelector("select#countriesSingle")));
        isMultiple = countriesSingleDD.isMultiple();

        if (!isMultiple) {
            List<WebElement> countrySingleOptions = countriesSingleDD.getOptions();
            Iterator<WebElement> countrySingleIterator = countrySingleOptions.iterator();
            while (countrySingleIterator.hasNext()) {
                WebElement next = countrySingleIterator.next();
                String nextText = next.getText();
                if (nextText.contains("China")) {
                    next.click();
                    break;
                }
            }
        }

        Select countriesMultipleDD = new Select(driver.findElement(By.cssSelector("select#countriesMultiple")));

        List<WebElement> countryMultipleOptions = countriesMultipleDD.getOptions();
        Iterator<WebElement> countryMultipleIterator = countryMultipleOptions.iterator();
        while (countryMultipleIterator.hasNext()) {
            WebElement next = countryMultipleIterator.next();
            String nextText = next.getText();
            if (nextText.contains("China") || nextText.contains("England")) {
                next.click();
            }
        }

        WebElement countryDropDownButton = driver.findElement(By.cssSelector("button#dropdownMenu1"));
        countryDropDownButton.click();

        List<WebElement> countryDropDownOptions = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
        Iterator<WebElement> countryDropdownIterator = countryDropDownOptions.iterator();
        while (countryDropdownIterator.hasNext()) {
            WebElement next = countryDropdownIterator.next();
            String nextText = next.getText();
            if (nextText.contains("England")) {
                next.click();
                break;
            }
        }


        Thread.sleep(5000);
        driver.quit();


    }
}

