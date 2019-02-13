package SvetlanaOrlovskaya;

import com.PageObject.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest {
    MainPage mainPage = new MainPage();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void loadMaimPage(){

        mainPage.goTo("https://dom.ria.com/ru/search/");

    }
    @Test
    public void quantityTest(){
//        mainPage.
    }

}
