package basic;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.basic.FormPage;

import java.io.File;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormTest extends TestBase {

    @Test
    @DisplayName("Checking the correct completion of the form which ending with success")
    @Tag("basic")
    @Tag("form")
    public void fillFormWithSuccess() {
        FormPage formPage = new FormPage(driver);
        formPage.getWebsiteURL(driver);

        File file = new File("src/main/resources/uploadFiles/SeleniumBasic.pdf");
        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("jkowalski@gmail.com")
                .setRandomGender()
                .setAge("25")
                .setRandomExperienceYears()
                .setAutomationTesterProfession()
                .setRandomContinent()
                .uploadFile(file);
        formPage.setSeveralSeleniumCommands(Arrays.asList("Switch Commands", "Wait Commands"), driver);
        formPage.clickSignInButton();

        assertThat(formPage.getValidationMessage()).isEqualTo("Form send with success");

    }
}
