package pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortablePage {
    private static final Logger logger = LoggerFactory.getLogger(SortablePage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/sortable.php";

    public SortablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ui-sortable-handle")
    private List<WebElement> items;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public Integer[] shuffleArray(Integer[] numbers) {
        List<Integer> intList = Arrays.asList(numbers);
        Collections.shuffle((intList));
        intList.toArray(numbers);
        String shuffleArray = "";
        for (Integer number : numbers) {
            shuffleArray += number;
        }
        logger.info(shuffleArray);
        return numbers;
    }

    public void moveLikeShuffleArray(Integer[] numbers, WebDriver driver) {
        for (int i = 0; i < numbers.length; i++) {
            WebElement dragElement = driver.findElement(By.xpath("//*[contains(text(), 'Item " + numbers[i] + "')]"));
            WebElement dropGoal = items.get(i);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(dragElement, dropGoal).perform();
        }
    }
}
