package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    Logger logger = LogManager.getLogger(AddProjectTest.class);




    @Test(description = "Тест на создание проекта", testName = "Create project")
    @Severity(SeverityLevel.CRITICAL)
    public void addProject(){
        //Параметры проекта
        String projectName = faker.name().firstName();
        String announcement = faker.book().title();
        boolean isShouAnnouncement = faker.random().nextBoolean();
        int projectType = faker.random().nextInt(0,2);
        boolean enableTCApprovals = faker.random().nextBoolean();

        project = Project.builder()
                .name(projectName)
                .announcement(announcement)
                .isShowAnnouncement(isShouAnnouncement)
                .projectType(projectType)
                .isEnableTCApprovals(enableTCApprovals)
                .build();

                /*.setName(projectName);
        project.setAnnouncement(announcement);
        project.setShowAnnouncement(isShouAnnouncement);
        project.setProjectType(projectType);
        project.setEnableTCApprovals(enableTCApprovals);*/
        logger.info(project.toString());
        loginStep.successfulLogin(user);
        projectStep.addProjectSimple(project);
        Assert.assertEquals(dashboardPage.messageSuccessfullyAddProject(), "Successfully added the new project.");
    }
}
