package com.PageObject;

import com.DriverSingelton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    public static WebDriver driver = DriverSingelton.get();

    public static int substringInt (String s){
      return Integer.valueOf(s.replaceAll("[^0-9]", ""));
    }

    public static void scrollToBottom() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public static void scrollDownToElement(WebElement element){
        int y = element.getLocation().getY();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollTo(0, "+y+")");
    }

}