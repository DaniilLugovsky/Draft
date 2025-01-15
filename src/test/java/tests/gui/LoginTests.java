package tests.gui;

import baseEntities.BaseTest;
import com.sun.source.tree.AssertTree;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Успtшный вход", testName = "Test name")
    @Description("Тест проверка")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("sadasd")
    @Link(name = "allureLink", type = "myLink", url = "https://www.youtube.com/watch?v=F8BMxX4E440&list=RDgfV_Doo9UHU&index=27")
    public void loginTest() {
        loginStep.successfulLogin(user);
        dashboardPage.isPageOpened();
    }

    @Test(description = "Не успешный вход")
    @Severity(SeverityLevel.CRITICAL)
    public void notLoginTest() {
        loginStep.unSuccessfulLogin();
        Assert.assertEquals(loginPage.getTextMessage(),"Sorry, there was a problem.\n" +
                "Email/Login or Password is incorrect. Please try again.");
        loginPage.getMessage().isDisplayed();
    }
}
