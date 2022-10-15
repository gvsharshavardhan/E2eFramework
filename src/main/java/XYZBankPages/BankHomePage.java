package XYZBankPages;

import org.openqa.selenium.By;


public class BankHomePage extends BasePage {

    //locators
    private final By bankManagerLoginButton = By.xpath("//button[text()='Bank Manager Login']");
    private final By homeButton = By.xpath("//button[text()='Home']");
    private final By customerLoginButton = By.xpath("//button[text()='Customer Login']");

    //methods
    public void goToHomePage() {
        click(homeButton);
    }

    public BankManagerLoginPage goToBankManagerLoginPage() {
        click(bankManagerLoginButton);
        return new BankManagerLoginPage();
    }

    public CustomerLoginPage goToCustomerLoginPage() {
        click(customerLoginButton);
        return new CustomerLoginPage();
    }

}