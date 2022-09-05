package com.fb.qa.base;

import com.fb.qa.util.WebEventListener;
import com.fb.qa.util.testutil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static WebDriver driver;
    public static Properties prop;


    public TestBase() throws FileNotFoundException {

        try {

            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    "D:/Facebook/src/main/java/com/fb/qa/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() throws FileNotFoundException {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with
        // EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
}
