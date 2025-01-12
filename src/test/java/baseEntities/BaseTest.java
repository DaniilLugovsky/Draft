package baseEntities;

import com.github.javafaker.Faker;
import configuration.ReadProperties;
import models.Project;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.DashboardPage;
import pages.LoginPage;
import pages.addProjectPages.ProjectPage;
import services.BrowsersService;
import services.WaitService;
import steps.LoginStep;
import steps.ProjectStep;
import utils.InvokedListener;

import java.util.Random;

import static models.User.*;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected WaitService waitService;
    protected LoginStep loginStep;
    protected ProjectStep projectStep;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectPage projectPage;

    protected Project project;
    protected User user;
    protected Faker faker;
    protected Random random;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitService = new WaitService(driver);

        iTestContext.setAttribute("webdriver",driver);

        loginStep = new LoginStep(driver);
        projectStep = new ProjectStep(driver);

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectPage = new ProjectPage(driver);

        faker = new Faker();
        random = new Random();
        //Создание пользователя с помощью билдера
        user = User
                .builder()
                .email(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}