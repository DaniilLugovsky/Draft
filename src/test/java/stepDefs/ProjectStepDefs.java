package stepDefs;

import baseEntities.BaseTest;
import baseEntities.BaseTestHook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.addProjectPages.ProjectPage;
import services.BrowsersService;

public class ProjectStepDefs extends BaseTestHook {
    BaseTestHook baseTestHook;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectPage projectPage;

    @When("user clicks on Add project")
    public void userClicksOnAddProject() {
        dashboardPage = new DashboardPage(baseTestHook.driver);
        dashboardPage.clickAddProjectButton();
    }

    @When("Send Name {string}")
    public void sendNameTextName(String text) {
        projectPage.setNameProject(text);
    }

    @When("Send Announcement {string}")
    public void sendAnnouncementTextName(String text) {
        projectPage.setAnnouncement(text);
    }

    @When("Send IsShouAnnouncement {string}")
    public void isShouAnnouncement(String choose) {
        if(choose.equals("true")) {
            projectPage.choiceShowAnnouncement(true);
        } else if (choose.equals("false")) {
            projectPage.choiceShowAnnouncement(false);
        } else {
            System.out.println("Неправильный выбор, введите true или false");
        }
    }

    @When("Send Type Project {int}")
    public void chooseTypeProject(int type) {
        if (type < 0 || type > 2) {
            System.out.println("Неправильный выбор значение, возможные значения от 1 до 3");
        } else {
            projectPage.choiceTypeProjectByIndex(type);
        }
    }

    @When("Send EnableTCApprovals {string}")
    public void sendEnableTCApprovals(String choose) {
        if(choose.equals("true")) {
            projectPage.choiceEnabledTestCase(true);
        } else if (choose.equals("false")) {
            projectPage.choiceEnabledTestCase(false);
        } else {
            System.out.println("Неправильный выбор, введите true или false");
        }
    }

    @When("user clicks on button add project")
    public void userClicksOnButtonAddProject() {
        projectPage.clickAddProjectButton();
    }
    @When("message Add project is displayed")
    public void messageAddProjectIsDisplayed() {
        Assert.assertEquals(dashboardPage.messageSuccessfullyAddProject(), "Successfully added the new project.");
    }

    @Then("project page is displayed")
    public void projectPageIsDisplayed() {
        projectPage = new ProjectPage(baseTestHook.driver);
        Assert.assertTrue(projectPage.isPageOpened());
    }
}

