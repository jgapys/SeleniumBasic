package basic;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.basic.AlertPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(AlertsTest.class);

    @Test
    @DisplayName("Checking text for simple alert pop up")
    @Tag("basic")
    @Tag("alert")
    public void checkTextForSimpleAlertPopUp() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.getWebsiteURL(driver);
        alertPage.clickSimpleAlertButton();
        alertPage.switchToAndAcceptSimpleAlert(driver);
        String expectedText = "OK button pressed";
        logger.info("Expected text: " + expectedText + ", actual text: " + alertPage.getSimpleAlertText());
        assertThat(alertPage.getSimpleAlertText()).isEqualTo(expectedText);
    }

    @Test
    @DisplayName("Checking text for prompt alert box after typing in alert text box")
    @Tag("basic")
    @Tag("alert")
    public void checkTextForPromptAlertBox() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.getWebsiteURL(driver);
        alertPage.clickPromptAlertButton();
        Alert promptAlert = alertPage.switchToAlert(driver);
        alertPage.fillPromptAlertTextBox(promptAlert);
        alertPage.acceptPromptAlert(driver, promptAlert);
        String expectedText = "Hello Lord Vader! How are you today?";
        logger.info("Expected text: " + expectedText + ", actual text: " + alertPage.getPromptAlertText());
        assertThat(alertPage.getPromptAlertText()).isEqualTo(expectedText);
    }

    @Test
    @DisplayName("Checking text for confirm alert box for OK option")
    @Tag("basic")
    @Tag("alert")
    public void checkTextForConfirmAlertBox() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.getWebsiteURL(driver);
        alertPage.clickConfirmAlertButton();
        alertPage.switchToAndAcceptConfirmAlert(driver);
        String expectedText = "You pressed OK!";
        logger.info("Expected text: " + expectedText + ", actual text: " + alertPage.getConfirmAlertText());
        assertThat(alertPage.getConfirmAlertText()).isEqualTo(expectedText);
        alertPage.clickConfirmAlertButton();
        alertPage.switchToAndDismissConfirmAlert(driver);
        expectedText = "You pressed Cancel!";
        logger.info("Expected text: " + expectedText + ", actual text: " + alertPage.getConfirmAlertText());
        assertThat(alertPage.getConfirmAlertText()).isEqualTo(expectedText);
    }

    @Test
    @DisplayName("Checking text for delayed alert")
    @Tag("basic")
    @Tag("alert")
    public void checkTextForDelayedAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.getWebsiteURL(driver);
        alertPage.clickDelayedAlertButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        alertPage.switchToAndAcceptDelayedAlert(driver);
        String expectedText = "OK button pressed";
        logger.info("Expected text: " + expectedText + ", actual text: " + alertPage.getDelayedAlertText());
        assertThat(alertPage.getDelayedAlertText()).isEqualTo(expectedText);
    }
}