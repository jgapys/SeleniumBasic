package interactions;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.interactions.ResizablePage;

public class ResizableTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(ResizableTest.class);

    @Test
    @DisplayName("Checking the widnow resize")
    @Tag("interactions")
    @Tag("resizable")
    public void checkingWindowResize() {
        ResizablePage resizablePage = new ResizablePage(driver);
        resizablePage.getWebsiteURL(driver);
        resizablePage.resizeWindow(10, 0, driver);
        resizablePage.resizeWindow(0, 10, driver);
        resizablePage.resizeWindow(10, 10, driver);
    }
}
