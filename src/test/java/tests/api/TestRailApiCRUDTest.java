package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.endpoints.Endpoints;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class TestRailApiCRUDTest extends BaseApiTest {

    public int projectID = 55;
    @Test
    public void createdProjectTest() {
        given()
                .body(TestRailApiCRUDTest.class.getClassLoader().getResourceAsStream("project.json"))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void readProjectTest() {
        Project project = projectService.getProject(60);
        System.out.println(project.toString());
        Assert.assertEquals(project.getName(), "ProjectTest");
    }

    @Test
    public void updateProjectTest() {
        given()
                .pathParam("project_id", projectID)
                .body(TestRailApiCRUDTest.class.getClassLoader().getResourceAsStream("updateProject.json"))
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void deleteProjectTest() {
        given()
                .pathParam("project_id", 60)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all();
    }

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
}
