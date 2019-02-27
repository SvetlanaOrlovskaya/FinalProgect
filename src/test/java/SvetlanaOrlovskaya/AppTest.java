package SvetlanaOrlovskaya;

import com.PageObject.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AppTest extends AbstractTestClass {
    MainPage mainPage = new MainPage();

    @Test
    public void isMainPageLoaded(){

       Assert.assertTrue(mainPage.isMainLoaded(),"Check is Main page loaded.");

    }
    @Test
    public void comparingNumberTiles(){
        boolean isComparingNumberTilesmainPage = mainPage.IsNumbersOnPageAreCorespondActualResult();
         Assert.assertTrue(isComparingNumberTilesmainPage, "Compering expected and actual tiles on the page: ");
    }
    @Test
    public void comparingNumberTilesAfterChanges() throws InterruptedException {
        mainPage.changeNumbersOfDisplayingAdverts();
        boolean isComparingNumberTilesmainPage = mainPage.IsNumbersOnPageAreCorespondActualResult();
        Assert.assertTrue(isComparingNumberTilesmainPage, "Compering expected and actual tiles on the page: ");
    }
    @Test
    public void changeValueToShow() throws InterruptedIOException {
        List<String> titels = mainPage.getTileHeaders();
        for (String title : titels) {
            Assert.assertTrue(!title.toLowerCase().contains("вишенка"), "message");
        }

    }


}
