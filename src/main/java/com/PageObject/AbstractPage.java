package com.PageObject;
import com.DriverSingelton;
import org.openqa.selenium.WebDriver;


public class AbstractPage {
   public static WebDriver driver = DriverSingelton.get();

}
