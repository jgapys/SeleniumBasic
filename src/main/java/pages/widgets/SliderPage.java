package pages.widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SliderPage {
    private static final Logger logger = LoggerFactory.getLogger(SliderPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/slider.php";

    public SliderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "custom-handle")
    private WebElement slider;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public int getSliderValue() {
        return Integer.parseInt(slider.getText());
    }

    public SliderPage movingSliderToValue(int value) {
        int valueToShift = 0;
        if (value > getSliderValue()) {
            valueToShift = value - getSliderValue();
            for (int i = 0; i < valueToShift; i++) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            }
        } else {
            valueToShift = getSliderValue() - value;
            for (int i = 0; i < valueToShift; i++) {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }
        logger.info("Slider value: {}", slider.getText());
        logger.info("Value to shift: {}", String.valueOf(value));

        return this;
    }
}
