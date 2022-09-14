package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.widgets.TooltipPage;

public class TooltipTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TooltipTest.class);

    @Test
    @DisplayName("Checking message from tooltip")
    @Tag("widgets")
    @Tag("tooltip")
    public void checkMessageFromTooltip() {
        TooltipPage tooltipPage = new TooltipPage(driver);
        tooltipPage.getWebsiteURL(driver);
        tooltipPage.moveForAgeTooltip(driver);
        tooltipPage.getTooltipContent();
    }
}
