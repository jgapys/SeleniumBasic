package interactions;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.interactions.SortablePage;

public class SortableTest extends TestBase {

    @Test
    @DisplayName("Checking element movement")
    @Tag("interactions")
    @Tag("sortable")
    public void checkSortableElementMovement() {
        SortablePage sortablePage = new SortablePage(driver);
        sortablePage.getWebsiteURL(driver);
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        sortablePage.moveLikeShuffleArray(sortablePage.shuffleArray(numbers), driver);
    }
}
