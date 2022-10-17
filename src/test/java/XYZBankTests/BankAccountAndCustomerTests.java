package XYZBankTests;

import XYZBankPages.BankHomePage;
import XYZBankPages.BankManagerLoginPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ReportManager;

public class BankAccountAndCustomerTests extends BaseTest {

    BankHomePage bankHomePage;

    @Test
    public void testAddCustomer() {
        String firstname = "Akshaya";
        String lastname = "Jayaprakash";
        String postcode = "z12d34";
        bankHomePage = new BankHomePage();
        BankManagerLoginPage bankManagerLoginPage = bankHomePage.goToBankManagerLoginPage();
        ReportManager.getExtentTest().info("logged into bank manager page!!");
        bankManagerLoginPage.addCustomer(firstname, lastname, postcode);
        ReportManager.getExtentTest().info("added new customer!!");
        String screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ReportManager.getExtentTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        Assert.assertTrue(bankManagerLoginPage.isCustomerCreated(firstname), "Customer is not created!!");
        ReportManager.getExtentTest().info("customer creation assertion passed!");
    }

    @Test
    public void testAddCustomerAndAddAccount() {
        String firstname = "Akshaya";
        String lastname = "Jayaprakash";
        String postcode = "z12d34";
        String currency = "Dollar";
        String fullName = firstname + " " + lastname;
        bankHomePage = new BankHomePage();
        BankManagerLoginPage bankManagerLoginPage = bankHomePage.goToBankManagerLoginPage();
        bankManagerLoginPage.addCustomer(firstname, lastname, postcode);
        Assert.assertTrue(bankManagerLoginPage.isCustomerCreated(firstname), "Customer is not created!!");

        String accountNo = bankManagerLoginPage.createAccountForCustomer(fullName, currency);
        Assert.assertTrue(bankManagerLoginPage.isAccountCreatedForCustomer(firstname, accountNo), "Account is not created!!");
    }

    @Test
    public void harshaTest(){
        System.out.println("testing method!!");
    }

}