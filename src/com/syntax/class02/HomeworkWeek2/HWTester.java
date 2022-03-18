package com.syntax.class02.HomeworkWeek2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTester {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        HW1 hw1 = new HW1();
        hw1.HW1();

        HW2 hw2 = new HW2();
        hw2.HW2();
    }
}
