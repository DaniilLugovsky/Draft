package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.endpoints.Endpoints;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest extends BaseApiTest {

    @Test
    public void getApiTest() {

        int projectID = 48;
        String endpoint = "/index.php?/api/v2/get_project/" + projectID;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("id", is(48))
                .extract().jsonPath().get("id");
    }

    @Test
    public void GetApiTestWithExtract() {

        int projectID = 48;
        String endpoint = "/index.php?/api/v2/get_project/" + projectID;

        String name = given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("id", is(48))
                .extract().jsonPath().get("name");

        System.out.println(name);
        Assert.assertEquals("Name", name);
    }

    @Test
    public void getApiTestResponse() {

        String endpoint = "/index.php?/api/v2/get_project/{project_id}";
        int projectID = 48;
        Response response = given()
                .pathParam("project_id", projectID)
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("id", is(48))
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().getString("name"), "Name");
    }

    @Test
    public void postApiTestResponse() {

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_01");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(1);

        String endpoint = "index.php?/api/v2/add_project";
        given()
                .body(String.format("{\n" +
                                "    \"name\": \"%s\",\n" +
                                "    \"announcement\": \"%s\",\n" +
                                "    \"show_announcement\": %b,\n" +
                                "    \"suite_mode\": %d\n" +
                                "}",
                        expectedProject.getName(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isShowAnnouncement(),
                        expectedProject.getSuiteMode()))
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void postApiTestResponseMap() {

        Project expectedProject = new Project();
        expectedProject.setName("Project");
        expectedProject.setAnnouncement("This is show test announcement.");
        expectedProject.setShowAnnouncement(false);
        expectedProject.setSuiteMode(1);

        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("name", expectedProject.getName());
        jsonAsMap.put("suite_mode", expectedProject.getSuiteMode());

        String endpoint = "index.php?/api/v2/add_project";
        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }


    @Test
    public void postApiTestResponseObject() {

        given()
                .body(TestRailApiTest.class.getClassLoader().getResourceAsStream("project.json"))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void deleteAllProject() {
        int i;
        for (i = 0; i < 100; i++) {
            Response response = projectService.deleteProject(i);
        }

    }

}
