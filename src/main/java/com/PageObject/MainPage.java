package com.PageObject;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.PageObject.Utils.scrollToBottom;

public class MainPage extends AbstractPage {
    public MainPage goTo (String url){
        driver.get(url);
        return this;
    }
    public  boolean isMainLoaded (){

        return driver.findElement(By.id("searchTitleCategory")).getText().equalsIgnoreCase("поиск недвижимости");

    }

 /*   public  MainPage dropDown (int numbers){

        Select dropdown = new Select(driver.findElement(By.className("el-selected open")));
        dropdown.selectByValue(String.valueOf(numbers));
        return this;
    }
*/
    public int numberOfTheTilesOnMainPage (){
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"pagination\"]/div/div[2]/span/a"));
        String stringOfNumber = dropDown.getText().split(" ")[0];
        Allure.addAttachment("Numbers of the Tiles in Drop Down on Main Page by default: ", "Number: " + stringOfNumber);
        return Integer.valueOf(stringOfNumber);
    }

    public int actualNumberOfTheTilesThatDisplayed() {
        List<WebElement> arrayOfBlocks=driver.findElements(By.cssSelector(".wrap_desc"));
        Allure.addAttachment("Numbers of the Tiles in Drop Down on Main Page by default actual: ", "Number: " + arrayOfBlocks.size());
        return arrayOfBlocks.size();
    }
 /*   public MainPage setQuantityTiles(int number) {
        scrollToBottom();
        dropDownQuantity.click();
    }

*/

}
