package SvetlanaOrlovskaya;

import com.PageObject.AbstractPage;
import com.PageObject.MainPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class AbstractTestClass {
    @BeforeMethod
    public void before() throws InterruptedException {
        new MainPage().goTo("https://dom.ria.com/ru/search/");
    }

    @AfterSuite
    public void tearDown(){
        if(AbstractPage.driver!=null)
            AbstractPage.driver.quit();
    }

}
