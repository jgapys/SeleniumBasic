package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class AutocompletePage {
    private static final Logger logger = LoggerFactory.getLogger(AutocompletePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/autocomplete.php";

    public AutocompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(className = "ui-menu-item")
    private List<WebElement> availableOptions;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public AutocompletePage typeInSearchInput(String textToType) {
        searchInput.sendKeys("a");
        logger.info("Type {} in the search input", textToType);
        return this;
    }

    public AutocompletePage getAvailableOptions() {
        String allOptions = "";
        for (WebElement availableOption : availableOptions) {
            allOptions += availableOption.getText() + ", ";
        }
        logger.info("Available options: {}", allOptions);
        return this;
    }

    public WebElement getRandomOption() {
        Random random = new Random();
        int randomOptionIndex = random.nextInt(availableOptions.size());
        return availableOptions.get(randomOptionIndex);
    }

    public AutocompletePage selectRandomAvailableOption(WebElement randomOption) {
        randomOption.click();
        return this;
    }

    public String getSelectedRandomOptionText(WebElement randomOption) {
        return randomOption.getText();
    }

    public String getInputText() {
        return searchInput.getAttribute("textContent");
    }
}