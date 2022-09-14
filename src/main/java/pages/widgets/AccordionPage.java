package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AccordionPage {
    private static final Logger logger = LoggerFactory.getLogger(AccordionPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/accordion.php";

    public AccordionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h3")
    private List<WebElement> sections;

    @FindBy(className = "ui-accordion-content")
    private List<WebElement> sectionContent;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void getEachSectionContent() {
        int index = 0;
        String sectionContent;
        for (WebElement section : sections) {
            section.click();
            logger.info("Click in: {}", section.getText());
            sectionContent = this.sectionContent.get(index++).getAttribute("textContent");
            logger.info("Section content: {}", sectionContent);
        }
    }
}