package basic;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.basic.WindowsTabsPage;
import pages.basic.table.TablePage;

public class WindowsTabsTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(WindowsTabsTest.class);

    @Test
    @DisplayName("Checking operation on newly opened tabs and windows")
    @Tag("basic")
    @Tag("windows")
    @Tag("tabs")
    public void checkWindowsAndTabsOperation() {
        WindowsTabsPage windowsTabsPage = new WindowsTabsPage(driver);
        TablePage tablePage = new TablePage(driver);
        windowsTabsPage.getWebsiteURL(driver);

        String windowHandleBefore = driver.getWindowHandle();

        windowsTabsPage.clickNewBrowserWindowBtn();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        tablePage.getAllMountains();
        windowsTabsPage.closeWindow(driver);
        driver.switchTo().window(windowHandleBefore);

        windowsTabsPage.clickNewMessageWindowBtn();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        logger.info(windowsTabsPage.getNewWindowContent());
        windowsTabsPage.closeWindow(driver);
        driver.switchTo().window(windowHandleBefore);

        windowsTabsPage.clickNewBrowserTabBtn();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        tablePage.getAllMountains();
        windowsTabsPage.closeWindow(driver);
    }
}
