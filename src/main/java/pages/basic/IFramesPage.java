package pages.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IFramesPage {
    private static final Logger logger = LoggerFactory.getLogger(IFramesPage.class);
    private static final String websiteURL = "https://seleniumui.moderntester.pl/iframes.php";

    public IFramesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstName;

    @FindBy(id = "inputSurname3")
    private WebElement surname;

    @FindBy(css = "button")
    private WebElement signInButtonFrame1;

    @FindBy(id = "inputLogin")
    private WebElement login;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "inlineFormCustomSelectPref")
    private WebElement continent;

    @FindBy(className = "form-check-input")
    private List<WebElement> experienceYears;

    @FindBy(css = "button")
    private WebElement signInButtonFrame2;

    @FindBy(css = "a.nav-link")
    private List<WebElement> menuOptions;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void switchToFrame(WebDriver driver, String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void fillFormInFirstFrame(String firstName, String surname) {
        this.firstName.sendKeys(firstName);
        this.surname.sendKeys(surname);
        this.signInButtonFrame1.click();
        logger.info("Form in first frame completed");
    }

    public void fillFormInSecondFrame(String login, String password, String continent, int experienceYears) {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        Select select = new Select(this.continent);
        select.selectByValue(continent);
        this.experienceYears.get(experienceYears).click();
        this.signInButtonFrame2.click();
        logger.info("Form in second frame completed");
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void clickMainMenu(int menuNumber) {
        int menuIndex = menuNumber - 1;
        menuOptions.get(menuIndex).click();
    }
}
