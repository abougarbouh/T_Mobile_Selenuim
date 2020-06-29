package Base;

import Util.TestUtil;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    //public static WebDriver driver;
    public static Properties prop;
    public static WebDriver driver = null;


    public TestBase() {


        try {






            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/ahmed/Desktop/T-Mobile/src/main/java/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization() throws MalformedURLException {

        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.out.println("Browser is Chrome");
            ChromeOptions cap = new ChromeOptions();
            cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                    UnexpectedAlertBehaviour.IGNORE);

            driver = new RemoteWebDriver(new URL("http://10.0.1.11:4444/wd/hub"), cap);


            //System.setProperty("webdriver.chrome.driver", "/Users/ahmadkhalili/Desktop/chromedriver");
            //driver = new ChromeDriver();


        } else if (browserName.equals("FF")) {
            System.out.println("Browser is Firefox");
            DesiredCapabilities cap;
            cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                    UnexpectedAlertBehaviour.IGNORE);

            driver = new RemoteWebDriver(new URL("http://10.0.1.11:4444/wd/hub"), cap);


            /*
            System.setProperty("webdriver.gecko.driver", "/Users/ahmadkhalili/Desktop/geckodriver");
            driver = new FirefoxDriver();
            */

        } else if (browserName.equals("SS")) {
            System.out.println("Browser is Safari");
            SafariOptions cap = new SafariOptions();

            driver = new RemoteWebDriver(new URL("http://10.0.1.11:4444/wd/hub"), cap);


        }




         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


        driver.get(prop.getProperty("url"));

    }
}



