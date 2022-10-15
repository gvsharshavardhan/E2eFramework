package XYZBankPages;

import org.openqa.selenium.By;

public class CustomerLoginPage extends BasePage {

    //login locators
    private final By customerNameDropDown = By.id("userSelect");
    private final By loginButtonLocator = By.xpath("//button[normalize-space(text())='Login']");

    private final By balanceTextLocator = By.xpath("//div[@ng-hide='noAccount']/strong[2]");
    private final By amountFieldLocator = By.xpath("//input[@placeholder='amount']");
    private final By depositSubmitButtonLocator = By.xpath("//button[text()='Deposit' and @type='submit']");
    private final By withDrawSubmitButtonLocator = By.xpath("//button[text()='Withdraw' and @type='submit']");


    private final By withDrawlButtonLocator = By.xpath("//button[normalize-space(text())='Withdrawl']");
    private final By depositButtonLocator = By.xpath("//button[normalize-space(text())='Deposit']");


    public void login(String fullName) {
        selectOptionFromDropDown(customerNameDropDown, fullName);
        click(loginButtonLocator);
    }

    public String getCurrentBalance() {
        return getText(balanceTextLocator).trim();
    }

    public void depositAmt(String amt) {
        click(depositButtonLocator);
        sendKeys(amountFieldLocator, amt);
        click(depositSubmitButtonLocator);
    }

    public void withDrawAmt(String amt) {
        click(withDrawlButtonLocator);
        sendKeys(amountFieldLocator, amt);
        click(withDrawSubmitButtonLocator);
    }

}