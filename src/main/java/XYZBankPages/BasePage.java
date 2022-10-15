package XYZBankPages;

import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import util.SleepHelper;

public class BasePage {

    //reusable methods

    protected WebElement waitUntilVisible(By locator) {

        return DriverManager.getExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected Alert waitUntilAlertIsPresent() {
        return DriverManager.getExplicitWait().until(ExpectedConditions.alertIsPresent());
    }

    protected void click(By locator) {
        waitUntilVisible(locator).click();
        SleepHelper.sleep(1000);
    }

    protected void sendKeys(By locator, String text) {
        waitUntilVisible(locator).clear();
        waitUntilVisible(locator).sendKeys(text);
        SleepHelper.sleep(1000);
    }

    protected void selectOptionFromDropDown(By locator, String visibleText) {
        waitUntilVisible(locator);
        Select select = new Select(DriverManager.getDriver().findElement(locator));
        select.selectByVisibleText(visibleText);
        SleepHelper.sleep(500);
    }

    protected String getText(By locator) {
        return waitUntilVisible(locator).getText().trim();
    }

    protected void acceptAlert() {
        waitUntilAlertIsPresent().accept();
        SleepHelper.sleep(500);
    }

    protected String getAlertText() {
        return waitUntilAlertIsPresent().getText().trim();
    }

}