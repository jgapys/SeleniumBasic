package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.widgets.ModalDialogPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModalDialogTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(ModalDialogTest.class);

    @ParameterizedTest
    @CsvFileSource(resources = "/dataProvider/modalDialogData.csv")
    @DisplayName("Filling form with data provider")
    @Tag("widgets")
    @Tag("modaldialog")
    public void fillingFormWithDataFromDataProvider(String nameFromFile, String emailFromFile, String passwordFromFile) {
        ModalDialogPage modalDialogPage = new ModalDialogPage(driver);
        modalDialogPage.getWebsiteURL(driver);
        modalDialogPage.createNewUser();
        modalDialogPage.fillForm(nameFromFile, emailFromFile, passwordFromFile);
        assertThat(modalDialogPage.getNewUserInfo()).isEqualTo(nameFromFile + " " + emailFromFile + " " + passwordFromFile);
    }
}
