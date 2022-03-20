package com.syntax.groupProject17;

public class Task5 {
    public static void main(String[] args) {
        RemoteWebDriver[] driver = {new ChromeDriver(),new FirefoxDriver(),new SafariDriver()};

        for (RemoteWebDriver d:driver) {
            d.open();
            d.navigate();
            System.out.println(d.getTitle());
            d.close();
        }
    }
}
interface WebDriver{
    void open();
    void close();
    String getTitle();
}
interface RemoteWebDriver extends WebDriver{
    void navigate();
}
interface TakesScreenshot extends RemoteWebDriver{
    void getScreenshot();
}
class ChromeDriver implements RemoteWebDriver{
    @Override
    public void open() {
        System.out.println("Opens Chrome");
    }

    @Override
    public void close() {
        System.out.println("Closes Chrome");
    }

    @Override
    public String getTitle() {return "Title Returned on Chrome";}   //returns the title of the

    @Override
    public void navigate(){
        System.out.println("Navigate on Chrome");
    }
}
class FirefoxDriver implements RemoteWebDriver{
    @Override
    public void open() {
        System.out.println("Opens Firefox");
    }

    @Override
    public void close() {
        System.out.println("Closes Firefox");
    }

    @Override
    public String getTitle() {return "Title Returned on Firefox";}  //returns the title of the

    @Override
    public void navigate(){
        System.out.println("Navigate on Firefox");
    }
}
class SafariDriver implements RemoteWebDriver{
    @Override
    public void open() {
        System.out.println("Opens Safari");
    }

    @Override
    public void close() {
        System.out.println("Closes Safari");
    }

    @Override
    public String getTitle() {return "Title Returned on Safari";}

    @Override
    public void navigate(){
        System.out.println("Navigate on Safari");
    }
}