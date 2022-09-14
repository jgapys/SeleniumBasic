package interactions;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.interactions.DroppablePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DroppableTest extends TestBase {

    @Test
    @DisplayName("Checking drag&drop for square")
    @Tag("interactions")
    @Tag("droppable")
    public void checkDragAndDrop() {
        DroppablePage droppablePage = new DroppablePage(driver);
        droppablePage.getWebsiteURL(driver);
        droppablePage.dragAndDropElement(driver);
        assertThat(droppablePage.getTextFromDropGoal()).isEqualTo("Dropped!");
    }
}
