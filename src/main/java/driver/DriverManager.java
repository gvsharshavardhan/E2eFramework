package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {

    private static WebDriver driver ;
    private static WebDriverWait wait;

    private DriverManager() {
    }

    //@beforemethod
    public static void init() {

        String browser = "chrome";

        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
        }else{
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
        }
         wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    public static WebDriverWait getExplicitWait(){
        return wait;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }


}