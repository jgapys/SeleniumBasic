package basic;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.basic.table.RowPage;
import pages.basic.table.TablePage;

public class TableTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TableTest.class);

    @Test
    @DisplayName("Displaying mountains in Switzerland that are higher than 4000 meters")
    @Tag("basic")
    @Tag("table")
    public void displaySwissMountainsHigherThan4000M() {
        TablePage tablePage = new TablePage(driver);
        tablePage.getWebsiteURL(driver);
        StringBuilder result = new StringBuilder();

        for (RowPage allMountainsData : tablePage.getAllMountains()) {
            if (allMountainsData.getMountainState().contains("Switzerland") && allMountainsData.getMountainHeight() > 4000) {
                result.append(allMountainsData.getMountainName()).append(", ");
            }
        }
        logger.info(String.valueOf(result));
    }
}
