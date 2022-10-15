package XYZBankTests;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.init();
        DriverManager.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
