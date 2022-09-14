package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SelectmenuPage {
    private static final Logger logger = LoggerFactory.getLogger(SelectmenuPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/selectmenu.php";

    public SelectmenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "speed-button")
    private WebElement speedBtn;

    @FindBy(css = "ul#speed-menu .ui-menu-item")
    private List<WebElement> speedMenuItems;

    @FindBy(id = "files-button")
    private WebElement filesBtn;

    @FindBy(css = "ul#files-menu .ui-menu-item")
    private List<WebElement> filesMenuItems;

    @FindBy(id = "number-button")
    private WebElement numberBtn;

    @FindBy(css = "ul#number-menu .ui-menu-item")
    private List<WebElement> numberMenuItems;

    @FindBy(id = "salutation-button")
    private WebElement salutationBtn;

    @FindBy(css = "ul#salutation-menu .ui-menu-item")
    private List<WebElement> salutationMenuItems;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void clickSpeedBtn() {
        speedBtn.click();
    }

    public void getRandomSpeed() {
        Random random = new Random();
        int randomSpeedIndex = random.nextInt(5);
        speedMenuItems.get(randomSpeedIndex).click();
    }

    public void clickFilesBtn() {
        filesBtn.click();
    }

    public void getFileByText(String fileOption) {
        for (WebElement filesMenuItem : filesMenuItems) {
            if (Objects.equals(filesMenuItem.getText(), fileOption)) {
                filesMenuItem.click();
                break;
            }
        }
    }

    public void clickNumberBtn() {
        numberBtn.click();
    }

    public void getNumberByIndex(int numberOption) {
        int numberOptionIndex = numberOption - 1;
        numberMenuItems.get(numberOptionIndex).click();
    }

    public void clickSalutationBtn() {
        salutationBtn.click();
    }

    public void getRandomSalutation() {
        Random random = new Random();
        int randomTitleIndex = random.nextInt(1, 6);
        salutationMenuItems.get(randomTitleIndex).click();
    }
}
