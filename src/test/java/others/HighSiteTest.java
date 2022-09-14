package others;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.others.HighSitePage;

public class HighSiteTest extends TestBase {

    @Test
    @DisplayName("Scrolling page until Submit button is visible and taking SS")
    @Tag("others")
    @Tag("highsite")
    public void scrollingSiteUntilSubmitButtonIsVisible() {
        HighSitePage highSitePage = new HighSitePage(driver);
        highSitePage.getWebsiteURL(driver);
        highSitePage.scrollWebsiteAndTakeSS(driver);
    }
}