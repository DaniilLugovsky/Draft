package services;

import com.google.gson.Gson;
import io.cucumber.java.an.E;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.TestRailApiTest;
import utils.endpoints.Endpoints;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import static io.restassured.RestAssured.given;

public class ProjectService implements IProjectService{
    @Override
    public Response getGeneralProject(int id) {
        return given()
                .pathParam("project_id", id)
                //.log().all()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .extract().response();
    }

    @Override
    public Project getProject(int id) {
        return given()
                .pathParam("project_id", id)
                //.log().all()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().
                as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public Response getProjects() {
        return given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    @Override
    public Project addProject(Project project) {
        return given()
                .body(project)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public Project updateProject(Project project, int id) {
        return given()
                .pathParam("project_id", id)
                .body(project)
                .log().body()
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .extract().as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public Response deleteProject(int id) {
        return given()
                .pathParam("project_id", id)
                .log().body()
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .log().all()
                .extract().response();
    }
}
