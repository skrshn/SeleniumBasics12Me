package com.syntax.HomeworkAllSeleniumAdvanced.test;

import com.syntax.HomeworkAllSeleniumAdvanced.testbase.BaseClass;
import com.syntax.HomeworkAllSeleniumAdvanced.utils.CommonMethods;

import java.util.Iterator;
import java.util.Set;

/**
 *         HW
 *         open new browser
 *         open a new tab
 *         navigate to a different URL on a new tab
 */
public class HW1Test {
    public static void main(String[] args) throws InterruptedException {
        BaseClass.openWithSpecificURL("http://live.com");
        BaseClass.openNewTabWithSpecificURL("http://yahoo.com");

        Set<String> allWindowHandles = BaseClass.driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();

        String mainPageHandle = it.next();
        String childPageHandle = it.next();
//        Thread.sleep(2000);
        CommonMethods.switchToWindow(mainPageHandle);
//        Thread.sleep(2000);
        CommonMethods.switchToWindow(childPageHandle);
//        Thread.sleep(2000);

        CommonMethods.takeScreenShot("screenshots/HomeworkAllSeleniumAdvanced/HW1.png");

        BaseClass.tearDown();
    }
}
