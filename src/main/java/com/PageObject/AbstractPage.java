package com.PageObject;
import com.DriverSingelton;
import org.openqa.selenium.WebDriver;


public class AbstractPage {
   protected static WebDriver driver = DriverSingelton.get();

}
