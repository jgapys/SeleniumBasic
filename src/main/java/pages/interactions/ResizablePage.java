package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResizablePage {
    private static final Logger logger = LoggerFactory.getLogger(ResizablePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/resizable.php";

    public ResizablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ui-resizable-se")
    private WebElement bottomRightCorner;

    @FindBy(id = "resizable")
    private WebElement square;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void resizeWindow(int xOffset, int yOffset, WebDriver driver) {
        Actions actions = new Actions(driver);
        int paddingX = 18;
        int paddingY = 18;
        if (xOffset > 0) {
            xOffset += paddingX;
        }
        if (yOffset > 0) {
            yOffset += paddingY;
        }
        actions.clickAndHold(bottomRightCorner).moveByOffset(xOffset, yOffset).release().build().perform();
    }
}
