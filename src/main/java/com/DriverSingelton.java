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
        Settings settings = new Settings();
          if ( settings.getBrowser().equalsIgnoreCase("chrome")){
          System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
          driver = new ChromeDriver();
          }
          else
          if ( settings.getBrowser().equalsIgnoreCase("edge")){
              System.setProperty("webdriver.edge.driver", "Drivers\\edgedriver.exe");
              driver = new EdgeDriver();
          }

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
          driver.manage().window().maximize();

    }

}
