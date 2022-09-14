package pages.basic.table;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage {

    private static final Logger logger = LoggerFactory.getLogger(TablePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/table.php";

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    public List<WebElement> allMountains;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public List<RowPage> getAllMountains() {
        List<RowPage> allMountains = new ArrayList<>();
        for (WebElement mountain : this.allMountains) {
            allMountains.add(new RowPage(mountain));
        }
        return allMountains;
    }
}
