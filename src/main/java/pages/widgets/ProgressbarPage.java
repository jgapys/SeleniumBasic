package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ProgressbarPage {
    private static final Logger logger = LoggerFactory.getLogger(ProgressbarPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/progressbar.php";

    public ProgressbarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "progress-label")
    private WebElement progressLabel;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void waitingUntilProgressbarComplete(WebDriver driver, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(progressLabel, "textContent", expectedText));
    }

    public String getProgressLabelText() {
        String progressLabelText = progressLabel.getText();
        logger.info(progressLabelText);
        return progressLabelText;
    }
}
