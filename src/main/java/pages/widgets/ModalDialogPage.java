package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ModalDialogPage {
    private static final Logger logger = LoggerFactory.getLogger(ModalDialogPage.class);

    private static final String websiteURL = "https://seleniumui.moderntester.pl/modal-dialog.php";

    public ModalDialogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "create-user")
    private WebElement createUserBtn;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[contains(text(), 'Create an account')]")
    private WebElement createAccountBtn;

    @FindBy(css = "tbody tr")
    private List<WebElement> allRows;

    public void getWebsiteURL(WebDriver driver) {
        driver.get(websiteURL);
        logger.info("Get on: {}", websiteURL);
    }

    public void createNewUser() {
        createUserBtn.click();
    }

    public ModalDialogPage fillNameField(String name) {
        this.name.clear();
        this.name.sendKeys(name);
        return this;
    }

    public ModalDialogPage fillEmailField(String email) {
        this.email.clear();
        this.email.sendKeys(email);
        return this;
    }

    public ModalDialogPage fillPasswordField(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public void fillForm(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
        createAccountBtn.click();
        logger.info("Creating new account for: " + name);
    }

    public String getNewUserInfo() {
        String newUserInfo = allRows.get(1).getText();
        logger.info(newUserInfo);
        return newUserInfo;
    }
}
