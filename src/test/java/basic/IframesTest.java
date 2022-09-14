package basic;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.basic.IFramesPage;

public class IframesTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(IframesTest.class);

    @Test
    @DisplayName("Checking switching between IFrames")
    @Tag("basic")
    @Tag("iframe")
    public void checkSwitchingBetweenIFrames() {
        IFramesPage iFramesPage = new IFramesPage(driver);
        iFramesPage.getWebsiteURL(driver);
        iFramesPage.switchToFrame(driver, "iframe1");
        iFramesPage.fillFormInFirstFrame("Jan", "Kowalski");
        iFramesPage.switchToDefaultContent(driver);
        iFramesPage.switchToFrame(driver, "iframe2");
        iFramesPage.fillFormInSecondFrame("jankowal", "pass123", "europe", 3);
        iFramesPage.switchToDefaultContent(driver);
        iFramesPage.clickMainMenu(1);
    }
}
