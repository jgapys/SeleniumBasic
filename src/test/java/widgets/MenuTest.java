package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.widgets.MenuPage;

public class MenuTest extends TestBase {

    @Test
    @DisplayName("Checking for clicking on menu")
    @Tag("widgets")
    @Tag("menu")
    public void checkMenuOperation() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.getWebsiteURL(driver);
        menuPage.clickInMusicMenuOption();
        menuPage.waitUntilSecondMenuIsVisible(driver);
        menuPage.clickInJazzMenuOption();
        menuPage.waitUntilThirdMenuIsVisible(driver);
        menuPage.clickInModernMenuOption();
    }
}