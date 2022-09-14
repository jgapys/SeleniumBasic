package widgets;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.widgets.AutocompletePage;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteTest extends TestBase {

    @Test
    @DisplayName("Checking random option for autocomplete for letter A")
    @Tag("widgets")
    @Tag("autocomplete")
    public void checkRandomOptionForAutocompleteForA() {
        AutocompletePage autocompletePage = new AutocompletePage(driver);
        autocompletePage.getWebsiteURL(driver);
        autocompletePage.typeInSearchInput("a");
        autocompletePage.getAvailableOptions();
        WebElement randomOption = autocompletePage.getRandomOption();
        autocompletePage.selectRandomAvailableOption(randomOption);
        assertThat(autocompletePage.getInputText()).isEqualTo(autocompletePage.getSelectedRandomOptionText(randomOption));
    }
}