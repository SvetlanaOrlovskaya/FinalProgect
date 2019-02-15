package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingelton {
    private static WebDriver driver;

    public static WebDriver get()
    {
        if (driver == null)
            new DriverSingelton();

        return driver;
    }

    private DriverSingelton() {
          System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
          driver = new ChromeDriver();

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
          driver.manage().window().maximize();

    }

}
