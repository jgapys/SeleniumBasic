package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroppablePage {
    private static final Logger logger = LoggerFactory.getLogger(DroppablePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/droppable.php";

    public DroppablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "draggable")
    private WebElement dragElement;

    @FindBy(id = "droppable")
    private WebElement dropGoal;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void dragAndDropElement(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropGoal).perform();
    }

    public String getTextFromDropGoal() {
        return dropGoal.getText();
    }

}
