package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {


    private static WebDriverWait wait;

    private static final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    private DriverManager() {
    }


    public static void init() {
        WebDriver driver;
        String browser = "chrome";

        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            tl.set(driver);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            tl.set(driver);
        }

        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
    }


    public static WebDriverWait getExplicitWait() {
        return wait;
    }

    public static WebDriver getDriver() {
        return tl.get();
    }

    public static void quitDriver() {
        tl.get().quit();
    }

}