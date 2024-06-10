package com.myideasoft.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactor {
    public static void main(String[] args) {
        /* * write a static method
         * that is named getDriver
         * it takes a string parameter (browserType)
         * it will set up browser
         * it will return a driver based on parameter (chrome, firefox, safari, edge etc..
         */
    }

    public static WebDriver getDriver (String browserType ){
        WebDriver driver=null;

        switch (browserType.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge" :
                driver = new EdgeDriver();
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("hatali webdriver type");
        }
        return driver;
    }

    public static void wait (int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static WebDriver getDriverNew (){
        WebDriver driver=null;
        String browserType =BrowserTypes.browser;
        switch (browserType.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge" :
                driver = new EdgeDriver();
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("hatali webdriver type");
        }
        return driver;
    }
}
