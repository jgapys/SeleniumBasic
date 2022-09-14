package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.widgets.SelectmenuPage;

public class SelectmenuTest extends TestBase {

    @Test
    @DisplayName("Checking the various select menu possibilities")
    @Tag("widgets")
    @Tag("selectmenu")
    public void checkingSelectMenuOptions() {
        SelectmenuPage selectmenuPage = new SelectmenuPage(driver);
        selectmenuPage.getWebsiteURL(driver);
        selectmenuPage.clickSpeedBtn();
        selectmenuPage.getRandomSpeed();
        String text = "Some unknown file";
        selectmenuPage.clickFilesBtn();
        selectmenuPage.getFileByText(text);
        selectmenuPage.clickNumberBtn();
        selectmenuPage.getNumberByIndex(3);
        selectmenuPage.clickSalutationBtn();
        selectmenuPage.getRandomSalutation();
    }
}