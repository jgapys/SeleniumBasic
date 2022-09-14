package pages.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertPage {
    private static final Logger logger = LoggerFactory.getLogger(AlertPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/alerts.php";

    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "simple-alert")
    private WebElement simpleAlertButton;

    @FindBy(id = "simple-alert-label")
    private WebElement simpleAlertLabel;

    @FindBy(id = "prompt-alert")
    private WebElement promptAlertButton;

    @FindBy(id = "prompt-label")
    private WebElement promptAlertLabel;

    @FindBy(id = "confirm-alert")
    private WebElement confirmAlertButton;

    @FindBy(id = "confirm-label")
    private WebElement confirmAlertLabel;

    @FindBy(id = "delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(id = "delayed-alert-label")
    private WebElement delayedAlertLabel;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void clickSimpleAlertButton() {
        simpleAlertButton.click();
    }

    public void switchToAndAcceptSimpleAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public String getSimpleAlertText() {
        return simpleAlertLabel.getText();
    }

    public void clickPromptAlertButton() {
        promptAlertButton.click();
    }

    public Alert switchToAlert(WebDriver driver) {
        return driver.switchTo().alert();
    }

    public void fillPromptAlertTextBox(Alert promptAlert) {
        promptAlert.sendKeys("Lord Vader");
        logger.info("Type 'Lord Vader' in the prompt alert text box");
    }

    public void acceptPromptAlert(WebDriver driver, Alert promptAlert) {
        promptAlert.accept();
    }

    public String getPromptAlertText() {
        return promptAlertLabel.getText();
    }

    public void clickConfirmAlertButton() {
        confirmAlertButton.click();
    }

    public void switchToAndAcceptConfirmAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void switchToAndDismissConfirmAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getConfirmAlertText() {
        return confirmAlertLabel.getText();
    }

    public void clickDelayedAlertButton() {
        delayedAlertButton.click();
    }

    public void switchToAndAcceptDelayedAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public String getDelayedAlertText() {
        return delayedAlertLabel.getText();
    }
}