package interactions;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.interactions.DraggablePage;

public class DraggableTest extends TestBase {

    @Test
    @DisplayName("Checking drag for square")
    @Tag("interactions")
    @Tag("draggable")
    public void checkDragForSquare() {
        DraggablePage draggablePage = new DraggablePage(driver);
        draggablePage.getWebsiteURL(driver);
        draggablePage.dragSquareToUpperRight(driver);
        draggablePage.dragSquareToBottomRight(driver);
        draggablePage.dragSquareToCentre(driver);
        draggablePage.dragSquareToBottomLeft(driver);
    }
}