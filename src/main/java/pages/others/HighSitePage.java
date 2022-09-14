package pages.others;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HighSitePage {
    private static final Logger logger = LoggerFactory.getLogger(HighSitePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/high-site.php";

    public HighSitePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "high-site")
    private WebElement websiteHeight;

    @FindBy(id = "scroll-button")
    private WebElement submitButton;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public int getWebSiteHeight() {
        return websiteHeight.getSize().height;
    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("src/test/screenshots/highSiteTest" + formatter.format(date) + ".png"));
        logger.info("Screenshot is captured");
    }

    public void scrollWebsiteAndTakeSS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        for (int i = 0; i < (getWebSiteHeight() / windowHeight); i++) {
            int indexScroll = i + 1;
            try {
                this.submitButton.isDisplayed();
                takeScreenshot(driver);
                break;
            } catch (Exception ex) {
                js.executeScript("window.scrollBy(0," + windowHeight / 2 + ");");
                logger.info("Scroll number " + indexScroll + " by: " + windowHeight / 2);
            }
        }
    }
}
