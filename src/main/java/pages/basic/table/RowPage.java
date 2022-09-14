package pages.basic.table;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RowPage {
    public RowPage(WebElement row) {
        PageFactory.initElements(new DefaultElementLocatorFactory(row), this);
    }

    @FindBy(css = "th")
    private WebElement rank;

    @FindBy(xpath = "td[1]")
    private WebElement peak;

    @FindBy(xpath = "td[2]")
    private WebElement mountainRange;

    @FindBy(xpath = "td[3]")
    private WebElement state;

    @FindBy(xpath = "td[4]")
    private WebElement height;

    public int getMountainRank() {
        return Integer.parseInt(rank.getText());
    }

    public String getMountainName() {
        return peak.getText();
    }

    public String getMountainRange() {
        return mountainRange.getText();
    }

    public String getMountainState() {
        return state.getText();
    }

    public int getMountainHeight() {
        return Integer.parseInt(height.getText());
    }

}