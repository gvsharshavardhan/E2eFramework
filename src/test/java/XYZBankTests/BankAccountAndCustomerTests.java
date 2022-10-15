package XYZBankTests;

import XYZBankPages.BankHomePage;
import XYZBankPages.BankManagerLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankAccountAndCustomerTests extends BaseTest {

    BankHomePage bankHomePage;

    @Test
    public void testAddCustomer() {
        String firstname = "Akshaya";
        String lastname = "Jayaprakash";
        String postcode = "z12d34";
        bankHomePage = new BankHomePage();
        BankManagerLoginPage bankManagerLoginPage = bankHomePage.goToBankManagerLoginPage();
        bankManagerLoginPage.addCustomer(firstname, lastname, postcode);
        Assert.assertTrue(bankManagerLoginPage.isCustomerCreated(firstname), "Customer is not created!!");
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

}