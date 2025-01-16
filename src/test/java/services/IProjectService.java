package services;

import io.restassured.response.Response;
import models.Project;

public interface IProjectService {
    Response getGeneralProject(int id);
    Project getProject(int id);
    Response getProjects();
    Project addProject(Project project);
    Project updateProject(Project project, int id);
    Response deleteProject(int id);
}
