package XYZBankTests;

import XYZBankPages.BankHomePage;
import XYZBankPages.BankManagerLoginPage;
import XYZBankPages.CustomerLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankDepositWithdrawTests extends BaseTest {
    BankHomePage bankHomePage;

    @Test
    public void testDeposit() {
        String firstname = "Akshaya";
        String lastname = "Jayaprakash";
        String postcode = "z12d34";
        String currency = "Dollar";
        String fullName = firstname + " " + lastname;
        bankHomePage = new BankHomePage();
        BankManagerLoginPage bankManagerLoginPage = bankHomePage.goToBankManagerLoginPage();
        //add customer
        bankManagerLoginPage.addCustomer(firstname, lastname, postcode);
        Assert.assertTrue(bankManagerLoginPage.isCustomerCreated(firstname), "Customer is not created!!");
        //add account to the customer
        String accountNo = bankManagerLoginPage.createAccountForCustomer(fullName, currency);
        Assert.assertTrue(bankManagerLoginPage.isAccountCreatedForCustomer(firstname, accountNo), "Account is not created!!");
        //deposite into account
        String depositeAmt = "1000";
        bankHomePage.goToHomePage();
        CustomerLoginPage customerLoginPage = bankHomePage.goToCustomerLoginPage();
        customerLoginPage.login(fullName);
        customerLoginPage.depositAmt(depositeAmt);
        Assert.assertTrue(customerLoginPage.getCurrentBalance().equals(depositeAmt), "Deposit functionality did not work!!");
    }

    @Test
    public void testWithDraw() {
        String firstname = "Akshaya";
        String lastname = "Jayaprakash";
        String postcode = "z12d34";
        String currency = "Dollar";
        String fullName = firstname + " " + lastname;
        bankHomePage = new BankHomePage();
        BankManagerLoginPage bankManagerLoginPage = bankHomePage.goToBankManagerLoginPage();
        //add customer
        bankManagerLoginPage.addCustomer(firstname, lastname, postcode);
        Assert.assertTrue(bankManagerLoginPage.isCustomerCreated(firstname), "Customer is not created!!");
        //add account to the customer
        String accountNo = bankManagerLoginPage.createAccountForCustomer(fullName, currency);
        Assert.assertTrue(bankManagerLoginPage.isAccountCreatedForCustomer(firstname, accountNo), "Account is not created!!");
        //deposite into account
        String depositeAmt = "1000";
        bankHomePage.goToHomePage();
        CustomerLoginPage customerLoginPage = bankHomePage.goToCustomerLoginPage();
        customerLoginPage.login(fullName);
        customerLoginPage.depositAmt(depositeAmt);
        Assert.assertTrue(customerLoginPage.getCurrentBalance().equals(depositeAmt), "Deposit functionality did not work!!");
        //withdraw amt
        String withdrawamt = "200";
        customerLoginPage.withDrawAmt(withdrawamt);
        Assert.assertTrue(customerLoginPage.getCurrentBalance().equals("800"), "Withdraw functionality did not work!!");
    }
}
