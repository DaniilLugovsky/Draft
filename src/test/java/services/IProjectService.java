package services;

import io.restassured.response.Response;
import models.Project;

public interface IProjectService {
    Response getGeneralProject(int id);
    Project getProject(int id);
    Response getProjects();
    void addProject();
    void updateProject();
    void deleteProject();
}