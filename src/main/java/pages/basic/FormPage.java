package pages.basic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FormPage {


    private static final Logger logger = LoggerFactory.getLogger(FormPage.class);

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstName;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(id = "inputEmail3")
    private WebElement email;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> gender;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experienceYears;

    @FindBy(id = "gridCheckManualTester")
    private WebElement manualTesterProfession;

    @FindBy(id = "gridCheckAutomationTester")
    private WebElement automationTesterProfession;

    @FindBy(id = "gridCheckOther")
    private WebElement otherProfession;

    @FindBy(id = "selectContinents")
    private WebElement continent;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement file;

    @FindBy(id = "additionalInformations")
    private WebElement addInformations;

    @FindBy(className = "btn-primary")
    private WebElement signInButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    public FormPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public FormPage setRandomGender() {
        WebElement gender = getRandomElement(this.gender);
        for (WebElement gen : this.gender) {
            if (Objects.equals(gen.getText(), gender.getText())) {
                gen.click();
                break;
            }
        }
        return this;
    }

    public FormPage setAge(String age) {
        this.age.sendKeys(age);
        return this;
    }

    public FormPage setRandomExperienceYears() {
        WebElement experienceYear = getRandomElement(this.experienceYears);
        for (WebElement expYear : this.experienceYears) {
            if (Objects.equals(expYear.getText(), experienceYear.getText())) {
                expYear.click();
                break;
            }
        }
        return this;
    }

    public FormPage setManualTesterProfession() {
        manualTesterProfession.click();
        return this;
    }

    public FormPage setAutomationTesterProfession() {
        automationTesterProfession.click();
        return this;
    }

    public FormPage setOtherProfession() {
        otherProfession.click();
        return this;
    }

    public FormPage setRandomContinent() {
        new Select(this.continent).selectByIndex(getRandomIndex(1, 8));
        return this;
    }

    public FormPage setSeleniumCommands(String seleniumCommands) {
        new Select(this.seleniumCommands).selectByVisibleText(seleniumCommands);
        return this;
    }

    public void setSeveralSeleniumCommands(List<String> seleniumCommands, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL);
        for (int i = 0; i < seleniumCommands.size(); i++) {
            new Select(this.seleniumCommands).selectByVisibleText(seleniumCommands.get(i));
            actions.click();
            if (seleniumCommands.size() - i == 1) {
                actions.keyDown(Keys.LEFT_CONTROL).build().perform();
            }
        }
    }

    public FormPage uploadFile(File file) {
        this.file.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage setAdditionalInformations(String addInformations) {
        this.addInformations.sendKeys(addInformations);
        return this;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getValidationMessage() {
        return validatorMessage.getText();
    }

    private WebElement getRandomElement(List<WebElement> webElements) {
        Random random = new Random();
        int randomElementIndex = random.nextInt(webElements.size());
        return webElements.get(randomElementIndex);
    }

    private int getRandomIndex(int minNumber, int maxNumber) {
        Random random = new Random();
        int randomIndex = random.nextInt(minNumber, maxNumber);
        return randomIndex;
    }

}
