package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.widgets.ProgressbarPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressbarTest extends TestBase {

    @Test
    @DisplayName("Waiting until progressbar will be complete")
    @Tag("widgets")
    @Tag("progressbar")
    public void waitUntilProgressbarComplete() {
        ProgressbarPage progressbarPage = new ProgressbarPage(driver);
        progressbarPage.getWebsiteURL(driver);
        String expectedText = "Complete!";
        progressbarPage.waitingUntilProgressbarComplete(driver, expectedText);
        assertThat(progressbarPage.getProgressLabelText()).isEqualTo("Complete!");
    }
}