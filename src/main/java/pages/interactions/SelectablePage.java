package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectablePage {
    private static final Logger logger = LoggerFactory.getLogger(SelectablePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/selectable.php";

    public SelectablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "feedback")
    private WebElement selectResult;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public String getSelectResultText() {
        String selectResult = this.selectResult.getText();
        logger.info(selectResult);
        return selectResult;
    }

}
