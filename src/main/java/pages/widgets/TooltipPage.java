package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TooltipPage {
    private static final Logger logger = LoggerFactory.getLogger(SliderPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/tooltip.php";

    public TooltipPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Tooltips')]")
    private WebElement firstWordTooltip;

    @FindBy(xpath = "//a[contains(text(), 'ThemeRoller')]")
    private WebElement themeRollerTooltip;

    @FindBy(id = "age")
    private WebElement ageInputTooltip;

    @FindBy(className = "ui-tooltip-content")
    private WebElement tooltipContent;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    private TooltipPage moveToViewTooltip(WebDriver driver, WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
        return this;
    }

    public void moveForFirstWordTooltip(WebDriver driver) {
        moveToViewTooltip(driver, firstWordTooltip);
    }

    public void moveForThemeRollerTooltip(WebDriver driver) {
        moveToViewTooltip(driver, themeRollerTooltip);
    }

    public void moveForAgeTooltip(WebDriver driver) {
        moveToViewTooltip(driver, ageInputTooltip);
    }

    public String getTooltipContent() {
        String tooltipContent = this.tooltipContent.getText();
        logger.info(tooltipContent);
        return tooltipContent;
    }
}