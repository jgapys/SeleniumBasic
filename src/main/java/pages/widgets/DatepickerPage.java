package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class DatepickerPage {
    private static final Logger logger = LoggerFactory.getLogger(DatepickerPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/datepicker.php";

    public DatepickerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "datepicker")
    private WebElement datepicker;

    @FindBy(className = "ui-datepicker-year")
    private WebElement datepickerYear;

    @FindBy(className = "ui-datepicker-month")
    private WebElement datepickerMonth;

    @FindBy(className = "ui-state-highlight")
    private WebElement datepickerDay;

    @FindBy(css = "td :not(.ui-priority-secondary)")
    private List<WebElement> allDatePickerDays;

    @FindBy(className = "ui-datepicker-prev")
    private WebElement prevArrow;

    @FindBy(className = "ui-datepicker-next")
    private WebElement nextArrow;

    @FindBy(css = "input")
    private WebElement datepickerInput;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public DatepickerPage clickInDatepicker() {
        datepicker.click();
        return this;
    }

    public int getCurrentDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date();
        return Integer.parseInt(formatter.format(date));
    }

    public int getCurrentMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        Date date = new Date();
        return Integer.parseInt(formatter.format(date));
    }

    public int getCurrentYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return Integer.parseInt(formatter.format(date));
    }

    public String getYearFromDatepicker() {
        return datepickerYear.getText();
    }

    public String getMonthFromDatepicker() {
        return datepickerMonth.getText();
    }

    public String getDayFromDatepicker() {
        return datepickerDay.getText();
    }

    public int getYearFromDatepickerAsInt() {
        return Integer.parseInt(getYearFromDatepicker());
    }

    public int getMonthFromDatepickerAsInt() {
        return Month.valueOf(getMonthFromDatepicker().toUpperCase()).getValue();
    }

    public void checkYear(int year) {
        while (year != getYearFromDatepickerAsInt()) {
            if (year < getYearFromDatepickerAsInt()) {
                prevArrow.click();
            } else {
                nextArrow.click();
            }
            getYearFromDatepicker();
        }
    }

    public void checkMonth(int month) {
        while (month != getMonthFromDatepickerAsInt()) {
            if (month < getMonthFromDatepickerAsInt()) {
                prevArrow.click();
            } else {
                nextArrow.click();
            }
            getMonthFromDatepickerAsInt();
        }
    }

    public void checkDay(int day) {
        allDatePickerDays.get(day - 1).click();
    }

    public void selectDate(int year, int month, int day) {
        checkYear(year);
        checkMonth(month);
        checkDay(day);
    }

    public String getDatepickerInput() {
        return datepickerInput.getAttribute("value");
    }

    public String getExpectedDate(int year, int month, int day) {
        return String.format("%02d", month) + "/" + String.format("%02d", day) + "/" + year;
    }
}