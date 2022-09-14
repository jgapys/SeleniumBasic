package interactions;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.interactions.SelectablePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectableTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(SelectableTest.class);

    @Test
    @DisplayName("Checking text for selected item")
    @Tag("interactions")
    @Tag("selectable")
    public void checkSelectItem() {
        SelectablePage selectablePage = new SelectablePage(driver);
        selectablePage.getWebsiteURL(driver);
        int[] numbers = {1, 3, 4};
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
        assertThat(itemText.toString()).isEqualTo(selectablePage.getSelectResultText());
    }
}
