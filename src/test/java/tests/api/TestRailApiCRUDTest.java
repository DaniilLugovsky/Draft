package tests.api;

import baseEntities.BaseApiTest;
import io.cucumber.java.bs.A;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.json.TypeToken;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.Project;
import models.Projects;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.endpoints.Endpoints;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestRailApiCRUDTest extends BaseApiTest {

    private Project actualProject;

    @Test
    public void createdProject() {
        Project expectedProject = new Project();
        expectedProject.setName("The Test Project");
        expectedProject.setAnnouncement("This is Announcement");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(1);

        actualProject = projectService.addProject(expectedProject);

        System.out.println(actualProject);
        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test (dependsOnMethods = "createdProject")
    public void readProject() {
        Project project = projectService.getProject(actualProject.getId());
        System.out.println(project);
        Assert.assertEquals(project, actualProject);
    }

    @Test (dependsOnMethods = "createdProject")
    public void updateProject() {
        Project updateProject = new Project();
        updateProject.setName("The Test Project Update");
        updateProject.setAnnouncement("This is Announcement Update");
        updateProject.setShowAnnouncement(false);
        updateProject.setSuiteMode(3);
        Project project = projectService.updateProject(updateProject, actualProject.getId());
        Assert.assertEquals(project.getName(), updateProject.getName());
        Assert.assertEquals(project.getAnnouncement(), updateProject.getAnnouncement());
        Assert.assertEquals(project.isShowAnnouncement(), updateProject.isShowAnnouncement());
    }

    @Test (dependsOnMethods = "createdProject")
    public void deleteProject() {
        Response response = projectService.deleteProject(actualProject.getId());
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }


}
