package com.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends AbstractPage {
    public MainPage goTo (String url){
        driver.get(url);
        return this;
    }
    public  boolean isMainLoaded (){

        return driver.findElement(By.id("searchTitleCategory")).getText().equalsIgnoreCase("Поиск недвижимости");

    }

    public  MainPage dropDown (int numbers){

        Select dropdown = new Select(driver.findElement(By.className("el-selected open")));
        dropdown.selectByValue(String.valueOf(numbers));
        return this;
    }

    public
 //           setNumberOfTiles


}
