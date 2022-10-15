package XYZBankPages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

public class BankManagerLoginPage extends BasePage {

    //locators
    private final By customerLocator = By.xpath("//button[normalize-space(text())='Customers']");
    private final By openAccountLocator = By.xpath("//button[normalize-space(text())='Open Account']");
    private final By addCustomerLocator = By.xpath("//button[normalize-space(text())='Add Customer']");

    //add customer
    private final By addCustomerSubmitLocator = By.xpath("//button[normalize-space(text())='Add Customer' and @type='submit']");
    private final By postCodeLocator = By.xpath("//input[@placeholder='Post Code']");
    private final By firstNameLocator = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameLocator = By.xpath("//input[@placeholder='Last Name']");

    //open account
    private final By customerDropDown = By.id("userSelect");
    private final By currencyDropDown = By.id("currency");
    private final By processLocator = By.xpath("//button[normalize-space(text())='Process']");

    //customers
    private final By searchFieldLocator = By.xpath("//input[@placeholder='Search Customer']");
    private final By deleteCustomerLocator = By.xpath("//button[normalize-space(text())='Delete']");


    //methods -> locators
    public int addCustomer(String firstName, String LastName, String postCode) {
        click(addCustomerLocator);
        sendKeys(firstNameLocator, firstName);
        sendKeys(lastNameLocator, LastName);
        sendKeys(postCodeLocator, postCode);
        click(addCustomerSubmitLocator);
        int customerID = Integer.parseInt(getAlertText().split(":")[1].trim());
        acceptAlert();
        return customerID;
    }

    public void deleteCustomer(String firstName) {
        click(customerLocator);
        sendKeys(searchFieldLocator, firstName);
        click(deleteCustomerLocator);
    }

    public String createAccountForCustomer(String customerFullName, String currency) {
        click(openAccountLocator);
        selectOptionFromDropDown(customerDropDown, customerFullName);
        selectOptionFromDropDown(currencyDropDown, currency);
        click(processLocator);
        String accountID = getAlertText().split(":")[1].trim();
        acceptAlert();
        return accountID;
    }

    public boolean isCustomerCreated(String firstname){
        click(customerLocator);
        sendKeys(searchFieldLocator,firstname);
        return DriverManager.getDriver().findElements(By.xpath("//tbody//tr")).size()>0;
    }

    public boolean isAccountCreatedForCustomer(String firstname, String accNo){
        click(customerLocator);
        sendKeys(searchFieldLocator,firstname);
        return getText(By.xpath("//td[text()='"+firstname+"']/following-sibling::td[3]")).contains(accNo);
    }
}