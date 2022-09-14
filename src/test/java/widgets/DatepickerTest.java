package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.widgets.DatepickerPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DatepickerTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(DatepickerTest.class);

    @Test
    @DisplayName("Checking datepicker for different dates")
    @Tag("widgets")
    @Tag("datepicker")
    public void checkDateInDatepicker() {
        DatepickerPage datepickerPage = new DatepickerPage(driver);
        datepickerPage.getWebsiteURL(driver);

        logger.info("Test for todays date");
        datepickerPage.clickInDatepicker();
        int currentYear = datepickerPage.getCurrentYear();
        int currentMonth = datepickerPage.getCurrentMonth();
        int currentDay = datepickerPage.getCurrentDay();
        datepickerPage.selectDate(currentYear, currentMonth, currentDay);
        assertThat(datepickerPage.getDatepickerInput()).isEqualTo(datepickerPage.getExpectedDate(currentYear, currentMonth, currentDay));
    }
}
