package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.widgets.SliderPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(SliderTest.class);

    @Test
    @DisplayName("Moving slider to specified values")
    @Tag("widgets")
    @Tag("slider")
    public void checkSliderValueAfterMovingIt() {
        SliderPage sliderPage = new SliderPage(driver);
        sliderPage.getWebsiteURL(driver);
        sliderPage.movingSliderToValue(50);
        assertThat(sliderPage.getSliderValue()).isEqualTo(50);
        sliderPage.movingSliderToValue(80);
        assertThat(sliderPage.getSliderValue()).isEqualTo(80);
        sliderPage.movingSliderToValue(80);
        assertThat(sliderPage.getSliderValue()).isEqualTo(80);
        sliderPage.movingSliderToValue(20);
        assertThat(sliderPage.getSliderValue()).isEqualTo(20);
        sliderPage.movingSliderToValue(0);
        assertThat(sliderPage.getSliderValue()).isEqualTo(0);
    }
}
