package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.Project;
import models.Projects;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.endpoints.Endpoints;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestRailApiAllCrudTest extends BaseApiTest {
    @Test
    public void testCRUDProject() {
        //Created
        int projectId = given()
                .body(TestRailApiCRUDTest.class.getClassLoader().getResourceAsStream("project.json"))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getInt("id");
        //Read
        given()
                .pathParam("project_id", projectId)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
        //Update
        given()
                .pathParam("project_id", projectId)
                .body(TestRailApiCRUDTest.class.getClassLoader().getResourceAsStream("updateProject.json"))
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
        //Delete
        given()
                .pathParam("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllProjectAsType() {
        Response response = projectService.getProjects();
        List<Projects> projectsList = response.getBody().jsonPath().getList("projects");
        System.out.println(projectsList.get(1));
    }

    @Test
    public void getAllProject() {
        Response response = projectService.getProjects();
        Project[] projects = response.getBody().jsonPath().getObject("projects", Project[].class);
        System.out.println(projects.length);
        System.out.println(projects[0]);
        System.out.println(projects[1]);
    }

    @Test
    public void getAllProjectAsObject() {
        Response response = projectService.getProjects();
        Projects projects = response.getBody().as(Projects.class);
        System.out.println(projects.toString());
        System.out.println(projects.getProjects()[0]);
    }

    @Test
    public void updateProject() {
        given()
                .pathParam("project_id", 9)//id project
                .body(TestRailApiCRUDTest.class.getClassLoader().getResourceAsStream("updateProject.json"))
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
