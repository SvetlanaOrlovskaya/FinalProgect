package com.PageObject;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.PageObject.Utils.scrollToBottom;

public class MainPage extends AbstractPage {
    public MainPage goTo (String url) throws InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(5000);
        return this;
    }
    public  boolean isMainLoaded (){

        return driver.findElement(By.id("searchTitleCategory")).getText().equalsIgnoreCase("поиск недвижимости");

    }

     public int numberOfTheTilesOnMainPage (){
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"pagination\"]/div/div[2]/span/a"));
        String stringOfNumber = dropDown.getText().split(" ")[0];
        Allure.addAttachment("Numbers of the Tiles in Drop Down on Main Page by default: ", "Number: " + stringOfNumber);
        return Integer.valueOf(stringOfNumber);
    }

    public int actualNumberOfTheTilesThatDisplayed() {
        List<WebElement> arrayOfBlocks=driver.findElements(By.cssSelector(".wrap_desc"));
        arrayOfBlocks.removeIf(elem->elem.isDisplayed()==false);
        Allure.addAttachment("Numbers of the Tiles in Drop Down on Main Page by default actual: ", "Number: " + arrayOfBlocks.size());
        return arrayOfBlocks.size();

    }

    public List<WebElement> getTiles() {
        return driver.findElements(By.className("wrap_desc"));
    }

    public boolean IsNumbersOnPageAreCorespondActualResult(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int expected = numberOfTheTilesOnMainPage();
        int actual = actualNumberOfTheTilesThatDisplayed();
        System.out.println("expected = "+expected+"----------- actual = "+actual);
        return expected == actual;
    }

    public List<String> getTileHeaders() {
        List<WebElement> listOfTiles = getTiles();
        List<String> forReturn = new ArrayList<>();

        for(WebElement tile:listOfTiles){
            forReturn.add(tile.findElement(By.className("blue")).getText());
        }
        return forReturn;

    }


     public int findNumbersaOfAdverts(){
        scrollToBottom();
        WebElement count = driver.findElement(By.xpath("//*[@id='pagination']//div[@class='text-r ml-15 box-panel']/span"));
        List<String> items = Arrays.asList(count.getText().split(" "));
        String myString = items.get(0);
        return Integer.parseInt(myString);

    }
    public MainPage changeNumbersOfDisplayingAdverts() throws InterruptedException {
        int initialNumbersOfDisplayingAdverts = findNumbersaOfAdverts();
       //driver.findElement(By.xpath("//*[@id='pagination']//div[@class='text-r ml-15 box-panel']/span")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='pagination']//div[@class='text-r ml-15 box-panel']/span"))).click().build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> listOfNumbersOfDisplayingAdverts = driver.findElements(By.xpath("//span[@id=\'countOnPage\']//span[@class=\'item\']"));

        for ( int i =0; i<listOfNumbersOfDisplayingAdverts.size(); i++){
           String temp = listOfNumbersOfDisplayingAdverts.get(i).getText();
            int tempInt = Integer.parseInt(temp);

            if(initialNumbersOfDisplayingAdverts !=tempInt){
                listOfNumbersOfDisplayingAdverts.get(i).click();
                break;
            }
        }
        //listOfNumbersOfDisplayingAdverts.get(0);
        Thread.sleep(5000);
        return  this;
    }



}
