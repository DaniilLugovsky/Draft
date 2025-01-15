package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final By DASHBOARD_PAGE_IDENTIFIER_LOCATOR = By.id("navigation-dashboard");
    private final By MESSAGE_SUCCESSFULLY_ADD_PROJECT_TEXT = By.xpath("//div[@data-testid = 'messageSuccessDivBox']");
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return DASHBOARD_PAGE_IDENTIFIER_LOCATOR;
    }

    public Button getAddProjectButton() {
        return new Button(driver, ADD_PROJECT_BUTTON_LOCATOR);
    }

    public Text getMessageSuccessfullyAddProject() {
        return new Text(driver, MESSAGE_SUCCESSFULLY_ADD_PROJECT_TEXT);
    }

    public void clickAddProjectButton() {
        getAddProjectButton().click();
    }

    public String messageSuccessfullyAddProject() {
        return getMessageSuccessfullyAddProject().getText();
    }
}
