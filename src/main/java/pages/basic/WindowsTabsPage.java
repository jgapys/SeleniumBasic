package pages.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsTabsPage {
    private static final Logger logger = LoggerFactory.getLogger(WindowsTabsPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/windows-tabs.php";

    public WindowsTabsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "newBrowserWindow")
    private WebElement newBrowserWindowButton;

    @FindBy(id = "newMessageWindow")
    private WebElement newMessageWindowButton;

    @FindBy(id = "newBrowserTab")
    private WebElement newBrowserTabButton;

    @FindBy(css = "body")
    private WebElement newWindowContent;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void clickNewBrowserWindowBtn() {
        newBrowserWindowButton.click();
    }

    public void clickNewMessageWindowBtn() {
        newMessageWindowButton.click();
    }

    public void clickNewBrowserTabBtn() {
        newBrowserTabButton.click();
    }

    public String getNewWindowContent() {
        return newWindowContent.getText();
    }

    public void closeWindow(WebDriver driver) {
        driver.close();
    }
}
