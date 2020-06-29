package TestCases;

import Base.TestBase;
import Util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.MalformedURLException;

public class HomePageTest extends TestBase {
    TestUtil testUtil;
    HomePage homepage;



    public HomePageTest() {
        super();
    }




    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        testUtil = new TestUtil();
        homepage = new HomePage();
    }



    @Test(priority = 1)
    public void navigation_bar(){
        homepage.valida_universal_menu_bar();
        homepage.validateHomePageURL();
        homepage.validateNavigationBar();




    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
