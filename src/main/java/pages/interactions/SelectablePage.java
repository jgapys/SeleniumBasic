package pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectablePage {
    private static final Logger logger = LoggerFactory.getLogger(SelectablePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/selectable.php";

    public SelectablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "feedback")
    private WebElement selectResult;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public StringBuilder selectSeveralItem(WebDriver driver, int[] numbers) {
        Actions actions = new Actions(driver);
        StringBuilder itemText = new StringBuilder("You've selected:");

        for (int i = 0; i < numbers.length; i++) {
            WebElement selectedItem = driver.findElement(By.xpath("//*[contains(text(), 'Item " + numbers[i] + "')]"));
            actions.keyDown(Keys.LEFT_CONTROL).click(selectedItem);
            itemText.append(" #").append(numbers[i]);
            if (numbers.length - i == 1) {
                actions.keyDown(Keys.LEFT_CONTROL).build().perform();
                itemText.append(".");
            }
        }
        logger.info(itemText.toString());
        return itemText;
    }

    public String getSelectResultText() {
        String selectResult = this.selectResult.getText();
        logger.info(selectResult);
        return selectResult;
    }
}
