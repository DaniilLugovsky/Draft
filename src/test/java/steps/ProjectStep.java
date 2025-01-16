package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;

public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Создание проекта")
    public void addProjectSimple(Project project) {
        dashboardPage.clickAddProjectButton();
        projectPage.setNameProject(project.getName());
        projectPage.setAnnouncement(project.getAnnouncement());
        projectPage.choiceShowAnnouncement(project.isShowAnnouncement());
        projectPage.choiceTypeProjectByIndex(project.getSuiteMode());
        projectPage.clickAddProjectButton();
    }
}
