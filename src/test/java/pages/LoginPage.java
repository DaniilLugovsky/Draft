package pages;

import baseEntities.BasePage;
import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By LOGIN_PAGE_IDENTIFIER_LOCATOR = By.xpath("//a[@class = 'logo-loginpage']");
    private final By EMAIL_INPUT_LOCATOR = By.id("name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private final By LOGIN_BUTTON_LOCATOR = By.id("button_primary");
    private final By LOGIN_PAGE_MESSAGE_LOCATOR = By.xpath("//div[@class = 'loginpage-message-title ']");
    private final By LOGIN_PAGE_MESSAGE_TEXT_LOCATOR = By.xpath("//div[@class = 'error-text']");
    private final By KEEP_ME_LOGGED_CHECKBOX_LOCATOR = By.id("rememberme");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return LOGIN_PAGE_IDENTIFIER_LOCATOR;
    }

    public UIElement getMessage() {
        return new UIElement(driver, LOGIN_PAGE_MESSAGE_LOCATOR);
    }
    public Text textMessage() {
        return new Text(driver, LOGIN_PAGE_MESSAGE_TEXT_LOCATOR);
    }
    public Input getEmailInput() {
        return new Input(driver, EMAIL_INPUT_LOCATOR);
    }
    public Input getPasswordInput() {
        return new Input(driver, PASSWORD_INPUT_LOCATOR);
    }
    public Button getLogInButton() {
        return new Button(driver, LOGIN_BUTTON_LOCATOR);
    }
    public CheckBox getKeepMeLoggedCheckBox() {return new CheckBox(driver, KEEP_ME_LOGGED_CHECKBOX_LOCATOR);}
    public void setEmailText(String text) {
        getEmailInput().write(text);
    }
    public void setPasswordText(String text) {
        getPasswordInput().write(text);
    }
    public void clickLogIn() {
        getLogInButton().click();
    }
    public void choiceGetKeepMe(boolean choice) {
        getKeepMeLoggedCheckBox().setCheckBox(choice);
    }
    public void getTextMessage() {
        getMessage().getText();
    }
}
