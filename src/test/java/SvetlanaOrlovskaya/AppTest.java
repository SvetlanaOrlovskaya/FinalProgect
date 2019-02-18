package SvetlanaOrlovskaya;

import com.PageObject.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest extends AbstractTestClass {
    MainPage mainPage = new MainPage();
    /**
     * Rigorous Test :-)
     */

    @Test
    public void isMainPageLoaded(){

       Assert.assertTrue(mainPage.isMainLoaded(),"Check is Main page loaded.");


    }
    @Test
    public void comperingTiles(){
        int expected = mainPage.numberOfTheTilesOnMainPage();
        int actual = mainPage.actualNumberOfTheTilesThatDisplayed();
         Assert.assertEquals(expected, actual, "Compering expected and actual tiles on the page: ");
    }
    @Test
    public void changeValueToShow(){


    }

}
