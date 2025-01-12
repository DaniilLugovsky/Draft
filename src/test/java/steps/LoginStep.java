package steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }
    @Step(value = "Успешный логин")
    public void successfulLogin(User user) {
        loginPage.setEmailText(user.getEmail());
        loginPage.setPasswordText(user.getPassword());
        loginPage.clickLogIn();
    }

    @Step(value = "Не успешый логин")
    public void unSuccessfulLogin() {
        loginPage.setEmailText("sdfadsg");
        loginPage.setPasswordText(ReadProperties.password());
        loginPage.clickLogIn();
    }


}
