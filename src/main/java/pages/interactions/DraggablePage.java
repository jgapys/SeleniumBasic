package pages.interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DraggablePage {
    private static final Logger logger = LoggerFactory.getLogger(DraggablePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/draggable.php";

    public DraggablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "draggable")
    private WebElement square;

    @FindBy(id = "droppable")
    private WebElement dropGoal;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public int getSquareWidth() {
        return square.getSize().width;
    }

    public int getSquareHeight() {
        return square.getSize().height;
    }

    public int getSquareXLocation() {
        return square.getLocation().x;
    }

    public int getSquareYLocation() {
        return square.getLocation().y;
    }

    public void dragSquare(WebDriver driver, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(square, xOffset, yOffset).build().perform();
    }

    public void dragSquareToUpperRight(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowWidth = (Long) js.executeScript("return window.innerWidth;");
        int xOffset = (int) (windowWidth - getSquareXLocation() - getSquareWidth());
        int yOffset = -getSquareYLocation();
        dragSquare(driver, xOffset, yOffset);
    }

    public void dragSquareToBottomRight(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowWidth = (Long) js.executeScript("return window.innerWidth;");
        Long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        int xOffset = (int) (windowWidth - getSquareXLocation() - getSquareWidth());
        int yOffset = (int) (windowHeight - getSquareYLocation() - getSquareHeight());
        dragSquare(driver, xOffset, yOffset);
    }

    public void dragSquareToCentre(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowWidth = (Long) js.executeScript("return window.innerWidth;");
        Long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        int xOffset = (int) (windowWidth / 2 - getSquareXLocation() - getSquareWidth() / 2);
        int yOffset = (int) (windowHeight / 2 - getSquareYLocation() - getSquareHeight() / 2);
        dragSquare(driver, xOffset, yOffset);
    }

    public void dragSquareToBottomLeft(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        int xOffset = -getSquareXLocation();
        int yOffset = (int) (windowHeight - getSquareYLocation() - getSquareHeight());
        dragSquare(driver, xOffset, yOffset);
    }
}
