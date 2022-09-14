package interactions;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.interactions.SelectablePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectableTest extends TestBase {

    @Test
    @DisplayName("Checking text for selected item")
    @Tag("interactions")
    @Tag("selectable")
    public void checkSelectItem() {
        SelectablePage selectablePage = new SelectablePage(driver);
        selectablePage.getWebsiteURL(driver);
        int[] numbers = {1, 3, 4};
        StringBuilder itemText = selectablePage.selectSeveralItem(driver, numbers);
        assertThat(itemText.toString()).isEqualTo(selectablePage.getSelectResultText());
    }
}
