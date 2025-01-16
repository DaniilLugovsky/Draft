package services;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import utils.endpoints.Endpoints;

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
    public void getProjects() {

    }

    @Override
    public void addProject() {

    }

    @Override
    public void updateProject() {

    }

    @Override
    public void deleteProject() {

    }
}
