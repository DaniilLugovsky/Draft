package pages.addProjectPages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import elements.Input;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    private final By PAGE_IDENTIFIER_LOCATOR = By.xpath("//div[contains(text(), 'Add Project')]");
    private final By NAME_PROJECT_INPUT_LOCATOR = By.id("name");
    private final By ANNOUNCEMENT_INPUT_LOCATOR = By.id("announcement_display");
    private final By SHOW_THE_ANNOUNCEMENT_CHECK_BOX_LOCATOR = By.id("show_announcement");
    private final By PROJECT_TYPE_RADIOBUTTON = By.name("suite_mode");
    private final By ENABLED_TESTCASE_CHECKBOX = By.id("case_statuses_enabled");
    private final By ADD_PROJECT_BUTTON = By.id("accept");
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return PAGE_IDENTIFIER_LOCATOR;
    }

    public Input getNameProject() {
        return new Input(driver, NAME_PROJECT_INPUT_LOCATOR);
    }

    public Input getAnnouncement() {
        return new Input(driver, ANNOUNCEMENT_INPUT_LOCATOR);
    }

    public CheckBox getShowTheAnnouncement() {
        return new CheckBox(driver, SHOW_THE_ANNOUNCEMENT_CHECK_BOX_LOCATOR);
    }

    public RadioButton getTypeProjectRadioButton() {
        return new RadioButton(driver, PROJECT_TYPE_RADIOBUTTON);
    }

    public CheckBox getEnabledTestCaseEnabledCheckBox() {
        return new CheckBox(driver, ENABLED_TESTCASE_CHECKBOX);
    }

    public Button getAddProjectButton() {
        return new Button(driver, ADD_PROJECT_BUTTON);
    }


    public void setNameProject(String text) {
        getNameProject().write(text);
    }

    public void setAnnouncement(String text) {
        getAnnouncement().write(text);
    }

    public void choiceShowAnnouncement(boolean choice) {
        getShowTheAnnouncement().setCheckBox(choice);
    }

    public void choiceTypeProjectByIndex(int index) {
        getTypeProjectRadioButton().selectByIndex(index);
    }

    public void choiceEnabledTestCase(boolean choice) {
        getEnabledTestCaseEnabledCheckBox().setCheckBox(choice);
    }

    public void clickAddProjectButton() {
        getAddProjectButton().click();
    }
}
