package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.widgets.AccordionPage;

public class AccordionTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(AccordionTest.class);

    @Test
    @DisplayName("Checking text inside each section in accordion")
    @Tag("widgets")
    @Tag("accordion")
    public void checkTextInsideAccordionSections() {
        AccordionPage accordionPage = new AccordionPage(driver);
        accordionPage.getWebsiteURL(driver);
        accordionPage.getEachSectionContent();
    }
}