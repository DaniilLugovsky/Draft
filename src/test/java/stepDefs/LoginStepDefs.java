package stepDefs;

import baseEntities.BaseTest;
import baseEntities.BaseTestHook;
import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;

public class LoginStepDefs extends BaseTestHook {
    private BaseTestHook baseTestHook;
    LoginPage loginPage;

    public LoginStepDefs(BaseTestHook baseTestHook) {
        this.baseTestHook = baseTestHook;
    }

    // Подготовительные


    @Given("open login page")
    public void openLoginPage() {
        baseTestHook.driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    // Атамарные
    @When("set username {string}")
    public void setUsername(String username) {
        loginPage.setEmailText(username);
    }

    @When("set password {string}")
    public void setPassword(String password) {
        loginPage.setPasswordText(password);
    }

    @When("user clicks login button")
    public void clickLoginButton() {
        loginPage.clickLogIn();
    }

    // Комплексные
    @When("login with correct username {} and password {}")
    public void setUsername(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    // Проверки

    @Given("login page is opened")
    public void isLoginPageOpened() {
        Assert.assertTrue(loginPage.isPageOpened());
    }
    @Then("dashboard page is opened")
    public void isDashboardPageOpened() {
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        Assert.assertEquals(loginPage.getTextMessage(), "Sorry, there was a problem.\n" +
                "Email/Login or Password is incorrect. Please try again.");
    }

}
