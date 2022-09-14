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

public class MenuPage {
    private static final Logger logger = LoggerFactory.getLogger(MenuPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/menu-item.php";

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Music')]")
    private WebElement musicMenuOption;

    @FindBy(xpath = "//*[contains(text(), 'Jazz')]")
    private WebElement jazzMenuOption;

    @FindBy(xpath = "//*[contains(text(), 'Modern')]")
    private WebElement modernMenuOption;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void clickInMusicMenuOption() {
        musicMenuOption.click();
        logger.info("Click in music");
    }

    public void clickInJazzMenuOption() {
        jazzMenuOption.click();
        logger.info("Click in jazz");
    }

    public void clickInModernMenuOption() {
        modernMenuOption.click();
        logger.info("Click in modern");
    }

    public void waitUntilSecondMenuIsVisible(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(jazzMenuOption));
    }

    public void waitUntilThirdMenuIsVisible(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modernMenuOption));
    }
}
